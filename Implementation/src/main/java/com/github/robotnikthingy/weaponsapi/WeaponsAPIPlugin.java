package com.github.robotnikthingy.weaponsapi;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Robotnik on 8/4/2017.
 */
public class WeaponsAPIPlugin extends JavaPlugin {


    private WeaponsAPIInterface weaponsAPIInterface;

    @Override
    public void onEnable() {
        this.weaponsAPIInterface = new WeaponsAPIImplementation();
        WeaponsAPI.api.setApi(weaponsAPIInterface);

    }
}
