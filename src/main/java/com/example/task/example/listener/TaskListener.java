package com.example.task.example.listener;

import com.example.task.example.event.card.CardLevelUpEvent;
import com.example.task.example.event.friend.FriendAddEvent;
import com.example.task.example.event.user.RoleLevelUpEvent;
import com.example.task.example.manager.TaskManager;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TaskListener {
    /**
     * 角色升级
     */
    @EventListener(RoleLevelUpEvent.class)
    public void onRoleLevelUpEvent(RoleLevelUpEvent event) {
        TaskManager.triggerTask(event.getEvent(), event);
    }

    @EventListener(CardLevelUpEvent.class)
    public void onCardLevelUpEvent(CardLevelUpEvent cardLevelUpEvent) {
        TaskManager.triggerTask(cardLevelUpEvent.getEvent(), cardLevelUpEvent);
    }

    @EventListener(FriendAddEvent.class)
    public void onFriendAddEvent(FriendAddEvent event) {
        TaskManager.triggerTask(event.getEvent(), event);
    }

}
