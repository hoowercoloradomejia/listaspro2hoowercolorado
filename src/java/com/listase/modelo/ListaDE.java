/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.modelo;

import com.listase.excepciones.InfanteExcepcion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaDE {
    
    private NodoDE inicio;
    private NodoDE cola;
    
    public ListaDE(){
       inicio=null;
       cola=null;
    }

    public NodoDE getInicio() {
        return inicio;
    }

    public void setInicio(NodoDE inicio) {
        this.inicio = inicio;
    }

    public NodoDE getCola() {
        return cola;
    }

    public void setCola(NodoDE cola) {
        this.cola = cola;
    }
    
    
    public void insertarInicio(Infante dato){
        if(inicio == null)
        {   inicio = new NodoDE(dato,null,null);
            cola=inicio;}
        else{
            NodoDE nuevo = new NodoDE(dato,null,null);
            inicio=nuevo;
        }}
    
         public void insertarCola(Infante dato){
        if(inicio == null)
        {   cola = new NodoDE(dato,null,null);
            inicio=cola;}
        else{
            NodoDE nuevo = new NodoDE(dato,null,null);
          
            cola=nuevo;
        }} 
         
         //eliminar nodo
         
        
         }
         
        

    