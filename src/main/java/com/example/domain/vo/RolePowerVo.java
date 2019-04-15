package com.example.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName RolePowerVo
 * @Description TODO
 * @Author hao
 * @Date 2019/4/15 11:10
 **/
@Data
public class RolePowerVo implements Serializable {
    private static final long serialVersionUID = -4570584734529434449L;

    private String id;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 权限id
     */
    private String powerId;

}
