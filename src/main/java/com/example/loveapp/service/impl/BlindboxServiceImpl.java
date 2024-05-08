package com.example.loveapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.loveapp.entity.Blindbox;
import com.example.loveapp.mapper.BlindboxMapper;
import com.example.loveapp.service.IBlindboxService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.format.DataFormatDetector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.Date;
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
public class BlindboxServiceImpl extends ServiceImpl<BlindboxMapper, Blindbox> implements IBlindboxService {
    @Autowired
    private BlindboxMapper blindboxMapper;

    @Override
    public List<Blindbox> selectAll(){
        QueryWrapper<Blindbox> queryWrapper = new QueryWrapper<Blindbox>();
        List<Blindbox> blindboxes = blindboxMapper.selectList(queryWrapper);
        return blindboxes;

    }

    /**
     * 查询投递记录
     * @param id 1
     * @return 1
     */
    @Override
    public List<Blindbox> selectById(String id){
       return blindboxMapper.selectById(id);
    }
}




























