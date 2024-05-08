package com.example.loveapp.service;

import com.example.loveapp.entity.Blindbox;
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
public interface IBlindboxService extends IService<Blindbox> {
    public List<Blindbox> selectAll();


    public List<Blindbox> selectById(String id);
}
