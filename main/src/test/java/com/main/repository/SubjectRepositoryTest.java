package com.main.repository;

import com.main.dao.CollegeDao;
import com.main.dao.SubjectDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SubjectRepositoryTest {

    @Autowired
    private SubjectRepository repository;

    @Test
    public void addOne(){
//        SubjectDao dao = new SubjectDao();
//        CollegeDao collegeDao = new CollegeDao();
//        collegeDao.setCollegeId("45303");
//        dao.setCollegeDao(collegeDao);
//        dao.setSubjectId("4530302");
//        dao.setSubjectName("物联网1");
//        SubjectDao result = repository.save(dao);
//        assert result.getSubjectId()=="4530302";
    }

    @Test
    public void findByCollegeId(){
//        addOne();
//        List<SubjectDao> daos = repository.findByCollegeDao_CollegeId("45303");
//        assert daos.size() > 0;
    }
}
