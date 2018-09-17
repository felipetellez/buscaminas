/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import java.util.ArrayList;

/**
 *
 * @author felipetellezdj
 */
public class Tablero {
    int filas, columnas, casillas_Descubiertas;
    int[][] tamaño = new int[filas][columnas];
    boolean en_Juego;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.tamaño = new int[filas][columnas];
        this.en_Juego = true;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public int getCasillas_Descubiertas() {
        return casillas_Descubiertas;
    }

    public int[][] getTamaño() {
        return tamaño;
    }

    public boolean isEn_Juego() {
        return en_Juego;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public void setCasillas_Descubiertas(int casillas_Descubiertas) {
        this.casillas_Descubiertas = casillas_Descubiertas;
    }

    public void setTamaño(int[][] tamaño) {
        this.tamaño = tamaño;
    }

    public void setEn_Juego(boolean en_Juego) {
        this.en_Juego = en_Juego;
    }
    
    public void construir_Tablero(){
    
    }
    
    public void generar_Minas(){
        
    }
    
    public void reiniciar_Tablero(){
        
    }
    
    
    
    
}
