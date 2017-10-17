/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstockapp;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Kyle
 * 
 * Singleton Class object manager for sharing references between classes.
 * God class is frowned upon and really this should be accomplished through
 * dependency injection of inter class dependencies directly into the class constructor of the objects that need them.
 * 
 * This class uses a map to map a string key (Which is to be the name of the class) to the class object that is registered
 * into this class using the registerService method.
 * 
 */
public class ServiceLocator {
    
    private final Map<String, Object> services = new HashMap<>();
    
    private static ServiceLocator uberstockservicelocator = null;
    
    private ServiceLocator ()
    {/* Singleton Trick */}
    
    /**
     * Singleton method, ether creates a new class reference to itself and returns that
     * or returns the singleton instance of the class already stored within.
     * 
     * @return ServiceLocator
     */
    public static ServiceLocator getServiceLocatorInstance()
    {
        if(uberstockservicelocator == null)
        {
            uberstockservicelocator = new ServiceLocator();
        }
        return uberstockservicelocator;
    }
    
    /**
     * key parameter is the String which should be the name of the class you are registering with this service locator.
     * service should be a new object created that you wish to associate with the key.
     * @param key
     * @param service
     */
    public void registerService(String key, Object service)
    {
        services.put(key,service);
    }
    
    /**
     * This method takes the String key (which should be the name of the class you wish to get)
     * and returns the object stored within the map that matches the key provided.
     * @param key
     * @return Object
     */
    public Object getService(String key)
    {
        return services.get(key);
    } 
    
    /**
     * This method takes the String key (which should be the name of the class you wish to remove)
     * and removes the key value pair if a match is found.
     * @param key
     */
    public void removeService(String key)
    {
        services.remove(key);
    }
}
