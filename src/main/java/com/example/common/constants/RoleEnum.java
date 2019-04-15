package com.example.common.constants;

/**
 * 角色枚举值
 */
public enum RoleEnum {

    /**
     * 管理员
     */
    Admin("Admin", "管理员"),

    /**
     * 会员
     */
    VIP("VIP", "会员"),

    /**
     * 大众
     */
    PUBLIC("PUBLIC", "大众");

    private final String code;

    private final String name;

    RoleEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static RoleEnum find(String code) {
        for (RoleEnum type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("ResultInfo StatusEnum not legal:" + code);
    }


}
