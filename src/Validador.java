import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Validador {

	public static int generarEnteroRandom(int min, int max){

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public static String calendarToString(Calendar fecha, String formatoFecha){

		// "dd/MM/yyyy"
		// "dd-MM-yyyy"
		// "yyyyMMdd"	

		Date fechaDate = fecha.getTime();
		DateFormat formatter = new SimpleDateFormat(formatoFecha);
		return formatter.format(fechaDate);
	}

	public static Calendar stringToCalendar(String fecha, String formatoFecha) {

		// "dd/MM/yyyy"
		// "dd-MM-yyyy"
		// "yyyyMMdd"	

		Calendar calendar = Calendar.getInstance();

		try {

			SimpleDateFormat format = new SimpleDateFormat(formatoFecha);
			Date date;
			date = format.parse(fecha);
			calendar.setTime(date);

		} catch (ParseException e) {

			System.out.println("Se ha verificado un error con el parsing de la fecha.");
		}

		return calendar;		
	}

}
