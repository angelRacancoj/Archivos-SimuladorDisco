package Run;

import data.logSD;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            logSD log = new logSD();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);

    }

}
