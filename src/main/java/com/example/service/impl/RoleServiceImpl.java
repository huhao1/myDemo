package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.util.IdWorker;
import com.example.domain.Role;
import com.example.domain.vo.RoleVo;
import com.example.mapper.RoleMapper;
import com.example.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hao
 * @since 2019-03-27
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private IdWorker idWorker;

    private QueryWrapper<Role> getQueryWrapper(RoleVo roleVo){
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();

        if(StringUtils.isNotBlank(roleVo.getId())){
            queryWrapper.eq("id", roleVo.getId());
        }

        if(StringUtils.isNotBlank(roleVo.getName())){
            queryWrapper.eq("name", roleVo.getName());
        }

        if(StringUtils.isNotBlank(roleVo.getCode())){
            queryWrapper.eq("code", roleVo.getCode());
        }

        return queryWrapper;
    }

    @Override
    public Role selectOne(RoleVo roleVo){
        return roleMapper.selectOne(getQueryWrapper(roleVo));
    }

    @Override
    public Role insert(Role role){
        if(StringUtils.isBlank(role.getId())){
            role.setId(idWorker.create());
        }
        this.save(role);
        return roleMapper.selectById(role.getId());
    }

}
