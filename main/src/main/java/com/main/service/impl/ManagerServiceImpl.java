package com.main.service.impl;

import com.main.dao.ManagerDao;
import com.main.repository.ManagerRepository;
import com.main.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public ManagerDao findOne(String managerId) {
        return managerRepository.findById(managerId).orElse(null);
    }

    @Override
    public ManagerDao save(ManagerDao managerDao) {
        return managerRepository.save(managerDao);
    }
}
