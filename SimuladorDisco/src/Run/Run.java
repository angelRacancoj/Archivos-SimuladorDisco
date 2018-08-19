package Run;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);
    }

}
