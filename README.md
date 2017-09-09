# Weapons API

WeaponsAPI is a collaborative community effort to replace the aging, closed source, and abandoned Crackshot plugin. The plugin will allow server admins to create a variety of weapons of all kinds, and provide much greater flexibilty using a system of modules and events. The plugin will provide more in depth options and configuration using a system similar to MythicMobs and Crackshot.

## Features of the plugin



Some functions of the plugin include:

### Events system
The plugin will use a system of events, requirements, and modules to determine weapon behavior, like a combination of what CrackShot, CrackShotPlus, and MythicArtifacts uses. It will allow for a lot more customization that what was ever possible with either Crackshot or CrackshotPlus. See example config below for how it will look like.

### The Loadout System
The loadout system will allow a gun to have multiple types of attachments equipped, as well as the ability to switch between weapon types and use special abilities. The loadout bar can be accessed by pressing the **F** key. A loadout can be one of 2 things right now: Ammo or Ability. Ammmo allows the gun to fire different types of ammo or switch between different attachments if the gun has them. abilities allow for special abilities which have cooldowns, such as reducing reload for a short duration, or calling in a barrage of rockets on an enemy. This will work similar to the plugin 'Magic', where it will replace the items in your hotbar with icons which you can use to select the loadout you want


A simple weapon will have 1 loadout, which just allows the bullet to fire one type of ammunition. A complex weapon can have multiple types of ammo it can switch to, and multiple abilities which can allow for a variety of different playstyles.

### Custom Explosions
Crackshot was very limited in customizing explosions, cluster bombs, and airstrikes. WeaponsAPI will feature a Custom Explosion system which allows for the creation of very complex explosions and effects. Custom Explosions can have multiple radius's which determine how much damage is done depending on how far away from the explosions an entity is, as well as other options such as potion effects, knockback, etc. Explosions can also shoot shrapnel in all directions which can cause damage to anyone hit by it, and a lot more.

### Custom Projectiles
Projctiles which the weapon will shoot will be placed in their own folder, and have their own seperate configuration. Projectiles cannot only be shot from guns, but also from explosions, abilities, and you can even make projectiles which shoot other projectiles! Accuracy will work similar to regular crackshot, with more finetuning options available like seen in CrackShotPlus. Custom sounds and particle trails will also be supported

### Custom Ammo Items
Custom Ammo Items can be configured to be used as ammo. Ammo Items will also have their own folder where they can be placed in. Ammo Items can be given different names and lore, as well as data ID's which will allow for custom models to be used. If the Lore or Item data is changed, it will be automatically updated by the plugin similar to how CrackShotPlus works.

### Leveling System
The plugin will include and **optional** leveling system for guns. This system will use an experience points system, which can be configured to improve stats of guns as the player levels them up. It can also be used to unlock new abailities and attachments as well when the player reaches a certain level

### API
There will be an API which will allow other plugins to easily add their own modules, events, actions, requirements, and more to WeaponsAPI, allowing for expansion which was not easily available with CrackShot. This plugin is also meant as a way to standardize weapons accross all plugins, meaning plugin developers who want weapons in their plugin would no longer need to code them themselves, but instead can use WeaponsAPI in their plugin and let WeaponsAPI do all the heavy work. This also allows for compatability and consistency between different weapons from different plugins.

### Open Source
Unlike CrackShot, WeaponsAPI will be an open sourced community effort, no worrying about the project becoming abandoned with no way to update it.


## Example Configs
These configs show how the AK-47 and Bazooka could be implemented in WeaponsAPI. I am using these configs as a base from which we can build the plugin around, so we can have a sense of how it will work. Any feedback is appreciated

[Example Weapons Config](https://github.com/robotnikthingy/WeaponsAPI/blob/master/Implementation/src/main/resources/ExampleGunsConfig.yml)

[Example Projectile Config](https://github.com/robotnikthingy/WeaponsAPI/blob/master/Implementation/src/main/resources/ExampleProjectileConfig.yml)

[Example Explosions Config](https://github.com/robotnikthingy/WeaponsAPI/blob/master/Implementation/src/main/resources/ExampleExplosionsConfig.yml)

[Example Ammo Item Config](https://github.com/robotnikthingy/WeaponsAPI/blob/master/Implementation/src/main/resources/ExampleAmmoItemConfig)
