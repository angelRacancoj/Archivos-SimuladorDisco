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
            fichero.write("Date: " + constants.actualDateTime() + "\n");
            fichero.close();
        }
    }

    /**
     * This method must be use only for "Asignacion Contigua" this method
     * include the way is saved the information
     *
     * @param dateTime
     * @param idPartition
     * @param idOperacion
     * @param ajuste
     * @param nameOfFile
     * @throws IOException
     */
    public void addOperationInfo(String dateTime, String idPartition, String idOperacion, String ajuste, String nameOfFile) throws IOException {
        addToLog(dateTime + "\t" + idPartition + "\t" + idOperacion + "\t" + ajuste + "\t" + nameOfFile);
    }

    /**
     * This method must be use for "Asignacion Enlazada e Indexada" just for
     * this methods
     *
     * @param dateTime
     * @param idParticion
     * @param idOperacion
     * @param nameOfFile
     * @throws IOException
     */
    public void addOperationInfo(String dateTime, String idParticion, String idOperacion, String nameOfFile) throws IOException {
        addToLog(dateTime + "\t" + idParticion + "\t" + idOperacion + "\t" + nameOfFile);
    }

    /**
     * include the partition information to include at the log
     *
     * the size need to be in Mb
     *
     * @param dateTime
     * @param idPartition
     * @param size
     * @throws IOException
     */
    public void addPatitionInfo(String dateTime, String idPartition, int size) throws IOException {
        addToLog(dateTime + "\t" + idPartition + "\t" + size);
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
