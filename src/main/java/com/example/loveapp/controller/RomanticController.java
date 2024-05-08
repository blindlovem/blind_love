package com.example.loveapp.controller;


import com.example.loveapp.entity.Pickrecord;
import com.example.loveapp.entity.Romantic;
import com.example.loveapp.entity.User;
import com.example.loveapp.service.IRomanticService;
import com.example.loveapp.service.IUserService;
import com.example.loveapp.service.impl.PickrecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * 情话表：每天提供用户3句话，用户可以选择其中的1句发送出去。 //提供功能：用户可以提供情话给我们，当相似度低于0.6一下加入。 前端控制器
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-18
 */
@RestController
@RequestMapping("/romantic")
public class RomanticController {

    @Autowired
    IRomanticService romanticService;

    /**
     * 点击按钮弹出三句情话。
     * @return 三局情话
     */
    @GetMapping
    public List<Romantic> getThrWords(){
        return romanticService.getThrWords();
    }

    @Autowired
    PickrecordServiceImpl pickrecordService;

    @Autowired
    IUserService userService;

    /**
     *
     * @param id 发送情话的用户
     * @return 返回id用户匹配到过的所有用户
     */
    @GetMapping("/{id}")
    public List<User> getPickedsNameById(@PathVariable String id){
        List<Pickrecord> pickrecords = pickrecordService.selectAllByPicker_idById(id);
        System.out.println(pickrecords);
        List<User> res = new ArrayList<>();
        for (Pickrecord p : pickrecords){

            System.out.println(p);
            res.add(userService.getById(p.getPickedId()));
        }

        System.out.println(id);
        System.out.println(res);
        return res;
    }
}

