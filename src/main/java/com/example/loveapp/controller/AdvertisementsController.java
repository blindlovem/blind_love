package com.example.loveapp.controller;


import com.example.loveapp.entity.Advertisements;
import com.example.loveapp.mapper.AdvertisementsMapper;
import com.example.loveapp.service.IAdvertisementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advertisements")
public class AdvertisementsController {

    @Autowired
    IAdvertisementsService advertisementsService;

    /**
     * 查询所有广告信息,按照点击数排序
     * @return
     */
    @GetMapping
    public List<Advertisements> selectAll(){
        List<Advertisements> advertisementsList = advertisementsService.selectAll();
        advertisementsList.sort((o1, o2) -> o2.getClickCount() - o1.getClickCount());
        return advertisementsList;
    }


    /**
     * 相应点击广告事件，点击次数加1，并且返回广告详情
     * @param id
     */
    @GetMapping("/{id}")
    @Transactional
    public Advertisements increaseClickCount(@PathVariable Integer id) {
        Advertisements advertisement = advertisementsService.getById(id);
        //System.out.println(id);
        //System.out.println(advertisement);
        if (advertisement != null) {
            advertisement.setClickCount(advertisement.getClickCount() + 1);
            //advertisementsService.save(advertisement);
            advertisementsService.updateById(advertisement);
        }

        return advertisementsService.getById(id);
    }



    @Autowired
    AdvertisementsMapper advertisementsMapper;


    /**
     * 根据关键词查询
     * @param key
     * @return
     */
    @PostMapping
    public List<Advertisements> selectByKey(@RequestParam String key){
        System.out.println("*********");
        key = "%" + key + "%";
        System.out.println(key);

        return advertisementsMapper.selectByKey(key);
    }


}
