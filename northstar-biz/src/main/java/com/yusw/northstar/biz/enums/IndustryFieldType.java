package com.yusw.northstar.biz.enums;

/**
 * Created by yusw on 2016/11/20.
 */
public enum IndustryFieldType {
    ZHILIAN(1,"移动互联网"),
    LAGOU(2,"电商"),
    LIEPING(3,"传统");
    public int type;
    public String name;

    IndustryFieldType(int type, String name) {
        this.type = type;
        this.name = name;
    }
}
