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
 */
public class ServiceLocator {
    
    public static final String USER_SERVICE = "user";
    
    private final Map<String, Object> services = new HashMap<>();
    
    private static ServiceLocator uberstockservicelocator = null;
    
    private ServiceLocator ()
    {/* Singleton Trick */}
    
    public static ServiceLocator getServiceLocatorInstance()
    {
        if(uberstockservicelocator == null)
        {
            uberstockservicelocator = new ServiceLocator();
        }
        return uberstockservicelocator;
    }
    
    public void registerService(String key, Object service)
    {
        services.put(key,service);
    }
    
    public void removeService(String key)
    {
        services.remove(key);
    }
    
    public Object getService(String key)
    {
        return services.get(key);
    }
}
