package com.main.repository;

import com.main.dao.MissionDetailDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MissionDetailRepository extends JpaRepository<MissionDetailDao,Integer> {
}
