package com.main.dao;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "mission_detail")
public class MissionDetailDao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detailId;

    private Integer missionStatus;

    @ManyToOne
    @JoinColumn(name = "student_studentId", referencedColumnName = "studentId")
    private StudentDao studentDao;

    @OneToOne
    @JoinColumn(name = "order_orderId", referencedColumnName = "orderId")
    private MissionOrderDao missionOrderDao;

}
