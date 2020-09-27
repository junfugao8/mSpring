package com.main.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginForm {

    @NotNull
    private String managerId;

    @NotNull
    private String managerpwd;

    @NotNull
    private String verifyCode;

}
