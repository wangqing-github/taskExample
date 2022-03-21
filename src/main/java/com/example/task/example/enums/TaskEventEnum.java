package com.example.task.example.enums;

public enum TaskEventEnum {
    UNKNOWN(0, "错误的类型"),

    ADD_FRIEND(92001, "拥有n个好友"),

    COLLECT_COIN(93001, "收集n金币"),//add

    COLLECT_CARD_TYPE(93009, "收集n种b品质卡牌"),//add  收集4种张紫卡  不是种族

    CARD_LEVEL_UP(94001, "将n种b品质炮塔升到c级"),//add 三种紫卡升到4级

    USER_LEVEL_UP(94010, "玩家等级达到n级"),


    ;
    private final int id;
    private final String note;

    TaskEventEnum(int id, String note) {
        this.id = id;
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public int getId() {
        return id;
    }
}
