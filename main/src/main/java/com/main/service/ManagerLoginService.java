package com.main.service;

import com.main.form.LoginForm;
import com.main.form.RegisterForm;
import com.main.vo.ResultVO;

import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

public interface ManagerLoginService {

    ResultVO getToken();

    void getVerify(String token, HttpServletResponse response);

    ResultVO login(String token, LoginForm loginForm);

    ResultVO register(String token, RegisterForm registerForm);

    void logout(String token);
}
