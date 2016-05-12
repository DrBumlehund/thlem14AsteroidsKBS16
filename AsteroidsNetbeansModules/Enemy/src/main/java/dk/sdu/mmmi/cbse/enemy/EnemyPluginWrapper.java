/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.enemy;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import java.util.Map;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author thomaslemqvist
 */
@ServiceProvider(service = IGamePluginService.class)
public class EnemyPluginWrapper implements IGamePluginService {

    protected static EnemyPluginBean enemyPlugin;

    @Override
    public void start(GameData gameData, Map<String, Entity> world) {
        EnemyHandler.getInstance().createBeans();
        System.out.println("start bean called.");
        if (enemyPlugin != null) {
            enemyPlugin.start(gameData, world);
        }
    }

    @Override
    public void stop(GameData gameData) {
        if (enemyPlugin != null) {
            enemyPlugin.stop(gameData);
        }
    }

}
