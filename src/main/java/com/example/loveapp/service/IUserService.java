package com.example.loveapp.service;

import com.example.loveapp.entity.Blindbox;
import com.example.loveapp.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-02
 */
public interface IUserService extends IService<User> {
    public List<User> selectAll();
    public User getById(String id);
}
