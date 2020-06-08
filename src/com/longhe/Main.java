package com.longhe;

import com.longhe.role.Monster;
import com.longhe.role.Person;
import com.longhe.sence.Game;
import com.longhe.sence.HealthPotion;
import com.longhe.sence.Room;
import com.longhe.util.IsMonsterLive;
import com.longhe.util.RandomUtils;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    //定义回合数
    private static int rounds = 0;

    public static boolean judeOver(Game game) {
        Person person = game.getPerson();
        ArrayList<Monster> monster = game.getMonster();
        int  scoreAll=0;
        for (Monster monster1 : monster) {
            scoreAll += monster1.getLifeValue();
        }

        if(person.getLifeValue() <= 0 &&scoreAll > 0) {
            System.out.println("你输了！");
            return false;
        }
        else if(scoreAll <= 0 && person.getLifeValue() > 0) {
            System.out.println("你赢了！");
            return false;
        }else {
            return true;
        }
    }

    public static void play(Game game,ArrayList<Room> list) {

        Person person = game.getPerson();
        ArrayList<Monster> monster = game.getMonster();
        HealthPotion hp = game.getHp();
        Scanner in = new Scanner(System.in);
        System.out.println("第"+rounds+"回合");

        Integer newRandomCode15 = RandomUtils.getNewRandomCode15(1);
        Room initialRoom = person.getInitialRoom();
        hp.showInformation(initialRoom.getRandomRoom(list));

        if(initialRoom.equals(monster.get(newRandomCode15).getBornRoom())
        && IsMonsterLive.isLive(monster.get(newRandomCode15))
        ){

            System.out.println("怪物出现了！！");

            while(monster.get(RandomUtils.getNewRandomCode15(1)).getLifeValue() >0 && person.getLifeValue() >0) {

                System.out.println("目前怪物的信息："+monster.get(RandomUtils.getNewRandomCode15(1)).toString());
                System.out.println("目前"+person.getName()+"的信息："+person.toString());
                if (hp.getId()!=0){
                    hp.showInformation(initialRoom);
                }

                System.out.println("选请择:战斗/逃跑/打血");
                System.out.println("=============================================================");
                String chose = in.nextLine();
                if(chose.equals("战斗")) {
                    person.chopMonster(monster.get(RandomUtils.getNewRandomCode15(1)));
                    System.out.println("你砍了怪物，怪物血量-10");

                    if(RandomUtils.getNewRandomCode01(1) ==0) {
                        monster.get(RandomUtils.getNewRandomCode15(1)).bitePerson(person);
                        System.out.println("怪物发大招咬了你，生命值-20");
                    }else  {
                        monster.get(RandomUtils.getNewRandomCode15(1)).catchPerson(person);
                        System.out.println("怪物抓了你，生命值-5");
                    }
                }else if(chose.equals("打血")) {
                    if(person.getInitialRoom().equals(hp.getAppearRoom())) {
                        person.drinkHealthPotion(person,hp);
                        hp.setId(1);
                        hp.setInit(true);
                        hp.appear(list);
                    }else {
                        System.out.println("这个房间没有血瓶");
                    }
                }
                else if(chose.equals("逃跑")) {
                    System.out.println("输入逃跑的方向："+person.getInitialRoom().getDirection());
                    String dir = in.nextLine();
                    person.walkRoom(dir);
                    break;
                }
            }

        }else {
            person.toString();
            System.out.println("请输入你要去的方向");
            System.out.println("=================================================================");
            String dir = in.nextLine();
            person.walkRoom(dir);
        }

    }

    public static void main(String[] args) {

        //制造房间
        Room live, lobby, pub, study, bedroom;

        live = new Room("1","客厅");
        lobby= new Room("2","大堂");
        pub = new Room("3","小酒吧");
        study = new Room("4","书房");
        bedroom = new Room("5","卧室");

        //	初始化房间的出口
        live.setExits("east",lobby);
        live.setExits("south",study);
        live.setExits("west",pub);
        lobby.setExits("west",live);
        pub.setExits("east",live);
        study.setExits("north", live);
        study.setExits("east",bedroom);
        bedroom.setExits("west", study);

        //储存房间的集合
        ArrayList<Room> list = new ArrayList<>();
        list.add(live);
        list.add(lobby);
        list.add(pub);
        list.add(study);
        list.add(bedroom);

        //初始化用户
        System.out.println("=========================================================================================================================================================");
        System.out.println(" __      __       .__  .__                                ___________         _____            ________                        ._.\n" +
                "/  \\    /  \\ ____ |  | |  |   ____  ____   _____   ____   \\__    ___/___     /     \\ ___.__.  /  _____/_____    _____   ____   | |\n" +
                "\\   \\/\\/   // __ \\|  | |  | _/ ___\\/  _ \\ /     \\_/ __ \\    |    | /  _ \\   /  \\ /  <   |  | /   \\  ___\\__  \\  /     \\_/ __ \\  | |\n" +
                " \\        /\\  ___/|  |_|  |_\\  \\__(  <_> )  Y Y  \\  ___/    |    |(  <_> ) /    Y    \\___  | \\    \\_\\  \\/ __ \\|  Y Y  \\  ___/   \\|\n" +
                "  \\__/\\  /  \\___  >____/____/\\___  >____/|__|_|  /\\___  >   |____| \\____/  \\____|__  / ____|  \\______  (____  /__|_|  /\\___  >  __\n" +
                "       \\/       \\/               \\/            \\/     \\/                           \\/\\/              \\/     \\/      \\/     \\/   \\/");
        System.out.println("=========================================================================================================================================================");
        System.out.println("首先请您的id和姓名：001,李白(中间逗号为英文状态下输入)");
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] words = line.split(",");
        Person person = new Person(words[0],words[1],20);

        //设置人物角色的初始化房间
        person.setInitialRoom(live);
        System.out.println("你现在的位置是:"+person.getInitialRoom().toString());
        System.out.println("出口有："+person.getInitialRoom().getDirection());


        //创建妖怪
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i=1;i<=5;i++){
            Room bornRoom = new Room();/*创建妖怪出生房间*/
            bornRoom = bornRoom.getRandomRoom(list);
            Monster monster = new Monster(String.valueOf(i), "妖怪" + i, 20);
            monster.setBornRoom(bornRoom);
            monsters.add(monster);
        }


        //创建血瓶
        HealthPotion hp = new HealthPotion(0);
        hp.appear(list);

        Game game = new Game(person,monsters,hp);

        while(judeOver(game)) {
            rounds++;
            play(game,list);
        }


        System.out.println("感谢您的光临。再见！");
        System.out.println("====================================================");
        in.close();
    }

}
