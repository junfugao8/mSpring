package com.main;

import com.main.dao.ClassDao;
import com.main.dao.CollegeDao;
import com.main.dao.StudentDao;
import com.main.dao.SubjectDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@SpringBootTest
class MainApplicationTests {

    @Test
    void contextLoads() {
    }

}
