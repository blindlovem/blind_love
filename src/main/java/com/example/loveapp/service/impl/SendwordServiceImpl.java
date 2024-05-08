package com.example.loveapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.loveapp.entity.Romantic;
import com.example.loveapp.entity.Sendword;
import com.example.loveapp.entity.User;
import com.example.loveapp.mapper.SendwordMapper;
import com.example.loveapp.service.ISendwordService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * <p>
 * 提供一个按钮，当用户点击时，会随机找出三句情话，用户进行选择 服务实现类
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-18
 */
@Service
public class SendwordServiceImpl extends ServiceImpl<SendwordMapper, Sendword> implements ISendwordService {

    @Autowired
    SendwordMapper sendwordMapper;

    @Override
    public List<Sendword> selectAll() {
        QueryWrapper<Sendword> queryWrapper = new QueryWrapper<Sendword>();

        return sendwordMapper.selectList(queryWrapper);
    }

    @Override
    public List<Sendword> selectByRecId(String id) {
        return sendwordMapper.selectByRecId(id);
    }





}
