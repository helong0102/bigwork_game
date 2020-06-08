package com.longhe.sence;


import com.longhe.role.Monster;
import com.longhe.role.Person;

import java.util.ArrayList;


public class Game {

	private Person person;
	private ArrayList<Monster> monster;
	private HealthPotion hp;
	
	public Game() {
		super();
	}

    public Game(Person person, ArrayList<Monster> monster, HealthPotion hp) {
        this.person = person;
        this.monster = monster;
        this.hp = hp;
    }


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ArrayList<Monster> getMonster() {
        return monster;
    }

    public void setMonster(ArrayList<Monster> monster) {
        this.monster = monster;
    }

    public HealthPotion getHp() {
        return hp;
    }

    public void setHp(HealthPotion hp) {
        this.hp = hp;
    }
}
