package com.imfc.media.common.constant;

public enum SystemEnum {
    //常量
    SYS("media",0),
    CAS_SYS("http://localhost:9090", 1),       //认证中心
    USER_SYS("http://localhost:8082", 2),      //用户服务
    DOCTOR_SYS("http://localhost:8088", 3),    //工作站
    COMPANY_SYS("http://localhost:8084", 4),   //医院
    SHOP_SYS("http://localhost:8086", 5),      //商城
    SYSTEM_SYS("http://localhost:8094", 6),    //系统管理
    COMMUNITY_SYS("http://localhost:8090", 7), //社区
    FINANCE_SYS("http://localhost:8092", 8);   //财务

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private SystemEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (SystemEnum c : SystemEnum.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
