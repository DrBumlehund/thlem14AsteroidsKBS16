/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.enemy;

import dk.sdu.mmmi.cbse.common.data.Entity;
import static dk.sdu.mmmi.cbse.common.data.EntityType.ENEMY;
import dk.sdu.mmmi.cbse.common.data.GameData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class EnemyPluginBean{

    private static final long SPAWNDELAY = 20000;
    private Map<String, Entity> world;
    private Random rng;
    private final List<Entity> enemies = new ArrayList<>();
    private GameData gameData;
 
    public void start(GameData gameData, Map<String, Entity> world) {
        this.world = world;
        this.gameData = gameData;
        rng = new Random();

        Timer spawnTimer = new Timer();
        spawnTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                createEnemyShip();
            }
        }, 0, SPAWNDELAY);
    }

    private void createEnemyShip() {
        Entity enemyShip = new Entity();
        enemyShip.setType(ENEMY);

        enemyShip.setPosition(rng.nextFloat() * gameData.getDisplayWidth(),
                rng.nextFloat() * gameData.getDisplayHeight());

        enemyShip.setMaxSpeed(150);
        enemyShip.setAcceleration(200);
        enemyShip.setDeacceleration(10);

        enemyShip.setShapeX(new float[4]);
        enemyShip.setShapeY(new float[4]);

        enemyShip.setRadians(3.1415f / 2);
        enemyShip.setRotationSpeed(5);

        enemyShip.setLife(1);

        enemyShip.setRadius(4);

        System.out.println("Creating Enemy at x:" + enemyShip.getX() + " y:" + enemyShip.getY());
        enemies.add(enemyShip);
        world.put(enemyShip.getID(), enemyShip);
    }

    public void stop(GameData gameData) {
        for (Entity enemy : enemies) {
            enemy.disposeData();
            world.remove(enemy.getID());
        }
    }

}
