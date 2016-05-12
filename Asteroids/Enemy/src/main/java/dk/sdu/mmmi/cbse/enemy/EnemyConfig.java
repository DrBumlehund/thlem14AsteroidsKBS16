/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.enemy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author thomaslemqvist
 */
@Configuration
public class EnemyConfig {

    @Bean
    @Scope(value = "prototype")
    public EnemyAIControlSystemBean createEnemyAIProcessingService() {
        System.out.println("Create shit spring, sumfin");
        return new EnemyAIControlSystemBean();
    }

    @Bean
    @Scope(value = "prototype")
    public EnemyPluginBean createPlayerPluginService() {
        System.out.println("Create shit spring, sumfin");
        return new EnemyPluginBean();
    }
}
