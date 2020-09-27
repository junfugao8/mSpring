package com.main.dao;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "mission_order")
public class MissionOrderDao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    private String description;

    private Integer workTime;

    private Date startSignTime;

    private Date endSignTime;

    private Date startTime;

//    @JoinColumn(referencedColumnName = "managerId")
//    private ManagerDao managerDao;

    @OneToMany(mappedBy = "missionOrderDao")
    private List<MissionDetailDao> missionDetailDaos;
}
