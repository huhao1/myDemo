package com.example.common.runner;

import com.example.common.constants.RoleEnum;
import com.example.common.util.IdWorker;
import com.example.domain.Power;
import com.example.domain.Role;
import com.example.domain.RolePower;
import com.example.domain.User;
import com.example.domain.vo.PowerVo;
import com.example.domain.vo.RolePowerVo;
import com.example.domain.vo.RoleVo;
import com.example.domain.vo.UserVo;
import com.example.service.PowerService;
import com.example.service.RolePowerService;
import com.example.service.RoleService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName InitAdmin
 * @Description 运行时创建管理员账号
 * @Author hao
 * @Date 2019/4/1 16:06
 **/
@Component
public class InitAdmin implements ApplicationRunner {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PowerService powerService;

    @Autowired
    private RolePowerService rolePowerService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception{

        // 1.获取管理员角色
        Role role = getAdminRole();

        // 2.为管理员角色配置权限
        setAdminPower(role);

        // 3.获取管理员账号
        User user = getAdminUser(role);

    }

    /**
     * 获取管理员角色，没有则新建
     * @return
     * @throws Exception
     */
    private Role getAdminRole() throws Exception{
        RoleVo roleVo = new RoleVo();
        roleVo.setCode(RoleEnum.Admin.getCode());
        Role role = roleService.selectOne(roleVo);
        if(null == role){
            Role model = new Role();

            model.setName(RoleEnum.Admin.getName());
            model.setCode(RoleEnum.Admin.getCode());
            return roleService.insert(model);
        }else{
            return role;
        }
    }

    /**
     * 为管理员角色配置权限
     * @param role
     * @throws Exception
     */
    private void setAdminPower(Role role) throws Exception{

        // 1.拿到所有权限
        PowerVo powerVo = new PowerVo();
        List<Power> powerList = powerService.getList(powerVo);

        // 2.查看当前管理员有的权限
        RolePowerVo rolePowerVo = new RolePowerVo();
        rolePowerVo.setRoleId(role.getId());
        List<RolePower> rolePowerList = rolePowerService.getList(rolePowerVo);

        // 3.赋予管理员未有的权限
        if(null != powerList && powerList.size() > 0){

            if(null != rolePowerList && rolePowerList.size() > 0){

                // 筛选出管理员没有的权限，赋予权限
                List<String> list = new ArrayList<>();
                for(RolePower rolePower : rolePowerList){
                    list.add(rolePower.getPowerId());
                }

                for(Power power : powerList){

                    if(!list.contains(power.getId())){
                        //管理员已有权限中不包含该权限

                        RolePower rolePower = new RolePower();
                        rolePower.setPowerId(power.getId());
                        rolePower.setRoleId(role.getId());

                        rolePowerService.insert(rolePower);

                    }

                }

            }else{
                //管理员目前没有权限，全部赋予
                for(Power power : powerList){

                    RolePower rolePower = new RolePower();
                    rolePower.setPowerId(power.getId());
                    rolePower.setRoleId(role.getId());

                    rolePowerService.insert(rolePower);
                }

            }

        }

    }

    /**
     * 获取管理员账号，没有则新建
     * @param role
     * @return
     */
    private User getAdminUser(Role role) throws Exception{

        UserVo userVo = new UserVo();
        userVo.setRoleCode(RoleEnum.Admin.getCode());
        User user = userService.selectOne(userVo);

        if(null == user){
            User model = new User();

            model.setId(idWorker.create());
            model.setName("admin");
            model.setMobile("admin");
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            final String pwd = "123456";
            model.setPassword(encoder.encode(pwd));
            model.setRoleId(role.getId());
            model.setRoleCode(role.getCode());
            model.setRoleName(role.getName());
            model.setCreateTime(LocalDateTime.now());

            return userService.insert(model);
        }else{
            return user;
        }
    }

}
