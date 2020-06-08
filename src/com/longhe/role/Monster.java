package com.longhe.role;

import com.longhe.sence.Room;

public class Monster extends Role {

    private Room bornRoom;

    public Room getBornRoom() {
        return bornRoom;
    }

    public void setBornRoom(Room bornRoom) {
        this.bornRoom = bornRoom;
    }

    public Monster(String id, String name, int lifeValue) {
        super(id, name, lifeValue);
    }


    @Override
    public String toString() {
        return "怪物Id为：" + getId() + "\t, 名字为：" + getName() + "\t, 血量为：" + getLifeValue();
    }

    public void bitePerson(Person person) {
        int lifeValue = person.getLifeValue() - 20;
        person.setLifeValue(lifeValue);
    }

    public void catchPerson(Person person) {
        int lifeValue = person.getLifeValue() - 5;
        person.setLifeValue(lifeValue);
    }
}