package com.main.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.code.kaptcha.Producer;
import com.main.dao.JurisdictionDao;
import com.main.dao.ManagerDao;
import com.main.enums.RedisMapEnum;
import com.main.enums.ResultEnum;
import com.main.exception.LoginException;
import com.main.form.LoginForm;
import com.main.form.RegisterForm;
import com.main.service.ManagerLoginService;
import com.main.service.ManagerService;
import com.main.utils.JsonUtil;
import com.main.utils.ResultVOUtil;
import com.main.vo.ResultVO;
import com.sun.javafx.scene.traversal.Algorithm;
import jdk.nashorn.internal.runtime.JSONFunctions;
import lombok.SneakyThrows;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.UUID;


@Service
public class ManagerLoginServiceImpl implements ManagerLoginService {

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Autowired
    private ManagerService managerService;

    @Autowired
    private Producer producer;

    @Override
    public ResultVO getToken() {
        //生成唯一字符串作为token
        String token = UUID.randomUUID().toString();
        //存入redis
        redisTemplate.opsForValue().set(token,new JSONObject().toJSONString());
        return ResultVOUtil.succese(token);
    }

    @SneakyThrows
    @Override
    public void getVerify(String token, HttpServletResponse response) {
        //判断token是否存在redis，不存在则重新生成
        if(!redisTemplate.hasKey(token)){
            throw new LoginException(ResultEnum.TOKEN_NOT_NULL.getCode(),ResultEnum.TOKEN_NOT_NULL.getMsg());
        }
        //生成验证码字符
        String text = producer.createText();
        //将验证码字符序列化存入redis
        redisTemplate.opsForValue().set(token,JsonUtil.add(redisTemplate.opsForValue().get(token),RedisMapEnum.VERIFY_CODE.getKey(),text));
        //使用验证码字符生成验证码图片
        BufferedImage image = producer.createImage(text);
        //设置头，输出格式与不缓存
        response.setContentType("image/jpeg");
        response.setHeader("Cache-Control","no-cache");
        ServletOutputStream outputStream = response.getOutputStream();
        //使用ImageIO向前端输出图片
        ImageIO.write(image,"jpeg",outputStream);
    }

    @Override
    public ResultVO login(String token, LoginForm loginForm) {
        //验证验证码是否正确
        if(!checkVerifyCode(token,loginForm.getVerifyCode())){
            return ResultVOUtil.error(ResultEnum.VERIFY_ERROR.getCode(),ResultEnum.VERIFY_ERROR.getMsg());
        }
        //验证账号密码
        ManagerDao managerDao = managerService.findOne(loginForm.getManagerId());
        if(managerDao == null || !managerDao.getManagerPwd().equals(loginForm.getManagerpwd())){
            return ResultVOUtil.error(ResultEnum.LOGIN_ERROR.getCode(),ResultEnum.LOGIN_ERROR.getMsg());
        }
        //登录成功，将权限信息存入redis
        int weigh = managerDao.getJurisdictionDao().getManagerWeigh();
        System.out.println(weigh);
        redisTemplate.opsForValue().set(token,JsonUtil.add(redisTemplate.opsForValue().get(token),RedisMapEnum.MANAGER_WEIGH.getKey(),weigh));
        return  ResultVOUtil.succese();
    }


    @Override
    public ResultVO register(String token, RegisterForm registerForm) {
        if(!checkVerifyCode(token,registerForm.getVerifyCode())){
            return ResultVOUtil.error(ResultEnum.VERIFY_ERROR.getCode(),ResultEnum.VERIFY_ERROR.getMsg());
        }
        if(managerService.findOne(registerForm.getManagerId()) != null){
            throw new LoginException(ResultEnum.MANAGER_IS_EXIT.getCode(),ResultEnum.MANAGER_IS_EXIT.getMsg());
        }
        managerService.save(new ManagerDao(registerForm.getManagerId(),registerForm.getManagerPwd(),new JurisdictionDao(registerForm.getWeigh())));
        return ResultVOUtil.succese();
    }

    @Override
    public void logout(String token) {

    }

    private boolean checkVerifyCode(String token, String verifyCode){
        //从redis取出验证码字符进行比对
        String code = JsonUtil.get(redisTemplate.opsForValue().get(token),RedisMapEnum.VERIFY_CODE.getKey());
        System.out.println(code+","+verifyCode);
        if(code == null || !code.equals(verifyCode)){
            return false;
        }
        return true;
    }

}
