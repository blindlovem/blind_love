package com.example.loveapp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.loveapp.entity.Advertisements;
import com.example.loveapp.entity.Pickrecord;

import java.util.List;

public interface IAdvertisementsService extends IService<Advertisements> {

    public List<Advertisements> selectAll();
}
