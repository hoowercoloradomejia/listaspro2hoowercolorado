package MotoGp;

import java.io.Serializable;

public class Moto implements Serializable{
    private Jugador dato;
    private Moto siguiente;

    public Moto(Jugador dato) {
        this.dato = dato;
    }

    public Jugador getDato() {
        return dato;
    }

    public void setDato(Jugador dato) {
        this.dato = dato;
    }

    public Moto getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Moto siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
