package com.main.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "manager")
public class ManagerDao {

    @Id
    private String managerId;

    private String managerPwd;

    private String phone;

    private String name;

    public ManagerDao() {
    }

    public ManagerDao(String managerId, String managerPwd) {
        this.managerId = managerId;
        this.managerPwd = managerPwd;
    }

    public ManagerDao(String managerId, String managerPwd, JurisdictionDao jurisdictionDao) {
        this.managerId = managerId;
        this.managerPwd = managerPwd;
        this.jurisdictionDao = jurisdictionDao;
    }

    @OneToMany
    @JoinColumn(name = "manager_managerId")
    private List<MissionOrderDao> missionOrderDaos;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private JurisdictionDao jurisdictionDao;
}
