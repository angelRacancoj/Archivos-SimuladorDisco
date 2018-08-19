/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Constants.Constants;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author angel
 */
public class log {

    Constants constants = new Constants();

    public void createLog() throws IOException {
        FileWriter fichero = null;
        File file = new File(constants.LOG_PATH);

        if (file.exists()) {
            System.out.println("Ya existe el LOG");
        } else {
            fichero = new FileWriter(file);
            fichero.write("Date: " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
            fichero.close();
        }
    }

    public void addToLog() {

    }

}
