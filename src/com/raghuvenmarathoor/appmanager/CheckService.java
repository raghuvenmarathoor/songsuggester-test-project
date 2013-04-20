/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raghuvenmarathoor.appmanager;

/**
 *
 * @author New User
 */
public class CheckService {

    private static String checkService() {
        com.raghuvenmarathoor.appmanager.CheckAvailability_Service service = new com.raghuvenmarathoor.appmanager.CheckAvailability_Service();
        com.raghuvenmarathoor.appmanager.CheckAvailability port = service.getCheckAvailabilityPort();
        return port.checkService();
    }
    public boolean check(){
        String result = checkService();
        if(result.equals("success")){
            return true;
        }
        return false;
    }
}
