package com.main.repository;

import com.main.dao.CollegeDao;
import com.main.dao.SubjectDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CollegeRepositoryTest {

    @Autowired
    private CollegeRepository repository;

    @Test
    public void addOne(){
        CollegeDao collegeDao = new CollegeDao();
        collegeDao.setCollegeId("45303111");
        collegeDao.setCollegeName("计算机系");
        Assert.notNull(repository.save(collegeDao));
    }

//    @Test
//    public void delete(){
//        repository.deleteById("45303");
//        CollegeDao collegeDao = repository.findById("45303").orElse(null);
//        Assert.isNull(collegeDao);
//    }
}
