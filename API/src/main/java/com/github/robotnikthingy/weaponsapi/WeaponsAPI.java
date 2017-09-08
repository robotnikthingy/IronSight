package com.github.robotnikthingy.weaponsapi;

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

    public static final WeaponsAPI API = new WeaponsAPI();
    private IWeaponsAPI weaponsAPI;

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