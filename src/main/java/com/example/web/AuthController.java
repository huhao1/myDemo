package com.example.web;

import com.example.common.util.Constants;
import com.example.common.responseVo.ResponseVo;
import com.example.common.exception.BaseException;
import com.example.common.jwt.JwtAuthenticationRequest;
import com.example.common.jwt.JwtAuthenticationResponse;
import com.example.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AuthController
 * @Description TODO
 * @Author hao
 * @Date 2019/3/28 17:25
 **/
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody JwtAuthenticationRequest authenticationRequest) {
        try {
            final String token = authService.login(authenticationRequest.getUsername(),authenticationRequest.getPassword());
            return ResponseEntity.ok(new JwtAuthenticationResponse(token));
        }  catch (BaseException e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseVo().setCode(Constants.ERRORT).setMsg(e.getMessage()));
        }  catch (BadCredentialsException e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseVo().setCode(Constants.ERRORT).setMsg("用户名或密码错误"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseVo().setCode(Constants.ERRORT).setMsg(Constants.MSG_ERROR));
        }
    }

}
