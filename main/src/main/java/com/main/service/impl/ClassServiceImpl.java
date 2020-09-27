package com.main.service.impl;

import com.main.dao.ClassDao;
import com.main.repository.ClassRepository;
import com.main.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassRepository repository;

    @Override
    public ClassDao findOne(String classId) {
        return repository.findById(classId).orElse(null);
    }

    @Override
    public List<ClassDao> findAll() {
        return repository.findAll();
    }

    @Override
    public ClassDao save(ClassDao classDao) {
        return repository.save(classDao);
    }

    @Override
    public List<ClassDao> findBySubjectId(String subjectId) {
        return findBySubjectId(subjectId);
    }
}
