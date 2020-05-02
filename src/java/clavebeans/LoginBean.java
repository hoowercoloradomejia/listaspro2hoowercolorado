
package clavebeans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Hoower Colorado Meji
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
        //Atributo oculta  panel login
    private boolean verPanelLogin=false;
    //Atributo mostrar  saludo
    private String textSaludo="";
    //Atributo contador saludo
    private short contadorSaludos=0;
    
    
    public LoginBean() {
    }

    public boolean isVerPanelLogin() {
        return verPanelLogin;
    }

    public void setVerPanelLogin(boolean verPanelLogin) {
        this.verPanelLogin = verPanelLogin;
    }

    public String getTextSaludo() {
        return textSaludo;
    }

    public void setTextSaludo(String textSaludo) {
        this.textSaludo = textSaludo;
    }

    public short getContadorSaludos() {
        return contadorSaludos;
    }

    public void setContadorSaludos(short contadorSaludos) {
        this.contadorSaludos = contadorSaludos;
    }
    
   //metodo para mostrar o ocultar panel
    public void habilitarOdeshabilitarLogin(){
        verPanelLogin=!verPanelLogin;
    }
    
    
}
