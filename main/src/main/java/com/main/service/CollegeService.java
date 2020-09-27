package com.main.service;

import com.main.dao.CollegeDao;
import com.main.form.CollegeForm;

import java.util.List;

public interface CollegeService {

    CollegeDao findOne(String collegeId);

    List<CollegeDao> findAll();

    CollegeDao save(CollegeForm collegeForm);

    CollegeDao delete(String collegeId);

}
