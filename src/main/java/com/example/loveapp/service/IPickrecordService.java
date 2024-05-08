package com.example.loveapp.service;

import com.example.loveapp.entity.Pickrecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.loveapp.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-02
 */
public interface IPickrecordService extends IService<Pickrecord> {

    /**
     * 得到用户选择的算法
     * @param id 1
     * @return 1
     */
    String findMethod(String id);

    public List<User> selectuserById(String id);


    //查询所有匹配记录
    public List<Pickrecord> selectAllByPicker_idById(String id);
}
