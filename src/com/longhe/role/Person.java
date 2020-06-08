package com.longhe.role;


import com.longhe.sence.HealthPotion;
import com.longhe.sence.Room;

public class Person extends Role{

    private Room initialRoom;

    public Person() {
        super();
    }

    public Person(String id, String name, int lifeValue) {
        super(id, name, lifeValue);
    }

    public void setInitialRoom(Room room) {
        this.initialRoom = room;
    }

    public Room getInitialRoom() {
        return initialRoom;
    }

    public Person(Room initialRoom) {
        super();
        this.initialRoom = initialRoom;
    }

    public void chopMonster(Monster monster) {
        //把对方妖怪砍一刀，生命值减少10；
        int lifeValue=monster.getLifeValue()-10;
        monster.setLifeValue(lifeValue);
    }

    public void walkRoom(String dir) {
        Room nextRoom = initialRoom.getRoom(dir);
        if(nextRoom == null) {
            System.out.println("哪里没有出口！！！");
            System.out.println("你可以选择的方向为："+initialRoom.getDirection());
        }else {
            initialRoom = nextRoom;
            System.out.println("你目前在"+initialRoom);
            System.out.println("出口有："+initialRoom.getDirection());


        }
    }

    @Override
    public String toString() {
        return "你的id为:" + getId() + "\t, 姓名为:" + getName() + "\t, 生命值为:" + getLifeValue() ;
    }

    public void drinkHealthPotion(Person person,HealthPotion hp) {
        int lifeValue=person.getLifeValue()+20;
        if(lifeValue > 100) {
            person.setLifeValue(100);
            System.out.println("血量恢复，生命值+"+(120-lifeValue));
        }
        else {
            person.setLifeValue(lifeValue);
            System.out.println("生命值+20");
        }
        hp.setInit(false);
    }
}