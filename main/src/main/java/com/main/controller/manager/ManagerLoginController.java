package com.main.controller.manager;


import com.main.enums.ResultEnum;
import com.main.exception.LoginException;
import com.main.form.LoginForm;
import com.main.form.RegisterForm;
import com.main.service.ManagerLoginService;
import com.main.utils.ResultVOUtil;
import com.main.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

@RestController
@RequestMapping("/manager")
public class ManagerLoginController {

    @Autowired
    private ManagerLoginService managerLoginService;

    @GetMapping("/getToken")
    public ResultVO getToken(){
        return managerLoginService.getToken();
    }

    @GetMapping("/getVerify")
    public void getVerify( @RequestHeader("token") String token, HttpServletResponse response) throws Exception {
        managerLoginService.getVerify(token,response);
    }

    @PostMapping("/login")
    public ResultVO login(@RequestHeader("token") String token, @Validated LoginForm loginForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new LoginException(ResultEnum.PARA_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        return managerLoginService.login(token,loginForm);
    }

    @PostMapping("/register")
    public ResultVO register(@RequestHeader("token") String token, @Validated RegisterForm registerForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new LoginException(ResultEnum.PARA_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        return managerLoginService.register(token,registerForm);
    }

}
