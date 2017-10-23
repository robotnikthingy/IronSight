package com.github.robotnikthingy.ironsight.weapon;

import com.github.robotnikthingy.ironsight.api.IronSight;
import com.github.robotnikthingy.ironsight.api.ammo.Ammunition;
import com.github.robotnikthingy.ironsight.api.mechanic.data.MechanicDataHandler;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * A loadout represent a 'state' of a weapon, and can be considered like a subweapon of a weapon
 * Damage, accuracy, etc, are attached to loadouts. A weapon has 9 loadouts (since there are 9 slots in the hotbar,
 * which will be where loadouts are shown).
 * This system allows us to switch between different ammo types (ex: armor piercing, incendiary, HEAT)
 * or different weapon attachments (ex: underbarrel grenade launcher, underbarrel shotgun)
 * by attaching the different weapon properies and ammo to a loadout.
 *
 * By default, each weapon has one loadout, which is usually the gun itself. Any additional loadouts are optional
 */
public class CustomWeaponLoadout {

    private int clipSize, maxAmmo, cooldown, ammo = 0;
    private double damage;
    private String name;
    private String[] lore;

    private boolean reloadOnSwitch;


    private MechanicDataHandler reloadHandler = IronSight.createMechanicDataHandler();
    private MechanicDataHandler shootingHandler = IronSight.createMechanicDataHandler();

    public CustomWeaponLoadout(String name){


    }

    public void loadConfigurationOptions(FileConfiguration configFile) {
        // TODO: Load any and all information from the configuration file
    }

    public void reload(Player player, Ammunition ammo) {
        int ammoCount = IronSight.getPlayer(player).getRemainingAmmunition(ammo);
        int requiredAmmo = getClipSize() - this.ammo;

        int toReload = Math.min(requiredAmmo, Math.min(ammoCount, getClipSize()));
        this.ammo += toReload;

        // Remove item from inventory
        ItemStack item = ammo.getItem();
        item.setAmount(toReload);
        player.getInventory().removeItem(item);
    }

    public MechanicDataHandler getReloadDataHandler() {
        return reloadHandler;
    }

    public MechanicDataHandler getShootingDataHandler() {
        return shootingHandler;
    }

    public int getClipSize() {
        return clipSize;
    }


    public int getMaxAmmo() {
        return maxAmmo;
    }


    public int getAmmo() {
        return ammo;
    }

    public double getDamage() {
        return damage;
    }

    public void shoot(Player player) {
        this.ammo--;
    }




}
