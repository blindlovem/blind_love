package com.example.loveapp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.loveapp.entity.Romantic;

import java.util.List;

/**
 * <p>
 * 情话表：每天提供用户3句话，用户可以选择其中的1句发送出去。 提供功能：用户可以提供情话给我们，当相似度低于0.6一下加入。 服务类
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-18
 */
public interface IRomanticService extends IService<Romantic> {

    /**
     * 根据随机生成的三个id
     * 查询得到三局情话

     * @return
     */

    public List<Romantic> getThrWords();
}
