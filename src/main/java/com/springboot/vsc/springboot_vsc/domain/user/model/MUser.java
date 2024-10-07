package com.springboot.vsc.springboot_vsc.domain.user.model;

import java.util.Date;
import java.util.List;
import jakarta.persistence.Entity;

import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Table(name="m_user")
@Entity
public class MUser {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String userId;
    private String password ;
    private String userName;
    private Date birthday;
    private Integer age;
    private Integer gender;
    private Integer departmentId;
    private String role;
    @Transient
    private Department department;
    @Transient
    private List<Salary> salaryList;
}
