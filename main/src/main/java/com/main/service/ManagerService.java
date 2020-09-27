package com.main.service;

import com.main.dao.ManagerDao;

public interface ManagerService {

    ManagerDao findOne(String managerId);

    ManagerDao save(ManagerDao managerDao);

}
