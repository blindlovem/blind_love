package com.example.loveapp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.loveapp.entity.Photo;
import com.example.loveapp.mapper.PhotoMapper;
import com.example.loveapp.service.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class PhotoServiceImpl extends ServiceImpl<PhotoMapper, Photo> implements IPhotoService {

    @Autowired
    private PhotoMapper photoMapper;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public void uploadPhoto(String name, String description, MultipartFile file) throws IOException {
        // 生成唯一的文件名
        String fileName = UUID.randomUUID().toString() + "." + getFileExtension(file);
        // 创建目标文件
        Path targetPath = Paths.get(uploadDir, fileName);
        Files.copy(file.getInputStream(), targetPath);
        // 存储照片信息到数据库
        Photo photo = new Photo();
        photo.setName(name);
        photo.setDescription(description);
        photo.setPath(targetPath.toString());
        photoMapper.insert(photo);
    }

    // 获取文件扩展名
    private String getFileExtension(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        int dotIndex = originalFileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : originalFileName.substring(dotIndex + 1);
    }
}
