package com.main.service.impl;

import com.main.dao.SubjectDao;
import com.main.repository.SubjectRepository;
import com.main.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository repository;

    @Override
    public SubjectDao findOne(String subjectId) {
        return repository.findById(subjectId).orElse(null);
    }

    @Override
    public List<SubjectDao> findAll() {
        return repository.findAll();
    }

    @Override
    public SubjectDao save(SubjectDao subjectDao) {
        return repository.save(subjectDao);
    }

    @Override
    public List<SubjectDao> findByCollegeId(String collegeId) {
        return null;
    }

}
