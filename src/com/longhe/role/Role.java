package com.longhe.role;

/*
* 角色类
* */

public class Role {

    //角色属性
    private String id;
    private String name;
    private int lifeValue;

    public Role() {
        super();
    }

    //初始化角色生命值
    public Role(String id, String name, int lifeValue) {
        super();
        this.id = id;
        this.name = name;
        this.lifeValue = lifeValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifeValue() {
        return lifeValue;
    }


    public void setLifeValue(int lifeValue) {
        this.lifeValue = lifeValue;
    }
}
