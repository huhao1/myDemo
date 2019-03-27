package com.example.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hao
 * @since 2019-03-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Power implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    /**
     * 权限编码
     */
    @TableField("code")
    private String code;

    /**
     * 权限名称
     */
    @TableField("name")
    private String name;

    /**
     * 访问路径
     */
    @TableField("url")
    private String url;

    /**
     * 权限类型：1：菜单，2：动作
     */
    @TableField("type")
    private String type;

    /**
     * 父级权限id
     */
    @TableField("parent_id")
    private String parentId;

    /**
     * 权限等级
     */
    @TableField("level")
    private String level;

    /**
     * 权限顺序
     */
    @TableField("sort")
    private String sort;


}
