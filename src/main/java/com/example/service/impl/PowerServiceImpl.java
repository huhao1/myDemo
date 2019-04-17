package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.util.IdWorker;
import com.example.domain.Power;
import com.example.domain.vo.PowerVo;
import com.example.mapper.PowerMapper;
import com.example.service.PowerService;
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
public class PowerServiceImpl extends ServiceImpl<PowerMapper, Power> implements PowerService {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private PowerMapper powerMapper;

    private QueryWrapper<Power> getQueryWrapper(PowerVo powerVo){
        QueryWrapper<Power> queryWrapper = new QueryWrapper<>();

        if(StringUtils.isNotBlank(powerVo.getId())){
            queryWrapper.eq("id", powerVo.getId());
        }

        return queryWrapper;
    }

    @Override
    public Power insert(Power power){
        if(StringUtils.isBlank(power.getId())){
            power.setId(idWorker.create());
        }
        this.save(power);
        return powerMapper.selectById(power.getId());
    }

    @Override
    public List<Power> getList(PowerVo powerVo){
        return powerMapper.selectList(getQueryWrapper(powerVo));
    }

    @Override
    public List<Power> getListByRoleId(String roleId){
        return powerMapper.getListByRoleId(roleId);
    }

}
