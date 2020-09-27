package com.main.service.impl;

import com.main.dao.CollegeDao;
import com.main.dao.SubjectDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubjectServiceImplTest {

    @Autowired
    private SubjectServiceImpl service;

    @Test
    void findOne() {
        SubjectDao subjectDao = service.findOne("4530306");
        assert subjectDao.getSubjectId() == "4530306";
    }

    @Test
    void findAll() {
        List<SubjectDao> subjectDaos = service.findAll();
        assert subjectDaos.size() > 0;
    }

    @Test
    void save() {
//        SubjectDao subjectDao = new SubjectDao("4530309","软件技术",new CollegeDao("45303"));
//        SubjectDao result = service.save(subjectDao);
//        assert result.getSubjectId() == "4530309";
    }

    @Test
    void findByCollegeId() {
        List<SubjectDao> subjectDaos = service.findByCollegeId("45303");
        assert subjectDaos.size() > 0;
    }
}
