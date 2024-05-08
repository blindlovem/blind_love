package com.example.loveapp.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.loveapp.entity.User;
import com.example.loveapp.service.IUserService;
import com.example.loveapp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  前端控制器  用户注册、修改；
 *              查询用户信息功能
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-02
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    /**
     * 添加用户信息
     * @param user  用户
     * @return 1
     */
    @PostMapping
    public boolean save(@RequestBody User user){

        if (userService.selectAll().isEmpty()){
            return userService.save(user);
        }else {
            List<User> users = userService.selectAll();
            for (User u:
                 users) {
                if (Objects.equals(u.getId(), user.getId())){
                    return false;
                }
            }
        }

        System.out.println(user);

        return userService.save(user);
        //return user.getId();
    }


    /**
     * 更新、修改信息
     * @param user 1
     * @return 1
     */
    @PutMapping("/{id}")
    public boolean update(@RequestBody User user){

        //Wrapper<User> uw = new QueryWrapper<>();
        System.out.println(user);
        return userService.updateById(user);
        //return userService.update(user,uw);
    }


    /**
     * 查询全部
     * @return 1
     */
    @GetMapping
    public List<User> selectAll(){
        return userService.selectAll();
    }

    /**
     * 根据id查询
     * @param id 1
     * @return 1
     */
    @GetMapping("/{id}")
    public User selectById(@PathVariable String id){
        System.out.println(userService.getById(id));
        return userService.getById(id);
    }



}

