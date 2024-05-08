package com.example.loveapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.loveapp.entity.Blindbox;
import com.example.loveapp.entity.User;
import com.example.loveapp.mapper.UserMapper;
import com.example.loveapp.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        return userMapper.selectList(queryWrapper);
    }

    @Override
    public User getById(String id) {
        return userMapper.selectById(id);
    }
}
