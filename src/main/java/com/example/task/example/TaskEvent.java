package com.example.task.example;

import java.util.List;

public interface TaskEvent {

    String getRoleId();

    int getEvent();

    void addChangeEvent(TaskEventChange event);

    List<TaskEventChange> getChangeEvent();
}
