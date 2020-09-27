package com.main.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
import java.util.Properties;

@Configuration
public class kaptchaConfig  {

    @Bean
    public DefaultKaptcha getDefaultKaptcha(){
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty("kaptcha.border.color","34,53,193,155");
        properties.setProperty("kaptcha.border.thickness","5");
        properties.setProperty("kaptcha.textproducer.char.length","6");
        properties.setProperty("kaptcha.textproducer.font.names","宋体,Arial,Courier");
        properties.setProperty("kaptcha.noise.color","blue");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

}
