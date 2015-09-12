/*
 * WicketExamplePage.java
 *
 * Created on 12 de Setembro de 2015, 16:01
 */
 
package br.com.wgbn.wicket;           

import org.apache.wicket.markup.html.WebPage;

/** 
 *
 * @author root
 * @version 
 */

public abstract class BasePage extends WebPage {

    public BasePage() { 
        super(); 
        add(new HeaderPanel("headerpanel", "Welcome To Wicket")); 
        add(new FooterPanel("footerpanel", "Powered by Wicket and the NetBeans Wicket Plugin"));
    } 

}
