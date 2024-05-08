package com.example.loveapp.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import com.example.loveapp.entity.Photo;
import com.example.loveapp.mapper.PhotoMapper;
import com.example.loveapp.service.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 提供添加照片、查询照片
 */

@Controller
public class PhotoController {

    @Autowired
    private IPhotoService photoService;

    @Autowired
    PhotoMapper mapper;

    @Value("${file.upload-dir}")
    private String uploadDir;


    /*
    首先，选择请求方法为POST，然后选择Body选项卡。
在Body选项卡下，选择form-data格式对。于文件类型的键值对，你需要在Value列中选择File选项，并选择要上传的文件。在Filename列中，输入文件名。
设置Content-Type头为multipart/form-data，
    * */



    @PostMapping("/photos")
    public ResponseEntity<String> uploadPhoto(@RequestParam(value = "name", required = false) String name,
                                              @RequestParam(value = "description", required = false) String description,
                                              @RequestParam("file") MultipartFile file,
                                              @RequestParam(value = "userId", required = false) String userId) {
        // 生成文件名，避免文件名冲突
        String fileName = UUID.randomUUID().toString() + "." + StringUtils.getFilenameExtension(file.getOriginalFilename());

        // 将照片保存到本地文件系统
        try {
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(fileName);
            Files.write(filePath, file.getBytes());
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to save file", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        // 将照片信息保存到数据库中
        Photo photo = new Photo();
        photo.setPath(fileName);

        if (name != null) {
            photo.setName(name);
        }

        if (description != null) {
            photo.setDescription(description);
        }

        System.out.println("***************");
        photo.setUserId(userId);


        photoService.save(photo);

        return ResponseEntity.ok("File uploaded successfully");
    }


    /**
     * 查看指定用户的传入照片
     * @param id 用户
     * @return  图片
     * @throws IOException 文件
     */
    // TODO 照片这里需要重新改 5.22/19.08分
    @GetMapping("/photos/{id}")
    public ResponseEntity<byte[]> getPhotoById(@PathVariable String id) throws IOException {
        System.out.println("*************************");
        //Photo photo = photoService.getById(id);
        Photo photo = mapper.getByUser(id);
        if (photo == null) {
            return ResponseEntity.notFound().build();
        }

        Path filePath = Paths.get(uploadDir).resolve(photo.getPath());

        // 将照片读取为字节数组并返回
        byte[] fileContent = Files.readAllBytes(filePath);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentLength(fileContent.length);
        headers.setContentDispositionFormData("attachment", photo.getPath());

        System.out.println(fileContent);
        return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
    }



    @DeleteMapping("/photos/{id}")
    public boolean deletePhotoById(@PathVariable Long id) throws IOException {
        Photo photo = photoService.getById(id);
        return true;
        // TODO 对应数据库重新设计
    }
}
