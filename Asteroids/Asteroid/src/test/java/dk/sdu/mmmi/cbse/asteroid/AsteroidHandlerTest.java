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
public class AsteroidHandlerTest {

    AsteroidHandler instance = AsteroidHandler.getInstance();
    private GameData gameData;
    private HashMap<String, Entity> world;
    Entity asteroid;

    public AsteroidHandlerTest() {
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
        asteroid = new Entity();
        asteroid.setType(EntityType.ASTEROID);
        asteroid.setX(225);
        asteroid.setY(225);
        asteroid.setShapeX(new float[10]);
        asteroid.setShapeY(new float[10]);
        asteroid.setRadius(10);

        //add entity to world.
        world.put(asteroid.getID(), asteroid);

        //set the world and gamedata on the handelr.
        instance.setGameData(gameData);
        instance.setWorld(world);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of spawnAsteroid method, of class AsteroidHandler.
     */
    @Test
    public void testSpawnAsteroid_0args() {
        System.out.println("spawnAsteroid()");
        int startSize = world.size();
        instance.spawnAsteroid();
        assertNotEquals(startSize, world.size());
    }

    /**
     * Test of spawnAsteroid method, of class AsteroidHandler.
     */
    @Test
    public void testSpawnAsteroid_Entity() {
        System.out.println("spawnAsteroid(Entity entity)");
        int startSize = world.size();
        instance.spawnAsteroid(asteroid);
        assertNotEquals(startSize, world.size());

    }

    /**
     * Test of splitAsteroid method, of class AsteroidHandler.
     */
    @Test
    public void testSplitAsteroid() {
        System.out.println("splitAsteroid");
        int startSize = world.size();
        instance.splitAsteroid(asteroid);
        assertNotEquals(startSize, world.size());
    }

    /**
     * Test of removeAsteroid method, of class AsteroidHandler.
     */
    @Test
    public void testRemoveAsteroid() {
        System.out.println("removeAsteroid");
        int startSize = world.size();
        instance.removeAsteroid(asteroid);
        assertNotEquals(startSize, world.size());
    }

}
