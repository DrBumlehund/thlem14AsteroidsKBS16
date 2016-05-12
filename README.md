# thlem14AsteroidsKBS16
To use the game:
- Change the directory specified in the bundles.properties in the SilentUpdate module.
- Sometimes there are an odd bug, with the silent updater, where it will call the start() method, before the ModuleIntall has run. this causes the core to be the only active module at first glance. but by making a small change in the updates.xml, all modules load/unload as they should (except the OSGi bundles).
