package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
	
	public static final String DATE_FORMAT_DEFAULT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	
	public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DEFAULT, Locale.US);
        return sdf.format(new Date());
    }
}
