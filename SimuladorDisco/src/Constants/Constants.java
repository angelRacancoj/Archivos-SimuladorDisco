/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constants;

/**
 *
 * @author angel
 */
public class Constants {

    //Constantes utilizadas para el estado de un bloque indexado
    public static final int FREE = 0;
    public static final int OCCUPIED = 1;
    public static final int INDEX = 2;
    public static final int DATA = 3;
    
    //Punteros que almacenara el un bloque indice (Asignacion indexada)
    public static final int POINTERS_PER_BLOCK = 10;
}
