/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.movement;

import dk.sdu.mmmi.cbse.common.data.Entity;
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
public class MovementProcessorTest {

    GameData gameData = null;
    Map<String, Entity> world = null;
    Entity entity = null;

    public MovementProcessorTest() {
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

        // setting up entity
        entity = new Entity();
        entity.setDx(15);
        entity.setDy(15);
        entity.setX(225);
        entity.setY(225);

        // add entity to world
        world.put(entity.getID(), entity);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of process method, of class MovementProcessor.
     */
    @Test
    public void testMovementProcesser() {
        System.out.println("MovementProcess");
        MovementProcessor instance = new MovementProcessor();

        float startX = entity.getX();
        float startY = entity.getY();

        instance.process(gameData, world, entity);

        float newX = entity.getX();
        float newY = entity.getY();

        assertFalse(startX == newX && startY == newY);
    }

}
