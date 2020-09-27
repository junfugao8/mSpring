package com.main.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RegisterForm {

    @NotNull
    private String managerId;

    @NotNull
    private String managerPwd;

    @NotNull
    private Integer weigh;

    @NotNull
    private String verifyCode;


}
