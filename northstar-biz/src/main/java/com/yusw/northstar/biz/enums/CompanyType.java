package com.yusw.northstar.biz.enums;

/**
 * Created by yusw on 2016/11/20.
 */
public enum CompanyType {
    STATE_OWNED_ENTERPRISE(1,"国企"),
    FOREIGN_ENTERPRISE(2,"外企"),
    PRIVATE_ENTERPRISE(3,"私企");
    public int type;
    public String name;

    CompanyType(int type, String name) {
        this.type = type;
        this.name = name;
    }
}
