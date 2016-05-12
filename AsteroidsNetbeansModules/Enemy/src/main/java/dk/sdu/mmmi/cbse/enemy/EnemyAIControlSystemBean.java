/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.enemy;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.EntityType;
import static dk.sdu.mmmi.cbse.common.data.EntityType.ENEMY;
import dk.sdu.mmmi.cbse.common.data.GameData;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import java.util.Map;

public class EnemyAIControlSystemBean {

    public void process(GameData gameData, Map<String, Entity> world, Entity entity) {
        if (entity.getType().equals(ENEMY)) {

            float x = entity.getX();
            float y = entity.getY();
            float dt = gameData.getDelta();
            float deceleration = entity.getDeacceleration();
            float acceleration = entity.getAcceleration();
            float dx = entity.getDx();
            float dy = entity.getDy();
            float radians = entity.getRadians();
            float maxSpeed = entity.getMaxSpeed();
            Entity player = null;

            for (Map.Entry<String, Entity> entry : world.entrySet()) {
                String key = entry.getKey();
                Entity value = entry.getValue();
                if (value.getType() == EntityType.PLAYER) {
                    player = value;
                }
            }

            if (player == null) {
                return;
            }

            float theta = (float) Math.atan2(y - player.getY(), x - player.getX());
            theta += Math.PI;
            theta %= (float) (2 * Math.PI);
            entity.setRadians(theta);

            dx += cos(radians) * acceleration * dt;
            dy += sin(radians) * acceleration * dt;

            float vec = (float) sqrt(dx * dx + dy * dy);
            if (vec > 0) {
                dx -= (dx / vec) * deceleration * dt;
                dy -= (dy / vec) * deceleration * dt;
            }
            if (vec > maxSpeed) {
                dx = (dx / vec) * maxSpeed;
                dy = (dy / vec) * maxSpeed;
            }
            
            if (distance(x, y, player.getX(), player.getY()) < 250) {
                entity.setHasShot(true);
            }

            // Update entity
            entity.setDx(dx);
            entity.setDy(dy);
            updateShape(entity);
        }

    }

    private void updateShape(Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        float x = entity.getX();
        float y = entity.getY();
        float radians = entity.getRadians();

        shapex[0] = (float) (x + Math.cos(radians) * 8);
        shapey[0] = (float) (y + Math.sin(radians) * 8);

        shapex[1] = (float) (x + Math.cos(radians - 4 * 3.1415f / 5) * 8);
        shapey[1] = (float) (y + Math.sin(radians - 4 * 3.1145f / 5) * 8);

        shapex[2] = (float) (x + Math.cos(radians + 3.1415f) * 5);
        shapey[2] = (float) (y + Math.sin(radians + 3.1415f) * 5);

        shapex[3] = (float) (x + Math.cos(radians + 4 * 3.1415f / 5) * 8);
        shapey[3] = (float) (y + Math.sin(radians + 4 * 3.1415f / 5) * 8);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }

    private float distance(float x1, float y1, float x2, float y2) {
        float x = x2 - x1;
        float y = y2 - y1;
        return (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

}
