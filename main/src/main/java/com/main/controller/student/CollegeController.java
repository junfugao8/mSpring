package com.main.controller.student;


import com.main.dao.CollegeDao;
import com.main.enums.ResultEnum;
import com.main.exception.CollegeException;
import com.main.form.CollegeForm;
import com.main.service.CollegeService;
import com.main.utils.ResultVOUtil;
import com.main.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @GetMapping("/")
    public ResultVO findAll(){
        List<CollegeDao> collegeDaos = collegeService.findAll();
        return ResultVOUtil.succese(collegeDaos);
    }

    @GetMapping("/{collegeId}")
    public ResultVO find(@PathVariable String collegeId){
        CollegeDao collegeDao = collegeService.findOne(collegeId);
        return ResultVOUtil.succese(collegeDao);
    }

    @PostMapping("/")
    public ResultVO save(@Validated CollegeForm collegeForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new CollegeException(ResultEnum.PARA_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultVOUtil.succese(collegeService.save(collegeForm));
    }

    @PutMapping("/")
    public ResultVO update(@Validated CollegeForm collegeForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new CollegeException(ResultEnum.PARA_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultVOUtil.succese(collegeService.save(collegeForm));
    }

    @DeleteMapping("/")
    public ResultVO delete(@RequestParam("collegeId") String collegeId){
        return ResultVOUtil.succese(collegeService.delete(collegeId));
    }

}
