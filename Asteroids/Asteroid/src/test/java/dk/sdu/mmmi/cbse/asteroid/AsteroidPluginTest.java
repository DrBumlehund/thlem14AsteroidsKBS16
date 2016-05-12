/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.EntityType;
import dk.sdu.mmmi.cbse.common.data.GameData;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author thomaslemqvist
 */
public class AsteroidPluginTest {

    GameData gameData = null;
    Map<String, Entity> world = null;

    public AsteroidPluginTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {        
        // set up game data
        gameData = new GameData();
        // set up world
        world = new HashMap<>();
        //setup entity for removal
        Entity asteroid = new Entity();
        asteroid.setType(EntityType.ASTEROID);
        //add entity to world.
        world.put(asteroid.getID(), asteroid);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of start method, of class AsteroidPlugin.
     */
    @org.junit.Test
    public void testStart() {
        System.out.println("Asteroid start Test");
        AsteroidPlugin instance = new AsteroidPlugin();
        int startSize = world.size();
        instance.start(gameData, world);
        assertNotEquals(startSize, world.size());
    }

    /**
     * Test of stop method, of class AsteroidPlugin.
     */
    @org.junit.Test
    public void testStop() {
        System.out.println("stop");
        
        AsteroidPlugin instance = new AsteroidPlugin();
        instance.start(gameData, world);
        
        int startSize = world.size();
        instance.stop(gameData);
        
        assertNotEquals(startSize, world.size());
    }

}
