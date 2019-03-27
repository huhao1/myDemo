package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.vo.UserVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hao
 * @since 2019-03-27
 */
public interface UserService extends IService<User> {

    /**
     * 动态条件查询列表
     * @param userVo
     * @return
     */
    List<User> getUserList(UserVo userVo);

    /**
     * 动态条件查询分页列表
     * @param userVo
     * @return
     */
    IPage<User> getUserPage(UserVo userVo);

    /**
     * 添加
     * @param user
     * @return
     */
    boolean insert(User user);

}
