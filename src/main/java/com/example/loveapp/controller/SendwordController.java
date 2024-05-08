package com.example.loveapp.controller;


import com.example.loveapp.entity.Pickrecord;
import com.example.loveapp.entity.Romantic;
import com.example.loveapp.entity.Sendword;
import com.example.loveapp.entity.User;
import com.example.loveapp.service.IRomanticService;
import com.example.loveapp.service.ISendwordService;
import com.example.loveapp.service.IUserService;
import com.example.loveapp.service.impl.PickrecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 提供一个按钮，当用户点击时，会随机找出三句情话，用户进行选择 前端控制器
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-18
 */
@RestController
@RequestMapping("/sendword")
public class SendwordController {

    @Autowired
    ISendwordService sendwordService;

    @Autowired
    IUserService userService;

    @Autowired
    IRomanticService romanticService;



    /**
     * 点击发送后：保存发送记录
     * @param sendword 发送详情
     * @return 成功
     */
    @PostMapping
    public boolean save(@RequestBody Sendword sendword){

        return sendwordService.save(sendword);

    }

    /**
     * 删除一条记录
     * @param id 指定记录
     * @return 成功
     */
    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Integer id){
       return sendwordService.removeById(id);
    }



// TODO 实现功能：检测自己是否接收消息

    /**
     * 用户点击时，就会弹出收到的消息
     * @return 指定用户收到的消息记录列表
     */
    @GetMapping("/{id}")
    public List<Sendword> selectByRecId(@PathVariable String id){
        List<Sendword> sendwords = sendwordService.selectByRecId(id);

        List<String> res = new ArrayList<>();

        for (Sendword s:sendwords){
            Romantic word = romanticService.getById(s.getWordId());
            User user = userService.getById(s.getUserId());
            // TODO 确保前端可以根据id显示数据
        }


        return sendwordService.selectByRecId(id);
    }





}

