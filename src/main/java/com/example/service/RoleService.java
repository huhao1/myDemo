package com.example.service;

import com.example.domain.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.vo.RoleVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hao
 * @since 2019-03-27
 */
public interface RoleService extends IService<Role> {

    /**
     * 动态条件查询单个
     * @param roleVo
     * @return
     */
    Role selectOne(RoleVo roleVo);

    /**
     * 添加
     * @param role
     * @return
     */
    Role insert(Role role);

}
