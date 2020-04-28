package MotoGp;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ListaJU implements Serializable{
    private Moto cabeza;
    
    public ListaJU() {
    }

    public Moto getCabeza() {
        return cabeza;
    }

    public void setCabeza(Moto cabeza) {
        this.cabeza = cabeza;
    }
    
    public void adicionarNodo(Jugador jugador)
    {
        if(cabeza ==null)
        {
            cabeza = new Moto(jugador);
        }
        else
        {
            Moto temp= cabeza;
            while(temp.getSiguiente()!=null)
            {
                temp= temp.getSiguiente();
            }
           
            temp.setSiguiente(new Moto(jugador));
        }
        
    }
    
    public void adicionarMotoAlInicio(Jugador jugador)
    {
        if(cabeza ==null)
        {
            cabeza = new Moto(jugador);
        }
        else
        {
            Moto temp= new Moto(jugador);
            temp.setSiguiente(cabeza);
            cabeza= temp;
        }
    }
    
    public short contarMotos()
    {
        if(cabeza ==null)
        {
            return 0;
        }
        else
        {
            Moto temp= cabeza;
            short cont=1;
            while(temp.getSiguiente()!=null)
            {
                temp=temp.getSiguiente();
                cont++;
            }
            return cont;
        }
    }
    
    public String obtenerListadoJugadores()
    {
              
        return listarJugadores("");
    }
    
    public String listarJugadores(String listado)
    {
        if(cabeza !=null)
        {
            Moto temp= cabeza;            
            while(temp!=null)
            {
                listado += temp.getDato()+"\n";
                temp=temp.getSiguiente();
                
            }
            return listado;
        }
        return "No hay jugadores";
    }
    
    
     public List obtenerListaJugadores()
    {
        List<Jugador> listado = new ArrayList<>();
        
        listarJugadores(listado);
        return listado;
    }
    
    public void listarJugadores(List listado)
    {
        if(cabeza !=null)
        {
            Moto temp= cabeza;            
            while(temp!=null)
            {
                //listado += temp.getDato()+"\n";
                listado.add(temp.getDato());
                temp=temp.getSiguiente();                
            }            
        }
        
    }
    
    public float promediarEdades()
    {
        int sumaEdades= 0;
        int contador=0;
        if(cabeza !=null)
        {
            Moto temp= cabeza;            
            while(temp!=null)
            {          
                //sumaEdades= sumaEdades+ temp.getDato().getEdad();
                sumaEdades += temp.getDato().getEdad();
                contador++;
                temp=temp.getSiguiente();                
            }   
            return sumaEdades/(float) contador;
        }
        return 0;
        
    }
    public void invertirLista()
    {
        if(cabeza!=null)
        {
            ListaJU listaTemporal = new ListaJU();
            Moto temp= cabeza;
             while(temp!=null)
            {         
               listaTemporal.adicionarMotoAlInicio(temp.getDato());
                temp=temp.getSiguiente();                
            }   
            cabeza= listaTemporal.getCabeza();
        }
    }
    
   }
       

