package com.github.robotnikthingy.weaponsapi;

/**
 * Created by ysl3000
 */
public class WeaponsAPI {

    public static final WeaponsAPI api = new WeaponsAPI();
    private WeaponsAPIInterface weaponsAPIInterface;

    private WeaponsAPI() {
    }

    public void setApi(WeaponsAPIInterface weaponsAPIInterface) {
        if (this.weaponsAPIInterface != null)
            throw new ExceptionInInitializerError("API already initialized.");
        this.weaponsAPIInterface = weaponsAPIInterface;
    }

    public WeaponsAPIInterface getWeaponsAPIInterface() {
        return weaponsAPIInterface;
    }


}
