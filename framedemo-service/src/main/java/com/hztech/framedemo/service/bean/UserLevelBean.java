package com.hztech.framedemo.service.bean;

import javax.persistence.*;

/**
 * Created by allan on 2015/7/8.
 */
@Entity
@Table(name = "Demo_UserLevel")
public class UserLevelBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int levelId;
    @Column(name = "Demo_LevelName")
    private String levelName;

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}
