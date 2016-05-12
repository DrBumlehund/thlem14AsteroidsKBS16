/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.weapon;

import java.io.Serializable;

/**
 *
 * @author thomaslemqvist
 */
public class Weapon implements Serializable {

    private float sinceLastShot = 0.5f;
    private final float attackSpeed = 0.5f;

    public boolean canShoot() {
//        System.out.println("Can shoot");
        return sinceLastShot > attackSpeed;
    }
    
    public void addTime(float dt){
//        System.out.println("Time added.");
        sinceLastShot += dt;
    }
    
    public void shoot(){
        sinceLastShot = 0f;
    }
}
