/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import static dk.sdu.mmmi.cbse.common.data.EntityType.ASTEROID;
import dk.sdu.mmmi.cbse.common.data.GameData;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author thomaslemqvist
 */
public class AsteroidHandler {

    private final int maxAsteroids = 3;
    private int numAsteroids = 0;

    protected final int SMALL_RADIUS = 6;
    protected final int MEDIUM_RADIUS = 10;
    protected final int LARGE_RADIUS = 20;
    protected final int SMALL = 8;
    protected final int MEDIUM = 10;
    protected final int LARGE = 12;

    protected final int maxPos = 100;
    protected final int minPos = -100;

    Random rng;
    Map<String, Entity> world;
    GameData gameData;

    private AsteroidHandler() {
        rng = new Random();
    }

    // Singleton pattern
    public static AsteroidHandler getInstance() {
        return AsteroidHandlerHolder.INSTANCE;
    }

    private static class AsteroidHandlerHolder {

        private static final AsteroidHandler INSTANCE = new AsteroidHandler();
    }

    public int getMaxAsteroids() {
        return maxAsteroids;
    }

    public int getNumAsteroids() {
        return numAsteroids;
    }

    protected Map<String, Entity> getWorld() {
        return world;
    }

    protected void setWorld(Map<String, Entity> world) {
        this.world = world;
    }

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }

    /**
     * used to create new asteroids.
     */
    protected void spawnAsteroid() {
        if (world != null && gameData != null) {
            if (numAsteroids < maxAsteroids) {
//                System.out.println("Spawning asteroid...");
                float x = rng.nextFloat() * gameData.getDisplayWidth();
                float y = rng.nextFloat() * gameData.getDisplayHeight();
                // calls its overload with random position by using a dummy Entity.
                Entity na = new Entity();
                na.setX(x);
                na.setY(y);
                spawnAsteroid(na);
            }
        }
    }

    protected void spawnAsteroid(Entity ent) {
        if (world != null && gameData != null) {
            Entity newEnt = new Entity();

            switch (ent.getShapeX().length) {
                case LARGE:
                    newEnt.setShapeX(new float[MEDIUM]);
                    newEnt.setShapeY(new float[MEDIUM]);
                    newEnt.setRadius(MEDIUM_RADIUS);
                    break;
                case MEDIUM:
                    newEnt.setShapeX(new float[SMALL]);
                    newEnt.setShapeY(new float[SMALL]);
                    newEnt.setRadius(SMALL_RADIUS);
                    break;
                case SMALL:
                    // The asteroid has been broken down as much as possible.
                    return;
                default:
                    // now we know that it is a new asteroid.
                    newEnt.setShapeX(new float[LARGE]);
                    newEnt.setShapeY(new float[LARGE]);
                    newEnt.setRadius(LARGE_RADIUS);
                    break;
            }

            newEnt.setPosition(ent.getX(), ent.getY());

            newEnt.setType(ASTEROID);

            newEnt.setIsHit(false);

            newEnt.setRadians(rng.nextFloat() * (float) (2 * Math.PI));

            newEnt.setRotationSpeed(rng.nextInt(7) - 3);
            newEnt.setAcceleration(100);
            newEnt.setMaxSpeed(120);

            newEnt.setDx(rng.nextFloat() * (maxPos - minPos) + minPos);
            newEnt.setDy(rng.nextFloat() * (maxPos - minPos) + minPos);

            setShapes(newEnt, newEnt.getShapeX().length);

            System.out.println("Creating asteroid @ x:" + newEnt.getX() + " y:" + newEnt.getY());
            world.put(newEnt.getID(), newEnt);
            numAsteroids++;
        }
    }

    protected void splitAsteroid(Entity ent) {
        if (world != null && gameData != null) {
            // creates two lesser asteroids, with different x positions.
            float[] newPositions = {ent.getX() - ent.getRadius(),
                ent.getX() + ent.getRadius()};
            for (int i = 0; i < 2; i++) {
                ent.setX(newPositions[i]);
                spawnAsteroid(ent);
            }
            removeAsteroid(ent);
        }
    }

    protected void removeAsteroid(Entity ent) {
        ent.disposeData();
        world.remove(ent.getID());
        numAsteroids--;
    }

    private void setShapes(Entity ent, int numPoints) {
        float[] dist = new float[numPoints];
        for (int i = 0; i < numPoints; i++) {
            float radius = ent.getRadius();
            dist[i] = rng.nextFloat() * (radius - radius / 2) + radius / 2;
        }
        Distance distance = new Distance(dist);
        ent.add(distance);
        ent.setShapeX(new float[numPoints]);
        ent.setShapeY(new float[numPoints]);
    }
}
