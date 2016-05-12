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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thomaslemqvist
 */
public class AsteroidsProcessorTest {
    
    GameData gameData = null;
    Map<String, Entity> world = null;
    Entity entity = null;
    
    public AsteroidsProcessorTest() {
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
        entity.setType(EntityType.ASTEROID);
        entity.setIsHit(false);
        entity.setRadians((float) (0.5 * Math.PI));
        entity.setRotationSpeed(1000);
        entity.setShapeX(new float[0]);
        entity.setShapeY(new float[0]);
        entity.add(new Distance(new float[0]));

        // add entity to world.
        world.put(entity.getID(), entity);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of process method, of class AsteroidsProcessor.
     */
    @Test
    public void testProcessRotation() {
        System.out.println("Asteroid Process rotation test");
        AsteroidsProcessor instance = new AsteroidsProcessor();
        float astRad = entity.getRadians();
        
        instance.process(gameData, world, entity);
        
        assertNotEquals(astRad, entity.getRadians());
    }
    
}
