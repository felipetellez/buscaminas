/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

/**
 * Clase que se encaga del manejo de atributos y metodos de cada celda del juego
 * @author felipetellezdj
 */
public class Celda {
    
    boolean cubierta;
    boolean bandera;
    boolean mina;
    int valor;
  
    public Celda() {
        
        //ATRIBUTOS
        this.cubierta = true;
        this.bandera = false;
    }
     
    //Metodos get 
    public int getValor() {
        return valor;
    }

    public boolean isBandera() {
        return bandera;
    }

    public boolean isMina() {
        return mina;
    }
  
   
    public boolean isCubierta() {
        return cubierta;
    }

    //Metodos set
    public void setMina(boolean mina) {
        this.mina = mina;
    }

   
    public void setBandera(boolean bandera) {
        
        this.bandera = true;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
     public void setCubierta(boolean cubierta) {
        this.cubierta = cubierta;
    }
    
    /**
     * Metodo que asigna el atributo cubierta false para poder mostrar la celda
     */
    public void mostrar(){
        this.cubierta = false;
    }
    
    /**
     * Metodo que asigna al atributo bandera true para indicar que la celda esta marcada con una bandera
     */
    public void marcar(){
        this.bandera = true;
    }

}
