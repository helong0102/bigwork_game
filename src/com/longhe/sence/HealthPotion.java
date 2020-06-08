package com.longhe.sence;

import java.util.ArrayList;

public class HealthPotion {

    private int id;
    private boolean init = true;
    private Room appearRoom;

    public HealthPotion() {
        super();
    }

    public HealthPotion(int id) {
        super();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isInit() {
        return init;
    }

    public void setInit(boolean init) {
        this.init = init;
    }


    public Room getAppearRoom() {
        return appearRoom;
    }

    public void setAppearRoom(Room appearRoom) {
        this.appearRoom = appearRoom;
    }

    public void appear(ArrayList<Room> list) {
        Room room = new Room();
        this.appearRoom = room.getRandomRoom(list);
    }

    public void showInformation(Room room) {
        if (room.getId().equals(appearRoom.getId())){
            if(id==1){
                System.out.println("血瓶的ID为："+id+"\t,血量为20点");
            }
        }
    }
}
