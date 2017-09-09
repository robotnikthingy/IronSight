package com.github.robotnikthingy.weaponsapi;

import com.github.robotnikthingy.weaponsapi.manager.IWeaponManager;

/**
 * The main class bridging the API and WeaponsAPI plugin implementation.
 * Most values retrieved from the API will be interfaces and implemented in the
 * plugin rather than being publicly accessible to developers. If access to the
 * implementation is required, a separate maven repository is available
 * <p>
 * <br><b>Group ID:</b> com.github.robotnikthingy
 * <br><b>Artifact ID (API):</b> WeaponsAPI
 * <br><b>Artifact ID (Implementation):</b> WeaponsPlugin
 * 
 * @author ysl3000
 */
public class WeaponsAPI {

    private static IWeaponsAPI weaponsAPI;

    private WeaponsAPI() {}
    
    /**
     * Set the implementation to use for the Weapons API. This should be used
     * in implementation ONLY. Any attempt to invoke this method will result in
     * a runtime exception
     * 
     * @param weaponsAPI the new API implementation
     * 
     * @throws ExceptionInInitializerError if the API has already been set
     */
    public static void setAPI(IWeaponsAPI weaponsAPI) {
        if (WeaponsAPI.weaponsAPI != null)
            throw new ExceptionInInitializerError("API already initialized.");
        
        WeaponsAPI.weaponsAPI = weaponsAPI;
    }

    /**
     * Get the API compatibility layer bridging the API to the plugin
     * 
     * @return the API compatibility layer
     */
	public static IWeaponsAPI getAPI() {
		return weaponsAPI;
	}
	
	/**
	 * Get the plugin weapon manager. All weapons should be registered here in order
	 * to be handled by the plugin
	 * 
	 * @return the weapon manager
	 */
	public static IWeaponManager getWeaponManager() {
		return weaponsAPI.getWeaponManager();
	}

}