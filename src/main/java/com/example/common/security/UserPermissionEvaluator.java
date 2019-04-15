package com.example.common.security;

import com.example.common.jwt.JwtTokenUtil;
import com.example.domain.Power;
import com.example.domain.User;
import com.example.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName UserPermissionEvaluator
 * @Description TODO
 * @Author hao
 * @Date 2019/4/12 15:43
 **/
@Component
public class UserPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PowerService powerService;

    @Override
    public boolean hasPermission(Authentication authentication, Object url, Object permission) {
        // 1.获取当前登录用户
        User user = jwtTokenUtil.getLoginUser();

        // 2.获取登录用户所属角色获取权限列表

        List<Power> powerList = powerService.getListByRoleId(user.getRoleId());

        // 3.查询权限表，如果url(路径)和permission(动作)相等，则返回true
        if(null != powerList && powerList.size() > 0){
            for(Power power : powerList){
                //这里暂且使用权限名称对应permission
                if(url.equals(power.getUrl()) && permission.equals(power.getName())){
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
