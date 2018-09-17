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
    boolean hay_mina, hay_bandera;
    boolean estado = false;

    public boolean isHay_mina() {
        return hay_mina;
    }

    public boolean isHay_bandera() {
        return hay_bandera;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setHay_mina(boolean hay_mina) {
        this.hay_mina = hay_mina;
    }

    public void setHay_bandera(boolean hay_bandera) {
        this.hay_bandera = hay_bandera;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
   
    
}
