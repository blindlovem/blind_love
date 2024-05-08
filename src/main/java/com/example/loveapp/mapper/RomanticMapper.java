package com.example.loveapp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.loveapp.entity.Romantic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 情话表：每天提供用户3句话，用户可以选择其中的1句发送出去。 提供功能：用户可以提供情话给我们，当相似度低于0.6一下加入。 Mapper 接口
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-18
 */
@Mapper
public interface RomanticMapper extends BaseMapper<Romantic> {

    /**
     * 根据随机生成的三个id
     * 查询得到三局情话
     * @param x
     * @param y
     * @param z
     * @return
     */
    @Select("select * from tb_romantic where id = #{x} or id = #{y} or id = #{z}")
    public List<Romantic> getThrWords(Integer x, Integer y, Integer z);


    /**
     * 根据标签查询清华
     * @param tag
     * @return
     */
    @Select("select * from tb_romantic where tag = #{tag}")
    List<Romantic> findRomanticByTag(String tag);

    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_romantic")
    List<Romantic> selectAll();


    @Select("select DISTINCT tag from tb_romantic")
    List<String> selectTag();
}
