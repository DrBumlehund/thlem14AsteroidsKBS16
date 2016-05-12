/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import static dk.sdu.mmmi.cbse.common.data.EntityType.ASTEROID;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import java.util.Map;
import java.util.Random;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author thomaslemqvist
 */
@ServiceProvider(service = IGamePluginService.class)
public class AsteroidPlugin implements IGamePluginService {

    private Map<String, Entity> world;
    Random rng;

    @Override
    public void start(GameData gameData, Map<String, Entity> world) {
        this.world = world;
        AsteroidHandler.getInstance().setWorld(world);
        AsteroidHandler.getInstance().setGameData(gameData);
        for (int i = 0; i < AsteroidHandler.getInstance().getMaxAsteroids(); i++) {
            AsteroidHandler.getInstance().spawnAsteroid();
        }
    }

    @Override
    public void stop(GameData gameData) {
        for (Entity entity : world.values()) {
            // removes all asteroids.
            if (entity.getType() == ASTEROID) {
                AsteroidHandler.getInstance().removeAsteroid(entity);
            }
        }
    }
}
