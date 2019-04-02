package com.example.common.jwt;

import java.io.Serializable;

/**
 * @ClassName JwtAuthenticationRequest
 * @Description 用户登录实体类
 * @Author hao
 * @Date 2019/3/28 17:18
 **/
public class JwtAuthenticationRequest implements Serializable {
    private static final long serialVersionUID = 2250561350046079659L;

    private String username;

    private String password;

    public JwtAuthenticationRequest() {
        super();
    }

    public JwtAuthenticationRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
