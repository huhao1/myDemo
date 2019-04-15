package com.example.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName RoleVo
 * @Description TODO
 * @Author hao
 * @Date 2019/4/15 10:47
 **/
@Data
public class RoleVo implements Serializable {
    private static final long serialVersionUID = 3291842238707814781L;

    private String id;

    /**
     * 角色名称：管理员，会员，大众
     */
    private String name;

    /**
     * 角色编码：admin，vip，public
     */
    private String code;

}
