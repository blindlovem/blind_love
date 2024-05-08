package com.example.loveapp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.loveapp.entity.Showself;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>
 * 展示表：我要爆照。用户可以选择是否公开自己进行爆照 服务类
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-18
 */
public interface IShowselfService extends IService<Showself> {

    public List<Showself> selectAll();
    public List<Showself> selectById(String id);
}
