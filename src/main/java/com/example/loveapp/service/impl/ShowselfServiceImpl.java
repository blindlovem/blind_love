package com.example.loveapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.loveapp.entity.Showself;
import com.example.loveapp.entity.User;
import com.example.loveapp.mapper.ShowselfMapper;
import com.example.loveapp.service.IShowselfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 展示表：我要爆照。用户可以选择是否公开自己进行爆照 服务实现类
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-18
 */
@Service
public class ShowselfServiceImpl extends ServiceImpl<ShowselfMapper, Showself> implements IShowselfService {

    @Autowired
    ShowselfMapper showselfMapper;


    @Override
    public List<Showself> selectAll() {
        QueryWrapper<Showself> queryWrapper = new QueryWrapper<Showself>();
        return showselfMapper.selectList(queryWrapper);
    }

    @Override
    public List<Showself> selectById(String id) {

        return showselfMapper.selectById(id);
    }


}
