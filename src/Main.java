import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class Main {

	public static final int MAXIMO_ENTEROS = 5;
	public static final int MAXIMO_OBJETOS = 5;
	public static final int RANDOM_MIN = 100;
	public static final int RANDOM_MAX = 999;
	
	public static void main(String[] args) {

		File archivo = null;
		PrintStream archivoSalida = null;
		PrintStream pantalla = System.out;
		String ruta = "./ARCHIVOS/Log_Ej2.txt";
		Calendar fecha = Calendar.getInstance();
						
		try {
						
			archivo = new File(ruta);
			archivo.createNewFile();
			archivoSalida = new PrintStream(archivo);
			System.out.println(Validador.calendarToString(fecha, "dd/MM/yyyy"));
			System.out.println("Comienzo de proceso.");
			
			System.setOut(archivoSalida);
			System.out.println(Validador.calendarToString(fecha, "dd/MM/yyyy"));
			System.out.println("Comienzo de proceso.");				
				
			//Punto 1 - Constructor alternativo
			
			ArrayList <Clientes> clientesList = new ArrayList <Clientes> (MAXIMO_OBJETOS);
			
			Clientes cliente1 = new Clientes(33514490, "Ricciotti", "Leonardo", Validador.stringToCalendar("19880124", "yyyyMMdd"));
			clientesList.add(cliente1);
			
			Clientes cliente2 = new Clientes(32322749, "Sandobal", "Micaela", Validador.stringToCalendar("19860414", "yyyyMMdd"));
			clientesList.add(cliente2);
			
			Clientes cliente3 = new Clientes(15056331, "Zurita", "Marcos", Validador.stringToCalendar("19650731", "yyyyMMdd"));
			clientesList.add(cliente3);
			
			Clientes cliente4 = new Clientes(28745123, "Perez", "Juan", Validador.stringToCalendar("19981205", "yyyyMMdd"));
			clientesList.add(cliente4);
			
			Clientes cliente5 = new Clientes(24952384, "Zurita", "Roberto", Validador.stringToCalendar("19750819", "yyyyMMdd"));
			clientesList.add(cliente5);
			
			Listas list = new Listas(MAXIMO_ENTEROS, clientesList);
			
			System.out.println();
			System.out.println("Punto 1 - Metodo constructor alternativo.");
			
			list.printIntArray(list.getIntList(), archivoSalida, pantalla);
			list.printClientesArray(list.getClientesList(), archivoSalida, pantalla);

			//Punto 2 - Quitar Objeto
			
			Clientes cliente6 = new Clientes(28745123, "Perez", "Juan", Validador.stringToCalendar("19981205", "yyyyMMdd")); 
			
			System.setOut(archivoSalida);
			System.out.println();
			System.out.println("Punto 2 - Metodo quitar objeto.");
			
			System.setOut(pantalla);
			System.out.println();
			System.out.println("Punto 2 - Metodo quitar objeto.");
			
			
				try {
				
					list.quitarObjeto(cliente6);
					
					System.setOut(archivoSalida);
					System.out.println("Se quitò el cliente " + cliente6.getNumeroDocumento());
					
					System.setOut(pantalla);
					System.out.println("Se quitò el cliente " + cliente6.getNumeroDocumento());
					
					System.out.println();
					list.printClientesArray(list.getClientesList(), archivoSalida, pantalla);
					
				} catch (ObjetoInexistenteException e) {
					
					e.printStackTrace();
				}
			
			//Punto 3 - Maximo Valor
			
			System.setOut(archivoSalida);
			System.out.println();
			System.out.println("Punto 3 - Metodo maximo valor.");
			System.out.print("Valor maximo: ");
			System.out.println(list.maximoValor());
			
			System.setOut(pantalla);
			System.out.println();
			System.out.println("Punto 3 - Metodo maximo valor finalizado.");
			System.out.print("Valor maximo: ");
			System.out.println(list.maximoValor());
			
			//Punto 4 - Orden Descendente por Apellido
			
			System.setOut(archivoSalida);
			System.out.println();
			System.out.println("Punto 4 - Metodo orden descendente por apellido.");
			System.out.print("Listado clientes en orden descendente: ");
			list.printClientesArray(list.ordenDescendente(), archivoSalida, pantalla);
			
			//Punto 5 - Hay repetidos
			
			System.setOut(archivoSalida);
			System.out.println();
			System.out.println("Punto 5 - Metodo hay repetidos.");
			System.out.println(list.hayRepetidos()? "Hay clientes con el mismo apellido" : 
				"No hay clientes con el mismo apellido");
			
			System.setOut(pantalla);
			System.out.println();
			System.out.println("Punto 5 - Metodo hay repetidos.");
			System.out.println(list.hayRepetidos()? "Hay clientes con el mismo apellido" : 
					"No hay clientes con el mismo apellido");
			
			//Punto 6 - B�squeda M�ltiple
								
			System.setOut(archivoSalida);
			System.out.println();
			System.out.println("Punto 6 - Metodo busqueda multiple.");
			
			System.setOut(pantalla);
			System.out.println();
			System.out.println("Punto 6 - Metodo busqueda multiple.");
			
			try {
			
				list.printIntArray(list.busquedaMultiple(5), archivoSalida, pantalla);				

			} catch (ObjetoInexistenteException e) {

				System.setOut(archivoSalida);
				e.printStackTrace();
				System.setOut(pantalla);
				e.printStackTrace();
			}
				
			//Punto 7 - Igual Valores
			
			Listas list2 = new Listas(MAXIMO_ENTEROS, clientesList);
			
			System.setOut(archivoSalida);
			System.out.println();
			System.out.println("Punto 7 - Metodo igual valores.");
			System.setOut(pantalla);
			System.out.println();
			System.out.println("Punto 7 - Metodo igual valores.");

			list.printIntArray(list.getIntList(), archivoSalida, pantalla);

			System.setOut(archivoSalida);
			System.out.println("\n" + (list.igualValores(list2.getIntList())? 
					"Hay valores iguales entre los dos array de enteros" : "No hay valores iguales entre los dos array de enteros"));
			System.setOut(pantalla);
			System.out.println("\n" + (list.igualValores(list2.getIntList())? 
					"Hay valores iguales entre los dos array de enteros" : "No hay valores iguales entre los dos array de enteros"));
			
			System.out.println();
			System.out.println("Fin de proceso.");
			System.out.println("El archivo de log se guardara en " + ruta);
			
		}
		catch(IOException ex1) {
						
			System.err.println("Ha ocurrido un error con el archivo.");
			
		}
		finally {
			
			if(archivoSalida != null)  
				archivoSalida.close(); 
			
			System.setOut(pantalla);
			System.out.println();
			System.out.println("Hasta luego.");
			System.exit(0);
			
		}
		
	}

}
