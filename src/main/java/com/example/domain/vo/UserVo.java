package com.example.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName UserVo
 * @Description TODO
 * @Author hao
 * @Date 2019/3/27 18:12
 **/
@Data
public class UserVo implements Serializable {

    private static final long serialVersionUID = 3863260067029340254L;

    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色Id
     */
    private String roleId;

    /**
     * 角色编码：admin，vip，public
     */
    private String roleCode;

    /**
     * 页码
     */
    private Integer page;

    /**
     * 每页显示条数
     */
    private Integer limit;

}
