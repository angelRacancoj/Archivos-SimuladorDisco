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
