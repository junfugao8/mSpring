package com.main.repository;


import com.main.dao.ManagerDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<ManagerDao,String> {
}
