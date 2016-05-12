/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.player;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.EntityType;
import dk.sdu.mmmi.cbse.common.data.GameData;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thomaslemqvist
 */
public class EntityPluginTest {

    GameData gameData = null;
    Map<String, Entity> world = null;

    public EntityPluginTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // setting up gamedata;
        gameData = new GameData();
        gameData.setDelta(0.14f);
        gameData.setDisplayHeight(600);
        gameData.setDisplayWidth(800);

        // setting up world
        world = new HashMap<>();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of start method, of class EntityPlugin.
     */
    @Test
    public void testPlayerStart() {
        System.out.println("PlayerStart");
        EntityPlugin instance = new EntityPlugin();

        int startEntities = world.size();

        instance.start(gameData, world);

        assertFalse(startEntities == world.size());
    }

    /**
     * Test of stop method, of class EntityPlugin.
     */
    @Test
    public void testPlayerStop() {
        System.out.println("PlayerStop");
        EntityPlugin instance = new EntityPlugin();
        // the start method sets an entity, which is removed by the stop method.
        instance.start(gameData, world);

        int startEntities = world.size();

        instance.stop(gameData);

        assertFalse(startEntities == world.size());
    }

}
