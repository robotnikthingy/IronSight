package com.github.robotnikthingy.weaponsapi;

/**
 * Created by ysl3000
 */
public class WeaponsAPI {

    public static final WeaponsAPI API = new WeaponsAPI();
    private IWeaponsAPI weaponsAPI;

    private WeaponsAPI() {}

    public void setAPI(IWeaponsAPI weaponsAPI) {
        if (this.weaponsAPI != null)
            throw new ExceptionInInitializerError("API already initialized.");
        
        this.weaponsAPI = weaponsAPI;
    }

    /**
     * Get the API compatibility layer bridging the API to the plugin
     * 
     * @return the API compatibility layer
     */
	public IWeaponsAPI getAPI() {
		return weaponsAPI;
	}

}