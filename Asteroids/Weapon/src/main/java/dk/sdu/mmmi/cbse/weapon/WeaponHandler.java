/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.weapon;

import dk.sdu.mmmi.cbse.common.data.Entity;
import static dk.sdu.mmmi.cbse.common.data.EntityType.BULLET;
import dk.sdu.mmmi.cbse.common.data.GameData;
import java.util.Map;

/**
 *
 * @author thomaslemqvist
 */
public class WeaponHandler {

    private Map<String, Entity> world;

    private WeaponHandler() {
    }

    // Singleton Pattern
    public static WeaponHandler getInstance() {
        return WeaponHandlerHolder.INSTANCE;
    }

    private static class WeaponHandlerHolder {

        private static final WeaponHandler INSTANCE = new WeaponHandler();
    }

    // sets the worlmap.
    public void setWorld(Map<String, Entity> world) {
        this.world = world;
    }

    // checks if the entity has got a weapon.
    protected boolean hasWeapon(Entity entity) {
        return entity.get(Weapon.class) != null;
    }

    // fires the weapon.
    protected void fireWeapon(Entity entity, Map<String, Entity> world) {
        entity.setHasShot(false);
        createBullet(entity, world);
        entity.get(Weapon.class).shoot(); // resets the shooting timer.
    }

    private void createBullet(Entity entity, Map<String, Entity> world) {
        Entity b = new Entity();

        b.setType(BULLET);// TODO: fix all other input methods...

        b.setRadians(entity.getRadians());

        b.setRadius(1.7f);

        b.setAcceleration(300);
        b.setMaxSpeed(350);

        // sets an ofset from the shooter.
        float offset = entity.getRadius() + 3 + b.getRadius();
        b.setX((float) (entity.getX() + Math.cos(entity.getRadians()) * offset));
        b.setY((float) (entity.getY() + Math.sin(entity.getRadians()) * offset));

        b.setDx((float) (Math.cos(entity.getRadians()) * b.getMaxSpeed()));
        b.setDy((float) (Math.sin(entity.getRadians()) * b.getMaxSpeed()));

        b.setExpiration(2f);

        // adds the shooter, for the bullet to not colide with.
        b.add(entity);

        world.put(b.getID(), b);

    }

    protected void removeBullet(Entity entity) {
        if (entity.getType() == BULLET) {
            // removes data added to the bullet.
            entity.disposeData();
            world.remove(entity.getID());
//            System.out.println("Removed bullet " + entity.getID());

        }
    }

    protected void addWeapon(Entity entity) {
        if (!hasWeapon(entity)) {
            Weapon wep = new Weapon();
            entity.add(wep);
//            System.out.println("Added weapon to " + entity.getType());
        }
    }
}
