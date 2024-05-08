package com.example.loveapp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.loveapp.entity.Advertisements;
import com.example.loveapp.entity.Collection;

import java.util.List;

public interface ICollectionService extends IService<Collection> {

    public List<Collection> selectAll(String id);
}
