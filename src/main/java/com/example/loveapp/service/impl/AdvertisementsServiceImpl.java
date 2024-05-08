package com.example.loveapp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.loveapp.entity.Advertisements;
import com.example.loveapp.mapper.AdvertisementsMapper;
import com.example.loveapp.service.IAdvertisementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdvertisementsServiceImpl extends ServiceImpl<AdvertisementsMapper, Advertisements> implements IAdvertisementsService {

    @Autowired
    AdvertisementsMapper advertisementsMapper;

    @Override
    public List<Advertisements> selectAll() {
        return advertisementsMapper.selectAll();
    }
}
