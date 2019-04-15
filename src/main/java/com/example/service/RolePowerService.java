package com.example.service;

import com.example.domain.RolePower;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.vo.RolePowerVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hao
 * @since 2019-03-27
 */
public interface RolePowerService extends IService<RolePower> {

    /**
     * 动态条件查询列表
     * @param rolePowerVo
     * @return
     */
    List<RolePower> getList(RolePowerVo rolePowerVo);

    /**
     * 添加
     * @param rolePower
     * @return
     */
    RolePower insert(RolePower rolePower);

}
