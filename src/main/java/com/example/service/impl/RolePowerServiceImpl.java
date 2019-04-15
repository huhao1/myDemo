package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.util.IdWorker;
import com.example.domain.RolePower;
import com.example.domain.vo.RolePowerVo;
import com.example.mapper.RolePowerMapper;
import com.example.service.RolePowerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hao
 * @since 2019-03-27
 */
@Service
public class RolePowerServiceImpl extends ServiceImpl<RolePowerMapper, RolePower> implements RolePowerService {

    @Autowired
    private RolePowerMapper rolePowerMapper;

    @Autowired
    private IdWorker idWorker;

    private QueryWrapper<RolePower> getQueryWrapper(RolePowerVo rolePowerVo){
        QueryWrapper<RolePower> queryWrapper = new QueryWrapper<>();

        if(StringUtils.isNotBlank(rolePowerVo.getRoleId())){
            queryWrapper.eq("role_id", rolePowerVo.getRoleId());
        }

        if(StringUtils.isNotBlank(rolePowerVo.getId())){
            queryWrapper.eq("id", rolePowerVo.getId());
        }

        if(StringUtils.isNotBlank(rolePowerVo.getPowerId())){
            queryWrapper.eq("power_id", rolePowerVo.getPowerId());
        }

        return queryWrapper;
    }

    @Override
    public List<RolePower> getList(RolePowerVo rolePowerVo){
        return rolePowerMapper.selectList(getQueryWrapper(rolePowerVo));
    }

    @Override
    public RolePower insert(RolePower rolePower){
        if(StringUtils.isNotBlank(rolePower.getId())){
            rolePower.setId(idWorker.create());
        }
        this.save(rolePower);
        return rolePowerMapper.selectById(rolePower.getId());
    }

}
