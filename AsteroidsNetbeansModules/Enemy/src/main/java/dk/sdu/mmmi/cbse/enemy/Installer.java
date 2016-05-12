/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.enemy;

import org.openide.modules.ModuleInstall;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author thomaslemqvist
 */
public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        System.out.println("Enemy started.");
    }

    @Override
    public void uninstalled() {
        System.out.println("Enemy Uninstalled");
        super.uninstalled();
    }
}
