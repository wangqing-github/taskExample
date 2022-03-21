package com.example.task.example.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserTaskInfoEntity implements Serializable {
    private String roleid;
    private int taskid;
    private int type;
    private int group;
    private int event;
    private long progress;
    private int status;
    private int judge;
    private Date ctime;
    private Long receiveTime;

    public UserTaskInfoEntity() {
    }

    public UserTaskInfoEntity(BasicAllTaskEntity basicAllTaskEntity) {
        this.taskid = basicAllTaskEntity.getTaskid();
        this.type = basicAllTaskEntity.getType();
        this.event = basicAllTaskEntity.getEvent();
        this.group = basicAllTaskEntity.getGroup();
        if (basicAllTaskEntity.getJudge() != null) this.judge = basicAllTaskEntity.getJudge();
    }

}
