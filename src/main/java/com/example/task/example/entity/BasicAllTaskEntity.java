package com.example.task.example.entity;

import lombok.Data;

@Data
public class BasicAllTaskEntity{
    private int type;
    private int taskid;
    private String namesql;
    private String note1;
    private String note2;
    private String title;
    private String description;
    private int group;
    private int event;
    private long cond1;
    private long cond2;
    private long cond3;
    private long cond4;
    private int point;
    private int precondition;
    private Integer judge;
    private String reward;
    private String reward2;

}
