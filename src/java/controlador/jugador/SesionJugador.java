package controlador.jugador;



import jugador.excepciones.JugadorExcepcion;
import MotoGp.Jugador;
import MotoGp.ListaJU;
import MotoGp.Moto;
import com.listase.excepciones.InfanteExcepcion;
import com.listase.modelo.Infante;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.DiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.FlowChartConnector;
import org.primefaces.model.diagram.connector.StateMachineConnector;
import org.primefaces.model.diagram.endpoint.BlankEndPoint;
import org.primefaces.model.diagram.endpoint.EndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;
import org.primefaces.model.diagram.overlay.ArrowOverlay;
import org.primefaces.model.diagram.overlay.LabelOverlay;
import com.listase.utilidades.JsfUtil;

@Named(value = "sesionJugador")
@SessionScoped
public class SesionJugador implements Serializable {
    private ListaJU listaJugadores;
    private Jugador jugador;
    private String alInicio="1";
    private boolean deshabilitarFormulario=true;
    private Moto ayudante;   
    private String textoVista="Gráfico";
    
    private List listadoJugadores;
    
    private DefaultDiagramModel model;
    
    private short jugadorSeleccionado;
    
    private Jugador jugadorDiagrama;
    
    public SesionJugador() {        
    }
    
    @PostConstruct
    private void inicializar()
    {
         
        listaJugadores = new ListaJU();        
        
        listaJugadores.adicionarMoto(new Jugador("",(short) 1, (byte)2, true));
                
        ayudante = listaJugadores.getCabeza();
        jugador = ayudante.getDato();     
        
        listadoJugadores = listaJugadores.obtenerListaJugadores();
        pintarLista();
   }

    public Jugador getJugadorDiagrama() {
        return jugadorDiagrama;
    }

    public void setInfanteDiagrama(Jugador infanteDiagrama) {
        this.jugadorDiagrama = jugadorDiagrama;
    }
    
    public short getJugadorSeleccionado() {
        return jugadorSeleccionado;
    }

    public void setJugadorSeleccionado(short jugadorSeleccionado) {
        this.jugadorSeleccionado = jugadorSeleccionado;
    }
    
    public DiagramModel getModel() {
        return model;
    }
     
    private Connection createConnection(EndPoint from, EndPoint to, String label) {
        Connection conn = new Connection(from, to);
        conn.getOverlays().add(new ArrowOverlay(20, 20, 1, 1));
         
        if(label != null) {
            conn.getOverlays().add(new LabelOverlay(label, "flow-label", 0.5));
        }
         
        return conn;
    }

    public String getTextoVista() {
        return textoVista;
    }

    public void setTextoVista(String textoVista) {
        this.textoVista = textoVista;
    }
  
    public List getListadoJugadores() {
        return listadoJugadores;
    }

    public void setListadoJugadores(List listadoJugadores) {
        this.listadoJugadores = listadoJugadores;
    }
    
    

    public boolean isDeshabilitarFormulario() {
        return deshabilitarFormulario;
    }

    public void setDeshabilitarFormulario(boolean deshabilitarFormulario) {
        this.deshabilitarFormulario = deshabilitarFormulario;
    }

    public String getAlInicio() {
        return alInicio;
    }

    public void setAlInicio(String alInicio) {
        this.alInicio = alInicio;
    }
    
    public ListaJU getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ListaJU listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
     public void guardarJugador()
    {
       jugador.setCodigo((short)(listaJugadores.contarMotos()+1));
        if(alInicio.compareTo("1")==0)
        {
            listaJugadores.adicionarMotoAlInicio(jugador);
        }
        else
        {
            listaJugadores.adicionarMoto(jugador);
        }  
        listadoJugadores = listaJugadores.obtenerListaJugadores();
        pintarLista();
        deshabilitarFormulario=true;
        JsfUtil.addSuccessMessage("El jugador se ha guardado exitosamente");
        
    }
    
    public void habilitarFormulario()
    {
        deshabilitarFormulario=false;
        jugador = new Jugador();
    }
    
    public void irSiguiente()
    {
        if(ayudante.getSiguiente()!=null)
        {
            ayudante = ayudante.getSiguiente();
            jugador = ayudante.getDato();
        }        
    }
    
    public void irPrimero()
    {
        if(listaJugadores.getCabeza()!=null)
        {
            ayudante = listaJugadores.getCabeza();
            jugador = ayudante.getDato();
            
        }
        else
        {
            jugador = new Jugador();
        }
        listadoJugadores = listaJugadores.obtenerListaJugadores();
        pintarLista();
             
    }
    
    public void irUltimo()
    {
        if(listaJugadores.getCabeza()!=null)
        {            
            while(ayudante.getSiguiente()!=null)
            {
                ayudante = ayudante.getSiguiente();
            }
            jugador=ayudante.getDato();
        }
    }
    
    public void cambiarVistaJugadores()
    {
        if(textoVista.compareTo("Tabla")==0)
        {
            textoVista = "Gráfico";
        }
        else
        {
            textoVista = "Tabla";
        }
    }
    
    public void invertirLista(){
        listaJugadores.invertirLista();
        irPrimero();
    }
    
     public void pintarLista() {
        //Instancia el modelo
        model = new DefaultDiagramModel();
        //Se establece para que el diagrama pueda tener infinitas flechas
        model.setMaxConnections(-1);

        StateMachineConnector connector = new StateMachineConnector();
        connector.setOrientation(StateMachineConnector.Orientation.ANTICLOCKWISE);
        connector.setPaintStyle("{strokeStyle:'#7D7463',lineWidth:3}");
        model.setDefaultConnector(connector);

        ///Adicionar los elementos
        if (listaJugadores.getCabeza() != null) {
            //llamo a mi ayudante
            Moto temp = listaJugadores.getCabeza();
            int posX=10;
            int posY=2;
            //recorro la lista de principio a fin
            while(temp !=null)
            {
                //Parado en un elemento
                //Crea el cuadrito y lo adiciona al modelo
                Element ele = new Element(temp.getDato().getCodigo()+" "+
                        temp.getDato().getNombre(), 
                        posX+"em", posY+"em");
                ele.setId(String.valueOf(temp.getDato().getCodigo()));
                //adiciona un conector al cuadrito
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.TOP));
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_RIGHT));
                model.addElement(ele);                    
                temp=temp.getSiguiente();
                posX=  posX+5;
                posY= posY+6;
            }            
           
                      
        }
    }
    
    public void onClickRight() {
        String id = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("elementId");
         
        jugadorSeleccionado = Short.valueOf(id.replaceAll("frmJugador:diagrama-", ""));
        
    }
     public void obtenerJugadorDiagrama()
    {
        try {
            jugadorDiagrama = listaJugadores.obtenerJugador(jugadorSeleccionado);
        } catch (JugadorExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    
     public void perderPosicion()
    {
        try {
            Jugador infTemporal = listaJugadores.obtenerJugador(jugadorSeleccionado);
           listaJugadores.eliminarJugador(jugadorSeleccionado);
           listaJugadores.adicionarMoto(infTemporal);
            pintarLista();
        } catch (JugadorExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    public void Adelantar()
    {
        try {
            Jugador infTemporal = listaJugadores.obtenerJugador(jugadorSeleccionado);
            listaJugadores.eliminarJugador(jugadorSeleccionado);
            listaJugadores.adicionarMotoAlInicio(infTemporal);
            
            pintarLista();
        } catch (JugadorExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    
}
    

