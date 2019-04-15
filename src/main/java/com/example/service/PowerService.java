package com.example.service;

import com.example.domain.Power;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.vo.PowerVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hao
 * @since 2019-03-27
 */
public interface PowerService extends IService<Power> {

    /**
     * 添加
     * @param power
     * @return
     */
    Power insert(Power power);

    /**
     * 动态条件查询列表
     * @param powerVo
     * @return
     */
    List<Power> getList(PowerVo powerVo);

    /**
     * 根据角色id查询其权限列表
     * @param roleId
     * @return
     */
    List<Power> getListByRoleId(String roleId);

}
