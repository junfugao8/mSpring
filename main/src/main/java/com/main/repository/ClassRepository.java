package com.main.repository;

import com.main.dao.ClassDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ClassRepository extends JpaRepository<ClassDao,String> {
}
