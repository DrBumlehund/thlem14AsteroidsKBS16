/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.weapon;

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
public class WeaponPluginTest {

    GameData gameData = null;
    Map<String, Entity> world = null;
    Entity entity = null;
    Entity bullet = null;

    public WeaponPluginTest() {
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
        entity.setHasShot(true);
        
        // set up bullet
        bullet = new Entity();
        bullet.setType(EntityType.BULLET);
        bullet.setIsHit(true);
        bullet.setExpiration(0);

        // add entity and bullet to world.
        world.put(entity.getID(), entity);
        world.put(bullet.getID(), bullet);
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void testStop() {
        System.out.println("Weapon stop test");
        WeaponPlugin instance = new WeaponPlugin();
        instance.start(gameData, world);
        
        instance.stop(gameData);
        
        assertFalse(WeaponHandler.getInstance().hasWeapon(entity));
    }

}
