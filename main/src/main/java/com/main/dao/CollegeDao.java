package com.main.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "college")
public class CollegeDao {

    @Id
    private String collegeId;

    private String collegeName;

//    @OneToMany(mappedBy = "collegeDao", fetch = FetchType.LAZY)
//    private List<SubjectDao> subjectDaos;

    public CollegeDao() {
    }

    public CollegeDao(String collegeId) {
        this.collegeId = collegeId;
    }

    public CollegeDao(String collegeId, String collegeName) {
        this.collegeId = collegeId;
        this.collegeName = collegeName;
    }

}
