package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.util.IdWorker;
import com.example.domain.User;
import com.example.domain.vo.UserVo;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IdWorker idWorker;

    private QueryWrapper<User> getQueryWrapper(UserVo userVo){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        if(StringUtils.isNotBlank(userVo.getId())){
            queryWrapper.eq("id", userVo.getId());
        }

        if(StringUtils.isNotBlank(userVo.getRole())){
            queryWrapper.eq("role", userVo.getRole());
        }

        if(StringUtils.isNotBlank(userVo.getName())){
            queryWrapper.like("name", userVo.getName());
        }

        if(StringUtils.isNotBlank(userVo.getMobile())){
            queryWrapper.like("mobile", userVo.getMobile());
        }

        return queryWrapper;
    }

    @Override
    public List<User> getUserList(UserVo userVo) {
        return userMapper.selectList(getQueryWrapper(userVo));
    }

    @Override
    public IPage<User> getUserPage(UserVo userVo){
        Page page = new Page<>(userVo.getPage(),userVo.getLimit());
        return userMapper.selectPage(page, getQueryWrapper(userVo));
    }

    @Override
    public boolean insert(User user){
        user.setId(idWorker.create());
        return this.save(user);
    }

    @Override
    public User findByMobile(String mobile){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("mobile",mobile);
        return userMapper.selectOne(userQueryWrapper);
    }



}
