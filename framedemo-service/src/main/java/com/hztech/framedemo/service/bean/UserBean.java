package com.hztech.framedemo.service.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by allan on 2015/7/8.
 */
@Entity
@Table(name = "Demo_User")
public class UserBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键生成策略，这里使用了数据库自己的主键生成
    @Column(name = "Id")
    private int id;
    @Column(name = "Demo_FirstName", length = 80)
    private String firstName;
    @Column(name = "Demo_LastName")
    private String lastName;
    @Column(name = "Demo_Age")
    private int age;
    @ManyToOne
    @JoinColumn(name = "Demo_LevelId")
    private UserLevelBean userLevel;
    @Column(name = "Demo_AddTime", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date addTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserLevelBean getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(UserLevelBean userLevel) {
        this.userLevel = userLevel;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
