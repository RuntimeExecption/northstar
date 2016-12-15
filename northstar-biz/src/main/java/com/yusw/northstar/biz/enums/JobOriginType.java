package com.yusw.northstar.biz.enums;

/**
 * Created by yusw on 2016/11/20.
 */
public enum JobOriginType {
    ALL(0,"所有的"),
    ZHILIAN(1,"智联"),
    LAGOU(2,"拉钩"),
    LIEPING(3,"猎聘");
    public int type;
    public String name;

    JobOriginType(int type, String name) {
        this.type = type;
        this.name = name;
    }
}
