package com.example.loveapp.service.impl;

import com.example.loveapp.entity.Pickrecord;
import com.example.loveapp.entity.User;
import com.example.loveapp.mapper.PickrecordMapper;
import com.example.loveapp.service.IPickrecordService;
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
public class PickrecordServiceImpl extends ServiceImpl<PickrecordMapper, Pickrecord> implements IPickrecordService {

    @Autowired
    PickrecordMapper pickrecordMapper;

    /**
     * 得到用户选择的算法
     * @param id 1
     * @return 1
     */
    @Override
    public String findMethod(String id) {
        return pickrecordMapper.selectById(id).getMethod();
    }

    /**
     * 获取匹配成功用户的信息
     * @param id
     * @return
     */
    @Override
    public List<User> selectuserById(String id) {
        return pickrecordMapper.selectuserById(id);
    }

    /**
     * 查询匹配记录
     * @param id
     * @return
     */
    @Override
    public List<Pickrecord> selectAllByPicker_idById(String id) {
        return pickrecordMapper.selectAllByPicker_idById(id);
    }
}
