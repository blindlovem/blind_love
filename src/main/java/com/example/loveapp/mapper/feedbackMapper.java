package com.example.loveapp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.loveapp.entity.Blindbox;
import com.example.loveapp.entity.Feedback;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface feedbackMapper extends BaseMapper<Feedback> {

    @Select("select * from feedback where user_id = #{id}")
    public List<Feedback> selectAllById(String id);

    @Select("select id from feedback where word_id = #{id}")
    public Integer  selectRById(Integer id);
}
