package com.example.loveapp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.loveapp.entity.Advertisements;
import com.example.loveapp.entity.Collection;
import com.example.loveapp.mapper.AdvertisementsMapper;
import com.example.loveapp.mapper.CollectionMapper;
import com.example.loveapp.service.IAdvertisementsService;
import com.example.loveapp.service.ICollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection> implements ICollectionService {

    @Autowired
    CollectionMapper collectionMapper;

    @Override
    public List<Collection> selectAll(String id) {
        return collectionMapper.selectAll(id);
    }
}
