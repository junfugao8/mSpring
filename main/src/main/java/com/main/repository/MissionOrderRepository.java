package com.main.repository;

import com.main.dao.MissionOrderDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MissionOrderRepository extends JpaRepository<MissionOrderDao,Integer> {
}
