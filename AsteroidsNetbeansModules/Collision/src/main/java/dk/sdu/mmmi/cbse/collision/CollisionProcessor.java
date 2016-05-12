/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.collision;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import java.util.Map;

/**
 *
 * @author thomaslemqvist
 */
public class CollisionProcessor implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, Map<String, Entity> world, Entity entity) {
        if (!entity.getIsHit()) {
            checkCollision(entity, world);
        }
    }

    private void checkCollision(Entity entity, Map<String, Entity> otherEntities) {
        for (Entity other : otherEntities.values()) {
            if (!other.getID().equals(entity.getID())
                    && other.getType() != entity.getType()) {
                // checks if the entity has a parrent/shooter.
                if (hasParrent(entity)) {
                    // if the shooter is the other entity, it should do nothing.
                    if (entity.get(Entity.class).equals(other)) {
                        return;
                    }
                }
                // checks if the other has a parrent/shooter.
                if (hasParrent(other)) {
                    // if the shooter is the entity, it should do nothing.
                    if (other.get(Entity.class).equals(entity)) {
                        return;
                    }
                }

                float dist = distance(entity.getX(), entity.getY(),
                        other.getX(), other.getY());
                float distAvail = entity.getRadius() + other.getRadius();

                if (dist < distAvail) {
                    System.out.println("Collision between " + entity.getType()
                            + " and " + other.getType() + " - dist:" + dist
                            + " distAvail:" + distAvail);
                    entity.setIsHit(true);
                    other.setIsHit(true);
                }
            }
        }
    }

    private float distance(float x1, float y1, float x2, float y2) {
        float x = x2 - x1;
        float y = y2 - y1;
        return (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    private boolean hasParrent(Entity entity) {
        return entity.get(Entity.class) != null;
    }

}
