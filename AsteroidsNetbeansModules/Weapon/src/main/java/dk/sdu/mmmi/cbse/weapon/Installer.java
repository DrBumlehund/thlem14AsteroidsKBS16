/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.weapon;

import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        System.out.println("Weapon Installed");
    }

    @Override
    public void uninstalled() {
        System.out.println("Weapon Uninstalled");
        super.uninstalled();
    }

}
