/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSPElements;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 */
public class CookiesHandler {
    

    /**
     * Get the value of cookie given its name
     * @param name the name of the cookie
     * @param request the current instance of the HttpServleRequest in jsp system
     * @return the value of cookie
     */
    public String getCookie(String name, HttpServletRequest request)
    {
        Cookie[] cookies = request.getCookies();
        String value = "";
        for(Cookie singleCookie : cookies)
        {
            if(singleCookie.getName().equals(name))
            {
                value = singleCookie.getValue();
            }
        }
        return value;
    }
    
    /**
     * Check if name of cookie exist
     * @param name the name of cookie
     * @param request the obbject HttpServlet
     * @return boolean true if the name exist else return false
     */
    public Boolean isValidCookie(String name, HttpServletRequest request)
    {
        Boolean state = false;
        Cookie[] cookies = request.getCookies();
        
        for(Cookie singleCookie : cookies)
        {
            if(singleCookie.getName().equals(name))
            {
                state = true;
            }
        }
        return state;
    }
    
}
