package com.main.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "student")
public class StudentDao {

    @Id
    private String studentId;

    private String studentName;

    @OneToOne
    @JoinColumn(name = "student_classId", referencedColumnName = "classId")
    private ClassDao classDao;

//    @OneToMany(mappedBy = "studentDao")
//    private List<MissionDetailDao> missionDetailDaos;

    public StudentDao(String studentId, String studentName, ClassDao classDao) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.classDao = classDao;
    }

    public StudentDao() {
    }

    public StudentDao(String studentId) {
        this.studentId = studentId;
    }

//    public void setClassDao(ClassDao classDao) {
//        classDao.setSubjectDao(null);
//        classDao.setStudentDaos(null);
//        this.classDao = classDao;
//    }
}
