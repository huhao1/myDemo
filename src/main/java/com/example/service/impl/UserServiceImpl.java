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
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
@CacheConfig(cacheNames = "UserCache")
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

        if(StringUtils.isNotBlank(userVo.getRoleId())){
            queryWrapper.eq("role_id", userVo.getRoleId());
        }

        if(StringUtils.isNotBlank(userVo.getRoleCode())){
            queryWrapper.eq("role_code", userVo.getRoleCode());
        }

        if(StringUtils.isNotBlank(userVo.getName())){
            queryWrapper.like("name", userVo.getName());
        }

        if(StringUtils.isNotBlank(userVo.getMobile())){
            queryWrapper.like("mobile", userVo.getMobile());
        }

        return queryWrapper;
    }

    @Cacheable
    @Override
    public List<User> getUserList(UserVo userVo) {
        return userMapper.selectList(getQueryWrapper(userVo));
    }

    @Cacheable
    @Override
    public IPage<User> getUserPage(UserVo userVo){
        Page page = new Page<>(userVo.getPage(),userVo.getLimit());
        page.setDesc("create_time");
        return userMapper.selectPage(page, getQueryWrapper(userVo));
    }

    @Override
    public User selectOne(UserVo userVo){
        return userMapper.selectOne(getQueryWrapper(userVo));
    }

    @CacheEvict(value={"UserCache"}, allEntries = true)
    @Override
    public User insert(User user){
        if(StringUtils.isNotBlank(user.getId())){
            user.setId(idWorker.create());
        }
        this.save(user);
        return userMapper.selectById(user.getId());
    }

    @Cacheable
    @Override
    public User findByMobile(String mobile){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("mobile",mobile);
        return userMapper.selectOne(userQueryWrapper);
    }



}
