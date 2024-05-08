package com.example.loveapp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.loveapp.entity.Romantic;
import com.example.loveapp.entity.Sendword;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>
 * 提供一个按钮，当用户点击时，会随机找出三句情话，用户进行选择 Mapper 接口
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-18
 */
@Mapper
public interface SendwordMapper extends BaseMapper<Sendword> {

    /**
     * 查看用户收到的情话记录
     *
     * @param id
     * @return
     */
    @Select("select * from tb_sendword where received_id = #{id}")
    public List<Sendword> selectByRecId( String id);


    /**
     * 查看用户选择记录
     * @param id
     * @return
     */
    @Select("select * from tb_sendword where user_id = #{id}")
    public List<Sendword> selectBySendId( String id);


}
