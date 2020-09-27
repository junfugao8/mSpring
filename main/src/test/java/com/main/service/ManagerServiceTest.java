package com.main.service;

import com.main.dao.ManagerDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ManagerServiceTest {

    @Autowired
    private ManagerService managerService;

    @Test
    void findOne() {
        ManagerDao managerDao = managerService.findOne("1114764165");
    }
}
