package com.main.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "class")
    public class ClassDao {

        @Id
        private String classId;

        private String className;

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "class_subjectId", referencedColumnName = "subjectId")
        private SubjectDao subjectDao;

//        @OneToMany(mappedBy = "classDao", fetch = FetchType.LAZY)
//        private List<StudentDao> studentDaos;

    public ClassDao() {
    }

    public ClassDao(String classId, String className, SubjectDao subjectDao) {
        this.classId = classId;
        this.className = className;
        this.subjectDao = subjectDao;
    }

//    public void setSubjectDao(SubjectDao subjectDao) {
//        subjectDao.setClassDaos(null);
//        subjectDao.setCollegeDao(null);
//        this.subjectDao = subjectDao;
//    }
}
