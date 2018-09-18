/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import java.util.Scanner;
import java.util.StringTokenizer;
import buscaminas.Tablero;
/**
 *
 * @author felipetellezdj
 */
public class Buscaminas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            
            System.out.println("Bienvenido a Buscaminas");

            Scanner entrada = new Scanner(System.in);
            System.out.println("Ingrese el número de filas y columnas del tablero separado por espacio y seguido del numero de minas." + "\n"
                    + "Ej: 8 5 10 representa un tablero de 8 filas, 5 columnas y 10 minas aleatorias.");
            String entrada_ingresada = entrada.nextLine();

            String[] datos_ingresados_separados = entrada_ingresada.split(" ");

            int filas_ingresadas = Integer.parseInt(datos_ingresados_separados[0]);
            int columnas_ingresados = Integer.parseInt(datos_ingresados_separados[1]);
            int minas_ingresadas = Integer.parseInt(datos_ingresados_separados[2]);

            Tablero tablero = new Tablero(filas_ingresadas, columnas_ingresados, minas_ingresadas);
            tablero.asignar_tamaño_tablero();


            boolean juego_loop = true, victoria = false;

            while(juego_loop ==true && victoria == false){
                tablero.imprimir_tablaro(); 
                System.out.print("Ingrese su jugada fila, columna ,jugada. Jugada puede ser U para descubrir celda o M para marcar con bandera \n");

                String jugada_ingresada = entrada.nextLine();
                String[] jugada_ingresada_separada = jugada_ingresada.split(" ");
                int coord_y_jugada = Integer.parseInt(jugada_ingresada_separada[0]);
                int coord_x_jugada = Integer.parseInt(jugada_ingresada_separada[1]);
                String jugada = jugada_ingresada_separada[2];
                
                if(jugada.equalsIgnoreCase("M")){
                    tablero.tableroDeCeldas[coord_y_jugada-1][coord_x_jugada-1].marcar();
                    
                }
                else {
                    tablero.escoger_celda(coord_y_jugada-1, coord_x_jugada-1);

                    if(tablero.es_valido(coord_y_jugada-1, coord_x_jugada-1) && tablero.tableroDeCeldas[coord_y_jugada-1][coord_x_jugada-1].es_mina()){
                        juego_loop = false;
                    }
                    
                }

                if(tablero.no_faltan_celdas()){
                    tablero.marcar_todas_las_minas();
                    victoria= true;
                }

            }

            tablero.imprimir_tablaro();

            if(victoria == false){
                System.out.println("Game Over");
            }
            else{
                System.out.println("Ganaste");
            }
        }
        
        catch(Exception e){
            e.getMessage();
            System.err.println("Se ha producido un error");
        }
    }
    
}
