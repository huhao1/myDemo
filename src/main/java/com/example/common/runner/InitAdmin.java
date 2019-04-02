package com.example.common.runner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.util.Constants;
import com.example.common.util.IdWorker;
import com.example.domain.Role;
import com.example.domain.User;
import com.example.mapper.RoleMapper;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @ClassName InitAdmin
 * @Description TODO
 * @Author hao
 * @Date 2019/4/1 16:06
 **/
@Component
public class InitAdmin implements ApplicationRunner {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception{

        // 1.创建管理员角色
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
        roleQueryWrapper.eq("code", Constants.role.Admin.getValue());
        Role role = roleMapper.selectOne(roleQueryWrapper);
        if(null == role){
            Role model = new Role();

            model.setId(idWorker.create());
            model.setName("管理员");
            model.setCode(Constants.role.Admin.getValue());
            roleMapper.insert(model);
        }

        // 2.创建管理员账号
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("role_code",Constants.role.Admin.getValue());
        User user = userMapper.selectOne(userQueryWrapper);
        if(null == user){

            QueryWrapper<Role> roleWrapper = new QueryWrapper<>();
            roleQueryWrapper.eq("code", Constants.role.Admin.getValue());
            Role role1 = roleMapper.selectOne(roleWrapper);

            User model = new User();

            model.setId(idWorker.create());
            model.setName("admin");
            model.setMobile("admin");
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            final String pwd = "123456";
            model.setPassword(encoder.encode(pwd));
            model.setRoleId(role1.getId());
            model.setRoleCode(role1.getCode());
            model.setRoleName(role1.getName());

            userMapper.insert(model);
        }

    }

}
