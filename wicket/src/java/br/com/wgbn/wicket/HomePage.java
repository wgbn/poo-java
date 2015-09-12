/*
 * HomePage.java
 *
 * Created on 12 de Setembro de 2015, 16:01
 */

package br.com.wgbn.wicket;           

import org.apache.wicket.markup.html.basic.Label;

public class HomePage extends BasePage {

    public HomePage() {
        add(new Label("message", "Hello, World!"));
    }

}
