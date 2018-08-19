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
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author angel
 */
public class logSD {

    Constants constants = new Constants();

    /**
     * When the object is created, automatically the info.log document is verify
     *
     * If the file already exist just print at the console "Already exist
     * info.log" other wise create a new file named "info.log" and add the
     * current date and time automatically
     *
     * @throws IOException
     */
    public logSD() throws IOException {
        FileWriter fichero = null;
        File file = new File(constants.LOG_PATH);

        if (file.exists()) {
            System.out.println("Already exist info.log");
        } else {
            fichero = new FileWriter(file);
            fichero.write("Date: " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime()) + "\n");
            fichero.close();
        }
    }

    public void addPartitionInfo() {

    }

    private void addToLog(String lineToAdd) throws IOException {
        FileWriter fichero = null;
        PrintWriter printer = null;
        fichero = new FileWriter(constants.LOG_PATH, true);
        printer = new PrintWriter(fichero);
        printer.print(lineToAdd + "\n");
        fichero.close();
    }

}
