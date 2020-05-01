
package MotoGp;

public class Clave {
    
    private String Usuario;
    private String Contrasena;

    public Clave(String Usuario, String Contrasena) {
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
        return Contrasena;
    }

    public void setContrasena(String hoower) {
        this.Contrasena = hoower;
    }
    
    String clave=new String();{
     if (Usuario.equals("Admin") && clave.equals("hoower"));}
    
    
}
