package com.example.loveapp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.example.loveapp.entity.Photo;
import org.apache.ibatis.annotations.Mapper;
//TODO: 再改
import com.example.loveapp.entity.Blindbox;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-02
 */
@Mapper
public interface PhotoMapper extends BaseMapper<Photo> {

    @Select("select * from tb_photo where user_id = #{id}")
    Photo getByUser(String id);
}
