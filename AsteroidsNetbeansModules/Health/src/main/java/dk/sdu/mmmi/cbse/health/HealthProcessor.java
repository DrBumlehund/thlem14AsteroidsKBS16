/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.health;

import dk.sdu.mmmi.cbse.common.data.Entity;
import static dk.sdu.mmmi.cbse.common.data.EntityType.ENEMY;
import static dk.sdu.mmmi.cbse.common.data.EntityType.PLAYER;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import java.util.Map;

/**
 *
 * @author thomaslemqvist
 */
public class HealthProcessor implements IEntityProcessingService {

    public HealthProcessor() {
    }

    @Override
    public void process(GameData gameData, Map<String, Entity> world, Entity entity) {
        if (entity.getType() == PLAYER || entity.getType() == ENEMY) {
            if (entity.getIsHit()) {
                entity.setLife(entity.getLife() - 1);
                System.out.println(entity.getType() + " hit, " + entity.getLife() + " lives to go.");
                entity.setIsHit(false);
                if (entity.getLife() < 1) {
                    System.out.println(entity.getType() + " has died...");
                    entity.disposeData();
                    world.remove(entity.getID());
                }
                if (entity.getType() == PLAYER) {
                    gameData.setPlayerHealth(entity.getLife());
                }
            }
        }
    }

}
