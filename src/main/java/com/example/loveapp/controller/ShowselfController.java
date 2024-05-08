package com.example.loveapp.controller;


import com.example.loveapp.entity.Showself;
import com.example.loveapp.service.IShowselfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 展示表：我要爆照。用户可以选择是否公开自己进行爆照 前端控制器
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-18
 */
@RestController
@RequestMapping("/showself")
public class ShowselfController {
/*
* 涉及 ： 添加记录：查询记录：查询用户记录：
*
*
* */

    @Autowired
    IShowselfService showselfService;

    /**
     * 添加/保存记录
     * @param showself 参数
     * @return 成功
     */
    @PostMapping
    public boolean save(@RequestBody Showself showself){
        return showselfService.save(showself);
    }

    @GetMapping
    public List<Showself> selectAll(){
        return showselfService.selectAll();
    }

    @GetMapping("/{id}")
    public List<Showself> selectById(@PathVariable String id){
        return showselfService.selectById(id);
    }

}

