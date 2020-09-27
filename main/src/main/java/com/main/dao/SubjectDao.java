package com.main.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "subject")
public class SubjectDao {

    @Id
    private String subjectId;

    private String subjectName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "collegeId")
    private CollegeDao collegeDao;

//    @OneToMany(mappedBy = "subjectDao", fetch = FetchType.LAZY)
//    private List<ClassDao> classDaos;

    public SubjectDao() {
    }

    public SubjectDao(String subjectId) {
        this.subjectId = subjectId;
    }

    public SubjectDao(String subjectId, String subjectName, CollegeDao collegeDao) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.collegeDao = collegeDao;
    }

//    public void setCollegeDao(CollegeDao collegeDao) {
//        collegeDao.setSubjectDaos(null);
//        this.collegeDao = collegeDao;
//    }
//
//    public CollegeDao getCollegeDao() {
//        return new CollegeDao(collegeDao.getCollegeId(),collegeDao.getCollegeName());
//    }
}
