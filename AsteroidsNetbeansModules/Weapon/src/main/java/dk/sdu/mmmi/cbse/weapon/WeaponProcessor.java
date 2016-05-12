package dk.sdu.mmmi.cbse.weapon;

import dk.sdu.mmmi.cbse.common.data.Entity;
import static dk.sdu.mmmi.cbse.common.data.EntityType.BULLET;
import static dk.sdu.mmmi.cbse.common.data.EntityType.ENEMY;
import static dk.sdu.mmmi.cbse.common.data.EntityType.PLAYER;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import java.util.Map;
import org.openide.util.lookup.ServiceProvider;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thomaslemqvist
 */
@ServiceProvider(service = IEntityProcessingService.class)
public class WeaponProcessor implements IEntityProcessingService {
    
    @Override
    public void process(GameData gameData, Map<String, Entity> world, Entity entity) {
        
        if (entity.getType() == PLAYER || entity.getType() == ENEMY) {
            if (WeaponHandler.getInstance().hasWeapon(entity)) {
                entity.get(Weapon.class).addTime(gameData.getDelta());
                if (entity.get(Weapon.class).canShoot()) {
                    if (entity.HasShot()) {
                        WeaponHandler.getInstance().fireWeapon(entity, world);
                    }
                }
                entity.setHasShot(false);
            } else {
                // adds weapon to entity if it hasn't got one.
                WeaponHandler.getInstance().addWeapon(entity);
            }
        }
        
        if (entity.getType() == BULLET) {
            
            if (entity.getIsHit() || entity.getExpiration() < entity.addAndGetLifetime(gameData.getDelta())) {
                WeaponHandler.getInstance().removeBullet(entity);
            }
        }
    }
}
