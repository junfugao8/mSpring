package com.main.repository;

import com.main.dao.SubjectDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<SubjectDao,String> {


}
