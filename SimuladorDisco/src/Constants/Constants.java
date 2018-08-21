/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constants;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
    
    public static final int BLOCK_PER_LINE_REPORT = 5;
    private final String DateTimeFormat = "dd-MM-yyyy HH:mm:ss";

    public final int PARTICION_INDEXADA = 3;
    public final int PARTICION_CONTIGUA = 1;
    public final int PARTICION_ENLAZADA = 2;

    public final String LOG_PATH = "info.log";

    public final String ID_INDEXADA = "PI";
    public final String ID_CONTIGUA = "PC";
    public final String ID_ENLAZADA = "PE";

    public final String OP_CREAR = "CREATE";
    public final String OP_MODIFICAR = "MODIFY";
    public final String OP_ELIMINAR = "ELIMINATE";

    /**
     * Use Calendar to get the actual date and time at the machine
     *
     * @return system date-time
     */
    public String actualDateTime() {
        return (new SimpleDateFormat(DateTimeFormat).format(Calendar.getInstance().getTime()));
    }

}
