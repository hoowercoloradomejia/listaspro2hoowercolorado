package MotoGp;


import java.io.Serializable;

public class Jugador implements  Serializable{
    private String nombre; 
    private short codigo; 
    private byte edad;
    private boolean genero;
   
    public Jugador() {
        this.edad=0;
       
    }    
    
    public Jugador(String nombre, short codigo, byte edad, boolean genero) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.edad = edad;
        this.genero = genero;
        
    }

     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getCodigo() {
        return codigo;
    }

    public void setCodigo(short codigo) {
        this.codigo = codigo;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }
    
    @Override
    public String toString() {
       return this.nombre; 
    }
       
}
