package com.example.loveapp.mapper;

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
public interface BlindboxMapper extends BaseMapper<Blindbox> {
    /**
     * 查询投递记录
     * @param id 1
     * @return 1
     */
    @Select("select * from tb_blindbox where user_id = #{id}")
    public List<Blindbox> selectById(String id);
}
