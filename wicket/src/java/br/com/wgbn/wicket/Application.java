/*
 * Application.java
 *
 * Created on 12 de Setembro de 2015, 16:01
 */
 
package br.com.wgbn.wicket;           

import org.apache.wicket.protocol.http.WebApplication;
/** 
 *
 * @author root
 * @version 
 */

public class Application extends WebApplication {

    public Application() {
    }

    public Class getHomePage() {
        return HomePage.class;
    }

}
