/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.weapon;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.EntityType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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
public class WeaponHandlerTest {

    Entity entity = null;
    Entity entityBullet = null;
    Map<String, Entity> world = null;

    public WeaponHandlerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // setup world
        world = new HashMap<>();
        // setup entity
        entity = new Entity();
        // setup entityBullet
        entityBullet = new Entity();
        entityBullet.setType(EntityType.BULLET);

        world.put(entityBullet.getID(), entity);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of hasWeapon method, of class WeaponHandler.
     */
    @Test
    public void testHasWeapon() {
        System.out.println("hasWeapon");
        WeaponHandler instance = WeaponHandler.getInstance();
        boolean expResult = false;
        boolean result = instance.hasWeapon(entity);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasWeapon method, of class WeaponHandler.
     */
    @Test
    public void testHasWeapon2() {
        System.out.println("hasWeapon");
        WeaponHandler instance = WeaponHandler.getInstance();
        instance.addWeapon(entity);
        boolean expResult = true;
        boolean result = instance.hasWeapon(entity);
        assertEquals(expResult, result);
    }

    /**
     * Test of fireWeapon method, of class WeaponHandler.
     */
    @Test
    public void testFireWeapon() {
        System.out.println("fireWeapon");
        WeaponHandler instance = WeaponHandler.getInstance();
        int startSize = world.size();
        instance.addWeapon(entity);
        instance.fireWeapon(entity, world);
        assertNotEquals(startSize, world.size());
    }

    /**
     * Test of removeBullet method, of class WeaponHandler.
     */
    @Test
    public void testRemoveBullet() {
        System.out.println("removeBullet");
        WeaponHandler instance = WeaponHandler.getInstance();
        int startSize = world.size();
        instance.setWorld(world);
        

        instance.removeBullet(entityBullet);

        assertNotEquals(startSize, world.size());

    }

    /**
     * Test of addWeapon method, of class WeaponHandler.
     */
    @Test
    public void testAddWeapon() {
        System.out.println("addWeapon");
        WeaponHandler instance = WeaponHandler.getInstance();
        boolean preAddWeapon = instance.hasWeapon(entity);
        instance.addWeapon(entity);
        assertNotEquals(preAddWeapon, instance.hasWeapon(entity));

    }

}
