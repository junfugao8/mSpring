package com.main.service;

import com.main.dao.SubjectDao;

import java.util.List;

public interface SubjectService {

    SubjectDao findOne(String subjectId);

    List<SubjectDao> findAll();

    SubjectDao save(SubjectDao subjectDao);

    List<SubjectDao> findByCollegeId(String collegeId);

}
