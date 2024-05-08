package com.example.loveapp.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.loveapp.entity.Advertisements;
import com.example.loveapp.entity.Collection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CollectionMapper extends BaseMapper<Collection> {


    /**
     * 查看用户收藏的礼物
     * @return
     */
    @Select("select * from collection where user_id = #{id}")
    public List<Collection> selectAll(String id);



}
