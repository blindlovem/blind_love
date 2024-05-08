package com.example.loveapp.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.loveapp.entity.Advertisements;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdvertisementsMapper extends BaseMapper<Advertisements> {


    @Select("select * from advertisements")
    public List<Advertisements> selectAll();


    /**
     * 根据关键词查询：要求处理参数，使其前后带有%
     * @param keyword
     * @return
     */
    @Select("SELECT * FROM advertisements WHERE title LIKE #{keyword} or description LIKE #{keyword}")
    List<Advertisements> selectByKey(String keyword);
}
