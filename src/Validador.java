import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Validador {

	public static boolean hayEspacioDisponible(Object[] arrayAnalizado){
		int indiceNull = 0;
		while(indiceNull<arrayAnalizado.length){
			if(arrayAnalizado[indiceNull]==null){
				return true;
			}
			else{
				indiceNull++;
			}
		}
		return false;
	}

	public static String insertString(String mensaje, Integer length){

		Scanner s = new Scanner(System.in);
		boolean datosOK = false;
		String stringValidada = "";

		do {

			datosOK = true;
			System.out.println();
			System.out.println(mensaje);

			String mensajeError = "VALOR INGRESADO NO VALIDO.";
			if(s.hasNextLine()) {

				stringValidada = s.nextLine();

				if(stringValidada.isEmpty())
					datosOK = false;				
				else if(length != null && stringValidada.length()>length){

					datosOK = false;
					mensajeError = "La longitud MAX es " + length;
				}			

			}

			if(!datosOK) {

				System.out.println(mensajeError);
			}

		} while(!datosOK);

		return stringValidada;
	}

	public static Calendar insertFecha(String mensaje) {

		Scanner s = new Scanner(System.in);
		boolean datosOK = false;						
		Calendar fechaValidada = Calendar.getInstance();
		int dia = 0;
		int mes = 0;
		int anio = 0;

		System.out.println(mensaje);
		do {

			System.out.println("Ingresar dia: ");

			if(s.hasNextInt()) {

				dia = s.nextInt();

				if(dia > 0 && dia <= 31) {

					datosOK = true;

				} else {

					datosOK = false;
					s.nextLine();

				}

			} else {

				datosOK = false;
				s.nextLine();

			}

			if(!datosOK) 
				System.out.println("DIA INGRESADO INVALIDO.");

		} while(!datosOK);

		s.nextLine();

		do {

			System.out.println("Ingresar mes: ");

			if(s.hasNextInt()) {

				mes = s.nextInt();
				if(mes > 0 && mes <= 12) {

					mes--;
					datosOK = true;

				} else {

					datosOK = false;
					s.nextLine();

				}

			} else {

				datosOK = false;
				s.nextLine();

			}

			if(!datosOK) 
				System.out.println("MES INGRESADO INVALIDO.");

		} while(!datosOK);

		s.nextLine();

		do {

			System.out.println("Ingresar a�o (AAAA): ");

			if(s.hasNextInt()) {

				anio = s.nextInt();
				if(anio >= 1000 && anio <= 9999) {

					datosOK = true;

				} else {

					datosOK = false;
					s.nextLine();

				}

			} else {

				datosOK = false;
				s.nextLine();

			}

			if(!datosOK) 
				System.out.println("A�O INGRESADO INVALIDO.");

		} while(!datosOK);

		fechaValidada.set(anio, mes, dia);
		s.nextLine();

		return fechaValidada;
	}

	public static int insertInt(String mensaje, Integer limiteInferior, Integer limiteSuperior, boolean menorCeroTambien) {

		Scanner s = new Scanner(System.in);
		boolean intOk = false;
		int intValidado = 0;

		do {
			intOk = true;
			System.out.println(mensaje);

			if(s.hasNextInt()) {

				intValidado = s.nextInt();

				if((intValidado>=0) || menorCeroTambien) {

					if((limiteInferior != null) && (intValidado >= limiteInferior)){

						if((limiteSuperior != null) && (intValidado <= limiteSuperior)){
							intOk = true;	
						}else if(limiteSuperior == null){
							intOk = true;
						}else{
							intOk = false;
							System.out.println("EL VALOR DEBE SER MENOR O IGUAL A " + limiteSuperior);
						}
					}else if(limiteInferior == null){

						if((limiteSuperior != null) && (intValidado <= limiteSuperior)){
							intOk = true;	
						}else if(limiteSuperior == null){
							intOk = true;
						}else{
							intOk = false;
							System.out.println("EL VALOR DEBE SER MENOR O IGUAL A " + limiteSuperior);
						}
					}else{

						intOk = false;
						System.out.println("EL VALOR DEBE SER MAYOR O IGUAL A " + limiteInferior);
					}

				}else{

					intOk = false;
					s.nextLine();
					System.out.println("DEBE SER MAYOR A CERO.");
				}

			}else{

				System.out.println("VALOR NO VALIDO.");
				intOk = false;
				s.nextLine();
			}
		}while(!intOk);

		return intValidado;
	}

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

	public static String fillString(String s, int longitudFinalString, String filler, boolean izquierda){

		if(s.length() < longitudFinalString){

			int espacios = (longitudFinalString-s.length());

			for (int i = 0; i < espacios; i++) {

				if(izquierda){

					s = filler + s;
				}else{

					s += filler;
				}
			}
		}

		return s;
	}

	public static boolean compararCaracteresIgnoreCase(char a, char b){

		return String.valueOf(a).equalsIgnoreCase(String.valueOf(b));
	}

}
