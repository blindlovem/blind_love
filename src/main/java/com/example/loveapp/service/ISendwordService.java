package com.example.loveapp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.loveapp.entity.Romantic;
import com.example.loveapp.entity.Sendword;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 提供一个按钮，当用户点击时，会随机找出三句情话，用户进行选择 服务类
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-18
 */
public interface ISendwordService extends IService<Sendword> {

    public List<Sendword> selectAll();
    public List<Sendword> selectByRecId( String id);



}
