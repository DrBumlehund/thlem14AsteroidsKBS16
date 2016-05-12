/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.movement;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import java.util.Map;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author thomaslemqvist
 */
@ServiceProvider(service = IEntityProcessingService.class)
public class MovementProcessor implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, Map<String, Entity> world, Entity entity) {
//        if (!entity.getIsHit()) {
//            checkColission(entity, world);
//        }

        float dt = gameData.getDelta();
        int height = gameData.getDisplayHeight();
        int width = gameData.getDisplayWidth();

        float dx = entity.getDx();
        float dy = entity.getDy();
        float x = entity.getX();
        float y = entity.getY();

        // set position and wrap
        x += dx * dt;
        if (x > width) {
            x = 0;
        } else if (x < 0) {
            x = width;
        }

        y += dy * dt;
        if (y > height) {
            y = 0;
        } else if (y < 0) {
            y = height;
        }

        // update entity position.
        entity.setPosition(x, y);

    }

//    private void checkColission(Entity entity, Map<String, Entity> otherEntities) {
//        for (Entity other : otherEntities.values()) {
//            if (!other.getID().equals(entity.getID())
//                    && other.getType() != entity.getType()) {
//                // checks if the entity has a parrent/shooter.
//                if (hasParrent(entity)) {
//                    if (entity.get(Entity.class).equals(other)) {
//                        // if the shooter is the other entity, it should do nothing.
////                        System.out.println("Colided with shooter");
//                        return;
//                    }
//                }
//                // checks if the other has a parrent/shooter.
//                if (hasParrent(other)) {
//                    if (other.get(Entity.class).equals(entity)) {
//                        // if the shooter is the entity, it should do nothing.
////                        System.out.println("Colided with shooter");
//                        return;
//                    }
//                }
//
//                float dist = distance(entity.getX(), entity.getY(),
//                        other.getX(), other.getY());
//                float distAvail = entity.getRadius() + other.getRadius();
//
//                if (dist < distAvail) {
//                    System.out.println("Colission bwtween " + entity.getType()
//                            + " and " + other.getType() + " - dist:" + dist
//                            + " distAvail:" + distAvail);
//                    entity.setIsHit(true);
//                    other.setIsHit(true);
//                }
//            }
//        }
//    }
//
//    private float distance(float x1, float y1, float x2, float y2) {
//        float x = x2 - x1;
//        float y = y2 - y1;
//        return (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
//    }
//
//    private boolean hasParrent(Entity entity) {
//        return entity.get(Entity.class) != null;
//    }
}
