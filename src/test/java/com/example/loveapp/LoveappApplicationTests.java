package com.example.loveapp;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.loveapp.entity.Blindbox;
import com.example.loveapp.entity.User;
import com.example.loveapp.mapper.BlindboxMapper;
import com.example.loveapp.mapper.UserMapper;
import com.example.loveapp.service.IBlindboxService;
import com.example.loveapp.service.impl.UserServiceImpl;
import com.example.loveapp.util.constellation.ConstellationMatch;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@SpringBootTest
class LoveappApplicationTests {

    //private UserServiceImpl userService;
    @Autowired
    private IBlindboxService blindboxService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private BlindboxMapper blindboxMapper;

    @Test
    void contextLoads() {
        //List<Blindbox> blindboxes = blindboxService.selectAll();
//        System.out.println(blindboxes);
//
//
//        Wrapper<Blindbox> qm = new QueryWrapper<>();
//        List<Blindbox> blindboxes1 = blindboxMapper.selectList(qm);
//        System.out.println(blindboxes1);
//
//
//        Blindbox byId = blindboxService.getById(1);
//        //byId.setCreateAt("100000");
//        System.out.println(byId);
//
//        //blindboxService.updateById(byId);

        List<User> users = userService.selectAll();
        User user = userService.getById(1);

        List<User> matchUsers = ConstellationMatch.matchUsers(user, users);
        System.out.println(matchUsers);
    }


    @Test
    void text(){
        System.out.println("tehbe");
    }



}
