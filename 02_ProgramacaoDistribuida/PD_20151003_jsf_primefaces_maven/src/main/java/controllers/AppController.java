package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by walter on 20/10/15.
 */
@ManagedBean
@SessionScoped
public class AppController {

    private String host;
    private String port;
    private String user;
    private String pass;
    private String erro;

    public AppController(){
        try {
            host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
            port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
            user = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
            pass = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
        } catch (Exception e){
            erro = e.getStackTrace().toString();
        }
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
