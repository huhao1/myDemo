package com.example.common.jwt;

import java.io.Serializable;

/**
 * @ClassName JwtAuthenticationResponse
 * @Description TODO
 * @Author hao
 * @Date 2019/3/28 17:20
 **/
public class JwtAuthenticationResponse implements Serializable {
    private static final long serialVersionUID = 9095636507218142925L;

    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

}
