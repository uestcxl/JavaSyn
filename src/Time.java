import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xl on 15/7/11.
 */
public class Time {

    public static String getCurrentTime(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss" );
        return simpleDateFormat.format( date );
    }
}
