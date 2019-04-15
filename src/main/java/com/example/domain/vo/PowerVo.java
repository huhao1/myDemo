package com.example.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName PowerVo
 * @Description TODO
 * @Author hao
 * @Date 2019/4/15 9:43
 **/
@Data
public class PowerVo implements Serializable {
    private static final long serialVersionUID = 1101334668355191701L;

    private String id;

    /**
     * 权限编码
     */
    private String code;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 访问路径
     */
    private String url;

    /**
     * 权限类型：1：菜单，2：动作
     */
    private String type;

    /**
     * 父级权限id
     */
    private String parentId;

    /**
     * 权限等级
     */
    private String level;

    /**
     * 权限顺序
     */
    private String sort;

}
