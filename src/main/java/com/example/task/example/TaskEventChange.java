package com.example.task.example;

import org.springframework.context.ApplicationEvent;

import java.util.ArrayList;
import java.util.List;

public class TaskEventChange extends ApplicationEvent implements TaskEvent {

    public List<TaskEventChange> changeEvent = new ArrayList<>();

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public TaskEventChange(Object source) {
        super(source);
    }

    @Override
    public String getRoleId() {
        return null;
    }

    @Override
    public int getEvent() {
        return 0;
    }

    public List<TaskEventChange> getChangeEvent() {
        return changeEvent;
    }

    @Override
    public void addChangeEvent(TaskEventChange event) {
        changeEvent.add(event);
    }

    public List<TaskEventChange> getChangeEvent(TaskEventChange event) {
        return changeEvent;
    }
}
