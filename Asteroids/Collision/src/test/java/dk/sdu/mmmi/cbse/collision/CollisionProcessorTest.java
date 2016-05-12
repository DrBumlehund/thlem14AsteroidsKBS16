/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.collision;

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
public class CollisionProcessorTest {

    GameData gameData = null;
    Map<String, Entity> world = null;
    Entity entity = null;
    Entity otherEntity = null;
    Entity thirdEntity = null;

    public CollisionProcessorTest() {
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
        entity.setRadius(5);
        entity.setX(225);
        entity.setY(225);

        // set up other enemy entity
        otherEntity = new Entity();
        otherEntity.setType(EntityType.ENEMY);
        otherEntity.setRadius(5);
        otherEntity.setX(225);
        otherEntity.setY(225);

        // set up third enemy entity
        thirdEntity = new Entity();
        thirdEntity.setType(EntityType.ENEMY);
        thirdEntity.setRadius(5);
        thirdEntity.setX(425);
        thirdEntity.setY(425);

        // add entities to world.
        world.put(entity.getID(), entity);
        world.put(otherEntity.getID(), otherEntity);
        world.put(thirdEntity.getID(), thirdEntity);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of process method, of class CollisionProcessor.
     */
    @Test
    public void testProcessColided() {
        System.out.println("Collision process colided");
        CollisionProcessor instance = new CollisionProcessor();

        instance.process(gameData, world, entity);

        assertTrue(entity.getIsHit());
    }

    /**
     * Test of process method, of class CollisionProcessor.
     */
    @Test
    public void testProcesNotColided() {
        System.out.println("Collision process not colided");
        CollisionProcessor instance = new CollisionProcessor();

        instance.process(gameData, world, thirdEntity);

        assertFalse(thirdEntity.getIsHit());
    }

}
