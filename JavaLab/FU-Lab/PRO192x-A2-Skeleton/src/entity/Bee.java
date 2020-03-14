/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Random;

/**
 *
 * @author hp
 */
public class Bee {
    private String type;
    private byte health;
    private boolean alive;

    public Bee() {
        //init
        //your cote
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte getHealth() {
        return health;
    }

    public void setHealth(byte health) {
        this.health = health;
        //update the alive status when the health value changed
        //your code
       
    }   
    
    public boolean isAlive(){
        return this.alive;
    }  

    //attack this bee
    public void damage() {
        //your code
    }

    @Override
    public String toString() {
        String beeDetails ="Bee details";
        //your code
        
        return beeDetails;
    }
}
