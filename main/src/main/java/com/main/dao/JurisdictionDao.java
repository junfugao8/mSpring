package com.main.dao;

import lombok.Data;

import javax.persistence.*;

//用户权限表
@Entity
@Data
@Table(name = "jurisdiction")
public class JurisdictionDao {

    @Id
    @GeneratedValue
    private Integer jurisdiId;

    //管理managerDao的权重
    //最大为10管理员权限,只有大的能管理小的
    private Integer managerWeigh;

    public JurisdictionDao() {
    }

    public JurisdictionDao(Integer managerWeigh) {
        this.managerWeigh = managerWeigh;
    }
}
