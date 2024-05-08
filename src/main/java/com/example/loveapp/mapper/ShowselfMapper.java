package com.example.loveapp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.loveapp.entity.Showself;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 展示表：我要爆照。用户可以选择是否公开自己进行爆照 Mapper 接口
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-18
 */
@Mapper
public interface ShowselfMapper extends BaseMapper<Showself> {

    @Select("select * from tb_showself where user_id = #{id}")
    public List<Showself> selectById(String id);
}
