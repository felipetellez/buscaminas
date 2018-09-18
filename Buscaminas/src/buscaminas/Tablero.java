/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import java.util.EmptyStackException;

/**
 * Clase que maneja los elementos los objetos Celda del tablero del juego de buscaminas
 * @author felipetellezdj
 */
public final class Tablero {
    
    //Atributos
    int filas, columnas, minas, casillas_descubiertas, minas_restantes, celdas_sin_minas;
    Celda[][] tableroDeCeldas;
    boolean primera_eleccion; 
    
    /**
     * Constructor
     * @param filas
     * @param columnas
     * @param minas
     */
    public Tablero(int filas, int columnas, int minas) {
        this.filas = filas;
        this.columnas = columnas;
        this.minas = minas;
        this.minas_restantes= minas;
        this.celdas_sin_minas = filas * columnas - minas;
        this.asignar_tamaño_tablero();
        this.primera_eleccion = true;
    }

    //Medodos GET
    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public int getMinas() {
        return minas;
    }

    public int getCasillas_descubiertas() {
        return casillas_descubiertas;
    }

    public int getMinas_restantes() {
        return minas_restantes;
    }

    public int getCasillas_sin_minas() {
        return celdas_sin_minas;
    }

    public Celda[][] getTableroDeCeldas() {
        return tableroDeCeldas;
    }

    public boolean isPrimera_eleccion() {
        return primera_eleccion;
    }
    
    
   
    //Metodos sets
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }
    
    public void setMinas(int minas) {
        this.minas = minas;
    }

    public void setCasillas_descubiertas(int casillas_descubiertas) {
        this.casillas_descubiertas = casillas_descubiertas;
    }

    public void setMinas_restantes(int minas_restantes) {
        this.minas_restantes = minas_restantes;
    }

    public void setCasillas_sin_minas(int casillas_sin_minas) {
        this.celdas_sin_minas = casillas_sin_minas;
    }

    public void setTableroDeCeldas(Celda[][] tableroDeCeldas) {
        this.tableroDeCeldas = tableroDeCeldas;
    }

    public void setPrimera_eleccion(boolean primera_eleccion) {
        this.primera_eleccion = primera_eleccion;
    }
    
    

    /**
     * Metodo que asigna el tamaño inicial del tablero
     */
    public void asignar_tamaño_tablero(){
        
        if(this.filas < 0 || this.columnas<0 ){
            System.out.println("No puedes ingresar valores negativos");
        }else{
            //Inicializo la matriz de objetos celdas con el tamaño de filas y columnas que tiene como atributo la clase tablero
            tableroDeCeldas = new Celda[this.filas][this.columnas];
            for (int i = 0; i < tableroDeCeldas.length; i++) {
                for (int j = 0; j < tableroDeCeldas[i].length; j++) {
                    tableroDeCeldas[i][j] = new Celda();
                    
                }
                
            }
        }       
    }
    
    /**
     * Metodo para imprimir el tablero en consola
     */
    public void imprimir_tablaro(){

        for (int i = 0; i < tableroDeCeldas.length; i++) {

            for (int j = 0; j < tableroDeCeldas[i].length ; j++) {
                if(tableroDeCeldas[i][j].isCubierta() == true){
                    if(tableroDeCeldas[i][j].isBandera() == true){
                        System.out.print("P ");
                    }
                    else{
                        System.out.println(". ");
                    }
                }
                else if(tableroDeCeldas[i][j].getValor().equalsIgnoreCase("0")){
                        System.out.print("0 ");
                    }
                    else if(tableroDeCeldas[i][j].getValor().equalsIgnoreCase("*")){
                            System.out.print("* ");
                        }
                        else{
                            System.out.print(tableroDeCeldas[i][j].getValor()+" ");
                        }
 
            }System.out.println("\n");
            
        }
    }
    
    /**
     *  Metodo que asigna las minas de manera aleatoria con base a el atributo minas de esta clase Tablero
     */
    public void generar_minas(){     
        // el numero de minas que se pondran aleatoriamente no puede ser mayor que el atributo minas de la clase
        for (int mina = 0; mina < this.minas; mina++) {
            //creo unas variables que me serviran de coordenadas para saber donde colocare las minas
            int coordenada_x, coordenada_y;
          
            coordenada_x = (int) (Math.random()* this.columnas)  ;
            coordenada_y = (int) (Math.random()* this.filas) ;

            
            if( !tableroDeCeldas[coordenada_y][coordenada_x].es_mina() && !tableroDeCeldas[filas -1][columnas - 1].es_mina() ) {
		//Si el punto aleatorio no es mina NI el punto entregado como argumento.
		tableroDeCeldas[coordenada_y][coordenada_x].setMina();
			
            }
        }
    }
    
    /**
     * Asigna los números del 1-8 que van en el tablero y que indican el número de minas que hay alrededor de una celda
     */
    public void asignar_num_minas_alrededor(){
        for (int i = 0; i < this.tableroDeCeldas.length; i++) {
            for (int j = 0; j < this.tableroDeCeldas[i].length; j++) {
                //Si la celda actual es una mina no es necesario asignarle un valor
                //Si no es una mina, cuento las minas alrededor y le asigno un valor.
                if(tableroDeCeldas[i][j].es_mina() == false){ 
                    tableroDeCeldas[i][j].setValor(String.valueOf(this.contador_minas_alrededor(i,j)));
                }    
                
            }          
        }
    }
    
    /**
     * Metodo que cuenta el número de minas alrededor de una celda
     * @param coord_x
     * @param coord_y
     * @return int numero de minas alrededor de una celda
     */
    public int contador_minas_alrededor(int coord_y, int coord_x){
        
        
        //Verifico que las coordenadas pertenecan al tablero
       
            if(!es_valido(coord_y, coord_x)){
                System.err.println("coordenada por fuera del rango");
            }
            
            int contador = 0;
            for (int coordenada_y = coord_y-1; coordenada_y <= coord_x+1; coordenada_y++) {
                for (int coordenada_x = coord_x-1; coordenada_x <= coord_x+1; coordenada_x++) {
                    if(es_valido(coord_y, coord_x) && tableroDeCeldas[coord_y][coord_x].es_mina()){
                        contador++;
                    }
                        
                }
            }
     
         return contador;
        
    }
    
    /**
     * Metodo que devuelve true si el punto está dentro del tablero y false si no lo está
     * @param coord_x
     * @param coord_y
     * @return
     */
    public boolean es_valido(int coord_y, int coord_x){
        return (-1 < coord_x && coord_x < tableroDeCeldas[0].length) && (-1 < coord_y && coord_y < tableroDeCeldas.length );
    }
    
    /**
     * Metodo recursivo que revisa si una celda esta "vacia" y la deshabilita. Ademas revisa si las que lo rodean igualmente estan vacias y asi sucesivamente
     * @param x
     * @param y
     */
    public void mostrar_cuadros_deshabilitados(int y, int x) {

	if(es_valido(y, x) && tableroDeCeldas[y][x].getValor().equalsIgnoreCase("0") && tableroDeCeldas[y][x].isCubierta()) {
		tableroDeCeldas[y][x].mostrar();
		for(int coord_y = y-1; coord_y <= y+1; coord_y++){
			for(int coord_x = x-1; coord_x <= x+1; coord_x++) {
			//Con estos dos for puedo moverme por los 8 cuadrados circundantes
				if(es_valido(coord_y, coord_x) && Integer.parseInt(tableroDeCeldas[coord_y][coord_x].getValor())> 0 && !tableroDeCeldas[y][x].es_mina()){
                                    //Muestro los números que hayan
                                    tableroDeCeldas[coord_y][coord_x].mostrar();
                                }
				
				mostrar_cuadros_deshabilitados(coord_y, coord_x);
			}
                }
	}
    }
    
    
    /**
     *  
     * @return
     */
    public int celdasMostradas(){
        int celdasMostradas = 0;
       
        for (int y = 0; y < tableroDeCeldas.length; y++) {
            for (int x = 0; x < tableroDeCeldas[y].length; x++) {
                if (tableroDeCeldas[y][x].isCubierta() && tableroDeCeldas[y][x].es_mina()){
                    celdasMostradas++;
                }
                
            }
            
        }
        return celdasMostradas;
    }
    
    /**
     * Metodo que hace que la celda seleccionada muestre su caracteristica o en otras palabras que se descubra o haga visible su contenido 
     * @param coord_x
     * @param coord_y
     */
    public void escoger_celda(int coord_y, int coord_x){
        if (es_valido(coord_y, coord_x)){
            if(primera_eleccion){
                this.generar_minas();
                this.asignar_num_minas_alrededor();
                primera_eleccion = false;
            }
            
            if(tableroDeCeldas[coord_y][coord_x].getValor().equalsIgnoreCase("0")){
                //Condicion si la celda elegida está vacía (sin minas ni números)
                mostrar_cuadros_deshabilitados(coord_y,coord_x);
            }
            else{
                //Condicion si la celda elegida contiene un número o una mina
                tableroDeCeldas[coord_y][coord_x].mostrar();
                
            }
            //En ambas condiciones si la celda estaba marcada con una bandera sumo uno al numero de minas restantes
            if( tableroDeCeldas[coord_y][coord_x].isBandera()){
                this.minas_restantes++;
            }
       
        }
   
    }
    
    /**
     * Metodo que marca todas las minas que no estén marcadas. Así, cuando el usuario gana las puede ver en el tablero.
     */
    public void marcar_todas_las_minas() {

	for(int i = 0; i < tableroDeCeldas.length; i++){
            for(int j = 0; j < tableroDeCeldas[i].length; j++){
			if( tableroDeCeldas[i][j].es_mina()){
                            tableroDeCeldas[i][j].marcar();
                        }
            }
        }
	this.minas_restantes = 0;
    }
 
    
    
    public boolean no_faltan_celdas() {
     //Calcula el número de cuadrados que están ocultos y no son minas. Devuelve true si no queda ninguno.
	return this.celdasMostradas() == this.celdas_sin_minas;
        
    
    }
    
    public Celda celda(int coord_y, int coord_x){
            try{
        
                if(!this.es_valido(coord_y, coord_x)){
                    
                }
            }catch(Exception e){
                System.err.println("coordenadas no existen en el tablero");
            }
            return this.tableroDeCeldas[coord_y][coord_x];
        
        
    }
}
