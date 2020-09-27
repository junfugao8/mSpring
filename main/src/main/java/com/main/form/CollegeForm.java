package com.main.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CollegeForm {

    @NotNull(message = "ID不能为空")
    private String collegeId;

    @NotNull(message = "名字不能为空")
    private String collegeName;

}
