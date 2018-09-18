/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

/**
 *
 * @author felipetellezdj
 */
public class Celda {
    
    boolean cubierta;
    boolean bandera;
    String valor;
  
    public Celda() {
        this.valor = ".";
        boolean cubierta = true;
        boolean bandera = false;
    }
     

    public String getValor() {
        return valor;
    }

     
    public boolean isBandera() {
        boolean es_bandera = false;
        if(this.valor.equalsIgnoreCase("P")){
            es_bandera = true;
        }
        return es_bandera;
    }
    
    public boolean es_mina() {
        boolean es_mina = false;
        if(this.valor.equalsIgnoreCase("*")){
            es_mina = true;
        }
        return es_mina;
    }

    public boolean isCubierta() {
        return cubierta;
    }

    public void setMina() {
        this.valor = "*";
    }

    public void setBandera(boolean bandera) {
        
        this.bandera = true;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
     public void setCubierta(boolean cubierta) {
        this.cubierta = cubierta;
    }
    
    public void mostrar(){
        this.cubierta = false;
    }
    
    public void marcar(){
        this.bandera = true;
    }

}
