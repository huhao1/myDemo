package com.example.mapper;

import com.example.domain.Power;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hao
 * @since 2019-03-27
 */
public interface PowerMapper extends BaseMapper<Power> {

    /**
     * 根据角色id查询其权限列表
     * @param roleId
     * @return
     */
    List<Power> getListByRoleId(String roleId);

}
