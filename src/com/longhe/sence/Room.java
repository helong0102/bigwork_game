package com.longhe.sence;

import com.longhe.util.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Room {

    private String id;
    private String name;
    private String direction;

    private HashMap<String,Room> exits=new HashMap<>();

    public Room() {
        super();
    }

    public Room(String id, String name) {
        super();
        this.id = id;
        this.name = name;
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


    @Override
    public String toString() {
        return "房间号为：" + id + "\t "+"房间名为：" + name ;
    }

    public void setExits(String dir,Room room) {
        exits.put(dir, room);
    }

    public String getDirection() {
        StringBuffer sb=new StringBuffer();
        for(String dir:exits.keySet()) {
            sb.append(dir);
            sb.append(" ");
    }
        return sb.toString();
    }

    public Room getRoom(String dir) {
        return exits.get(dir);
    }

    public Room getRandomRoom(ArrayList<Room> list) {
        Integer newRandomCode15 = RandomUtils.getNewRandomCode15(1);
        return list.get(newRandomCode15);
    }

}
