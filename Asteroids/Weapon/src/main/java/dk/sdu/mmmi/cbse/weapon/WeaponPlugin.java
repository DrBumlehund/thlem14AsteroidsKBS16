package dk.sdu.mmmi.cbse.weapon;

import dk.sdu.mmmi.cbse.common.data.Entity;
import static dk.sdu.mmmi.cbse.common.data.EntityType.BULLET;
import static dk.sdu.mmmi.cbse.common.data.EntityType.ENEMY;
import static dk.sdu.mmmi.cbse.common.data.EntityType.PLAYER;
import dk.sdu.mmmi.cbse.common.data.GameData;

import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
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
@ServiceProvider(service = IGamePluginService.class)
public class WeaponPlugin implements IGamePluginService {

    private Map<String, Entity> world;

    @Override
    public void start(GameData gameData, Map<String, Entity> world) {
        this.world = world;
        WeaponHandler.getInstance().setWorld(world);
    }

    @Override
    public void stop(GameData gameData) {
        for (Entity entity : world.values()) {
            // removes weapons from players and Enemies.
            if (entity.getType() == PLAYER || entity.getType() == ENEMY) {
                entity.remove(Weapon.class);
            }
            // removes bullets from world.
            if (entity.getType() == BULLET) {
                WeaponHandler.getInstance().removeBullet(entity);
            }
        }
    }

}
