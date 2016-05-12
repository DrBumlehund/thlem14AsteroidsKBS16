/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.health;

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
public class HealthProcessorTest {

    GameData gameData = null;
    Map<String, Entity> world = null;
    Entity entity = null;

    public HealthProcessorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // set up gamedata
        gameData = new GameData();
        // set up world
        world = new HashMap<>();
        // set up player entity
        entity = new Entity();
        entity.setType(EntityType.PLAYER);
        entity.setLife(3);

        // add entity and bullet to world.
        world.put(entity.getID(), entity);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of process method, of class HealthProcessor.
     */
    @Test
    public void testProcessIsHit() {
        System.out.println("Health process, is hit");
        entity.setIsHit(true);
        HealthProcessor instance = new HealthProcessor();

        int entityLifePreProcess = entity.getLife();

        instance.process(gameData, world, entity);

        assertFalse(entityLifePreProcess == entity.getLife());
    }

    /**
     * Test of process method, of class HealthProcessor.
     */
    @Test
    public void testProcessNotHit() {
        System.out.println("Health process, not hit");
        entity.setIsHit(false);
        HealthProcessor instance = new HealthProcessor();

        int entityLifePreProcess = entity.getLife();

        instance.process(gameData, world, entity);

        assertTrue(entityLifePreProcess == entity.getLife());
    }
}
