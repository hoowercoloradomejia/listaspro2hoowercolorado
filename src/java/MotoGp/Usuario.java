
package MotoGp;

import com.listase.utilidades.JsfUtil;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;



@Named(value = "usuario")
@SessionScoped
public class Usuario implements Serializable{
    
    private String Usuario;
    private String Contrasena;

    public Usuario(String Usuario, String Contrasena) {
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;
    }
    
      
        public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Admin) {
        this.Usuario = Admin;
    }

    public String getContrasena() {
        return Contrasena="hoower";
    }

    public void setContrasena(String hoower) {
        this.Contrasena = hoower;
    }
    
    String confirmacion=new String();{
     if (Usuario.equals("Admin") && Contrasena.equals("hoower"));
    else
        {
            JsfUtil.addErrorMessage("Usuario o clave incorrecta");
        
}}}
    

