package com.main.service.impl;

import com.main.dao.ClassDao;
import com.main.dao.CollegeDao;
import com.main.dao.StudentDao;
import com.main.dao.SubjectDao;
import com.main.enums.ResultEnum;
import com.main.exception.CollegeException;
import com.main.form.CollegeForm;
import com.main.repository.CollegeRepository;
import com.main.service.CollegeService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeRepository repository;

    @Override
    public CollegeDao findOne(String collegeId){
        CollegeDao collegeDao = repository.findById(collegeId).orElse(null);
        if (collegeDao == null){
            throw new CollegeException(ResultEnum.COLLEGE_NOT_EXIST);
        }
        return collegeDao;
    }

    @Override
    public List<CollegeDao> findAll() {
        return repository.findAll();
    }

    @Override
    public CollegeDao save(CollegeForm collegeForm) {
//        CollegeDao collegeDao = new CollegeDao("45303","计算机系");
//        entityManager.persist(collegeDao);
//        SubjectDao subjectDao = new SubjectDao("4530306","物联网",collegeDao);
//        SubjectDao subjectDao1 = new SubjectDao("4530309","软件",collegeDao);
//        entityManager.persist(subjectDao);
//        entityManager.persist(subjectDao1);
//        ClassDao classDao = new ClassDao("2018030601","物联网1801",subjectDao);
//        ClassDao classDao1 = new ClassDao("2018030602","物联网1802",subjectDao);
//        ClassDao classDao2 = new ClassDao("2018030901","软件1801",subjectDao1);
//        entityManager.persist(classDao);
//        entityManager.persist(classDao1);
//        entityManager.persist(classDao2);
//        StudentDao studentDao = new StudentDao("20180306035","淦",classDao);
//        StudentDao studentDao1 = new StudentDao("20180306036","就",classDao);
//        StudentDao studentDao2 = new StudentDao("20180306077","完",classDao);
//        StudentDao studentDao3 = new StudentDao("20180306001","了",classDao1);
//        StudentDao studentDao4 = new StudentDao("20180309005","淦就完了",classDao2);
//        entityManager.persist(studentDao);
//        entityManager.persist(studentDao1);
//        entityManager.persist(studentDao2);
//        entityManager.persist(studentDao3);
//        entityManager.persist(studentDao4);

//        return collegeDao;
        return repository.save(new CollegeDao(collegeForm.getCollegeId(),collegeForm.getCollegeName()));
    }

    @Override
    public CollegeDao delete(String collegeId) {
        CollegeDao collegeDao = repository.findById(collegeId).orElse(null);
        if(collegeDao == null){
            throw new CollegeException(ResultEnum.COLLEGE_NOT_EXIST);
        }else {
            repository.deleteById(collegeId);
            return collegeDao;
        }
    }
}
