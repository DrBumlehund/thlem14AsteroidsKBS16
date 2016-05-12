/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.player;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.EntityType;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
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
public class PlayerControlSystemTest {

    GameData gameData = null;
    Map<String, Entity> world = null;
    Entity entity = null;

    public PlayerControlSystemTest() {
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
        gameData.setDelta(0.15f);

        // set up world
        world = new HashMap<>();
        // set up player entity
        entity = new Entity();
        entity.setType(EntityType.PLAYER);
        entity.setRotationSpeed(150);
        entity.setRadians(0f);
        entity.setAcceleration(300);
        entity.setDeacceleration(20);
        entity.setMaxSpeed(500);

        // add entity to world.
        world.put(entity.getID(), entity);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of process method, of class PlayerControlSystem.
     */
    @Test
    public void testProcessRotLeft() {
        System.out.println("Player Rotation left Test");
        gameData.getKeys().setKey(GameKeys.LEFT, true);

        float startRadians = entity.getRadians();

        PlayerControlSystem instance = new PlayerControlSystem();
        instance.process(gameData, world, entity);

        assertTrue(entity.getRadians() > startRadians);
    }

    @Test
    public void testProcessRotRight() {
        System.out.println("Player Rotation right Test");
        gameData.getKeys().setKey(GameKeys.RIGHT, true);

        float startRadians = entity.getRadians();

        PlayerControlSystem instance = new PlayerControlSystem();
        instance.process(gameData, world, entity);

        assertTrue(entity.getRadians() < startRadians);
    }

    @Test
    public void testProcessAccelerate() {
        System.out.println("Player Acceleration test");
        gameData.getKeys().setKey(GameKeys.UP, true);

        float startDx = entity.getDx();
        float startDy = entity.getDy();

        PlayerControlSystem instance = new PlayerControlSystem();
        instance.process(gameData, world, entity);

        float newDx = entity.getDx();
        float newDy = entity.getDy();

        assertFalse(startDx == newDx && startDy == newDy);
    }

    @Test
    public void testProcessShoot() {
        System.out.println("Player shoot test");
        gameData.getKeys().setKey(GameKeys.SPACE, true);

        int startSize = world.size();

        PlayerControlSystem instance = new PlayerControlSystem();
        instance.process(gameData, world, entity);
    }

}
