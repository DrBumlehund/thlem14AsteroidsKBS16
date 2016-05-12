/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import static dk.sdu.mmmi.cbse.common.data.EntityType.ASTEROID;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import java.util.Map;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author thomaslemqvist
 */
@ServiceProvider(service = IEntityProcessingService.class)
public class AsteroidsProcessor implements IEntityProcessingService {
    
    @Override
    public void process(GameData gameData, Map<String, Entity> world, Entity entity) {
        // to keep spawning asteroids.
        if (AsteroidHandler.getInstance().getGameData() == null) {
            AsteroidHandler.getInstance().setGameData(gameData);
        }
        if (AsteroidHandler.getInstance().getWorld() == null) {
            AsteroidHandler.getInstance().setWorld(world);
        }
        if (AsteroidHandler.getInstance().getNumAsteroids()
                < AsteroidHandler.getInstance().getMaxAsteroids()) {
            AsteroidHandler.getInstance().spawnAsteroid();
        }
        
        if (entity.getType() == ASTEROID) {
            
            if (entity.getIsHit()) {
                AsteroidHandler.getInstance().splitAsteroid(entity);
                return;
            }
            
            entity.setRadians(entity.getRadians() + entity.getRotationSpeed() * gameData.getDelta());
            
            updateShape(entity);
        }
    }
    
    private void updateShape(Entity ent) {
        float angle = 0;
        float[] shapeX = ent.getShapeX();
        float[] shapeY = ent.getShapeY();
        int numPoints = shapeX.length;
        float x = ent.getX();
        float y = ent.getY();
        // gets the Distance object from the Entity.
        float[] dist = ent.get(Distance.class).getDistances();
        
        for (int i = 0; i < numPoints; i++) {
            shapeX[i] = (x + (float) Math.cos(angle + ent.getRadians()) * dist[i]);
            shapeY[i] = (y + (float) Math.sin(angle + ent.getRadians()) * dist[i]);
            angle += 2 * Math.PI / numPoints;
        }
        ent.setShapeX(shapeX);
        ent.setShapeY(shapeY);
    }
    
}
