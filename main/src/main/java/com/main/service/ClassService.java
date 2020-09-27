package com.main.service;

import com.main.dao.ClassDao;

import java.util.List;

public interface ClassService {

    ClassDao findOne(String classId);

    List<ClassDao> findAll();

    ClassDao save(ClassDao classDao);

    List<ClassDao> findBySubjectId(String subjectId);

}
