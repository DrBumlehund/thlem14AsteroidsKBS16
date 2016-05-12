/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.enemy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author thomaslemqvist
 */
public class EnemyHandler {

    private EnemyHandler() {

    }

    public static EnemyHandler getInstance() {
        return EnemyHandlerHolder.INSTANCE;
    }

    private static class EnemyHandlerHolder {

        private static final EnemyHandler INSTANCE = new EnemyHandler();
    }

    protected void createBeans() {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.register(EnemyConfig.class);
//        ctx.refresh();
//
//        EnemyAIControlSystemWrapper.enemyAiProcesser = (EnemyAIControlSystemBean) ctx.getBean(EnemyAIControlSystemBean.class);
//        EnemyPluginWrapper.enemyPlugin = (EnemyPluginBean) ctx.getBean(EnemyPluginBean.class);

        ApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");

        EnemyAIControlSystemWrapper.enemyAiProcesser = (EnemyAIControlSystemBean) ctx.getBean(EnemyAIControlSystemBean.class);
        System.out.println("Plugin created....");
        EnemyPluginWrapper.enemyPlugin = (EnemyPluginBean) ctx.getBean(EnemyPluginBean.class);
    }
}
