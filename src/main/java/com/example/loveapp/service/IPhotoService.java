package com.example.loveapp.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.example.loveapp.entity.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IPhotoService extends IService<Photo> {
    void uploadPhoto(String name, String description, MultipartFile file) throws IOException;
}

