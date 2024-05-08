package com.example.loveapp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.loveapp.entity.AdPhoto;
import com.example.loveapp.entity.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IAdPhotoService extends IService<AdPhoto> {
    void uploadPhoto(String name, String description, MultipartFile file) throws IOException;
}

