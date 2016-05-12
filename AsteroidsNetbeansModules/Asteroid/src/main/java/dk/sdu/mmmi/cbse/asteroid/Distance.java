/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.asteroid;

import java.io.Serializable;

/**
 *
 * @author thomaslemqvist
 */
public class Distance implements Serializable{

    private float[] distances;

    public Distance(float[] distances) {
        this.distances = distances;
    }

    public float[] getDistances() {
        return distances;
    }

    public void setDistances(float[] distances) {
        this.distances = distances;
    }

}
