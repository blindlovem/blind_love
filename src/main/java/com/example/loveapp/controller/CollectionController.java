package com.example.loveapp.controller;



import com.example.loveapp.entity.Collection;
import com.example.loveapp.service.ICollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    ICollectionService collectionService;


    /**
     * 新增：用户点击收藏，存储下来
     * @param collection
     * @return
     */
    @PostMapping
    public boolean save(@RequestBody Collection collection){
        System.out.println("收藏陈功");
        return collectionService.save(collection);
    }


    /**
     * 查询用户收藏的礼物
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public List<Collection> selectAll(@PathVariable String id){
        List<Collection> list = new ArrayList<Collection>();
        System.out.println("查询陈功");

        for (Collection c : collectionService.selectAll(id)){
            if (c.getDeleted().equals(0)){
                list.add(c);
            }
        }

        return list;
    }


    /**
     * 根据collection表的主键删除收藏记录
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Integer id){
        return collectionService.removeById(id);
    }
}
