package MotoGp;


import jugador.excepciones.JugadorExcepcion;
import MotoGp.Jugador;
import MotoGp.Moto;
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
    
    public void adicionarMoto(Jugador jugador)
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

     public Jugador obtenerJugador(short codigo ) throws JugadorExcepcion
    {
        if(cabeza !=null)
        {
            if(cabeza.getDato().getCodigo()==codigo)
            {                
                return cabeza.getDato();
            }
            else
            {
                Moto temp=cabeza;
                while(temp!=null)
                {
                    if(temp.getDato().getCodigo()== codigo)
                    {                                                
                        return temp.getDato();
                    }
                    temp = temp.getSiguiente();
                }
                
                throw new JugadorExcepcion("El código "+codigo +" no existe en la lista");
            }
        }
        throw new JugadorExcepcion("La lista de jugadores está vacía");
    }  
     
   }
       

