import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;

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
			archivoSalida = new PrintStream(archivo);
			System.out.println(Validador.calendarToString(fecha, "dd/MM/yyyy"));
			System.out.println("Comienzo de proceso.");
			
			System.setOut(archivoSalida);
			System.out.println(Validador.calendarToString(fecha, "dd/MM/yyyy"));
			System.out.println("Comienzo de proceso.");
			
						
			if (!archivo.exists())
				archivo.createNewFile();
				
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
			
			System.setOut(archivoSalida);
			System.out.println();
			System.out.println("Punto 1 - Metodo constructor alternativo.");
			System.out.println("El resultado es: ");
			System.out.print("Array de enteros generado: ");
			Listas.mostrarIntArray(list.getIntList());
			System.out.println();
			System.out.print("Array de clientes generado: ");
			Listas.mostrarClientesArray(list.getClientesList());
			
			System.setOut(pantalla);
			System.out.println();
			System.out.println("Punto 1 - Metodo constructor alternativo finalizado.");
			System.out.println("El resultado es: ");
			System.out.println("El resultado es: ");
			System.out.print("Array de enteros generado: ");
			Listas.mostrarIntArray(list.getIntList());
			System.out.println();
			System.out.print("Array de clientes generado: ");
			Listas.mostrarClientesArray(list.getClientesList());
			
			//Punto 2 - Quitar Objeto
			
			Clientes cliente6 = new Clientes(28745123, "Perez", "Juan", Validador.stringToCalendar("19981205", "yyyyMMdd")); 
			
			System.setOut(archivoSalida);
			System.out.println();
			System.out.println("Punto 2 - Metodo quitar objeto.");
			System.out.println("El resultado es: ");
			list.quitarObjeto(cliente6);
//			System.out.print("Objeto eliminado: ")
//			if(list.quitarObjeto(cliente6)) {
//				
//				System.out.print("Nro. Documento: " + cliente6.getNumeroDocumento() + " ");
//				System.out.print("Apellido y Nombre: " + cliente6.getApellido() + ", " + cliente6.getNombre() + " ");
//				System.out.print("Fecha Nacimiento: " + Validador.calendarToString(cliente6.getFechaNacimiento(), "dd/MM/yyyy") + " ");
//				System.out.println();
//				
//			}
//			else
//				throw new ObjetoInexistenteException();
//				
//			System.setOut(pantalla);
//			System.out.println();
//			System.out.println("Punto 2 - Metodo quitar objeto finalizado.");
//			System.out.println("El resultado es: ");
//			System.out.print("Objeto eliminado: ")
//			if(list.quitarObjeto(cliente6)) {
//				
//				System.out.print("Nro. Documento: " + cliente6.getNumeroDocumento() + " ");
//				System.out.print("Apellido y Nombre: " + cliente6.getApellido() + ", " + cliente6.getNombre() + " ");
//				System.out.print("Fecha Nacimiento: " + Validador.calendarToString(cliente6.getFechaNacimiento(), "dd/MM/yyyy") + " ");
//				System.out.println();
//				
//			}
//			else
//				throw new ObjetoInexistenteException();
			
			//Punto 3 - Maximo Valor
			
			System.setOut(archivoSalida);
			System.out.println();
			System.out.println("Punto 3 - Metodo maximo valor.");
			System.out.println("El resultado es: ");
			System.out.print("Valor maximo: ");
			System.out.println(list.maximoValor());
			
			System.setOut(pantalla);
			System.out.println();
			System.out.println("Punto 3 - Metodo maximo valor finalizado.");
			System.out.println("El resultado es: ");
			System.out.print("Valor maximo: ");
			System.out.println(list.maximoValor());
			
			//Punto 4 - Orden Descendente por Apellido
			
			System.setOut(archivoSalida);
			System.out.println();
			System.out.println("Punto 4 - Metodo orden descendente por apellido.");
			System.out.println("El resultado es: ");
			System.out.print("Listado clientes en orden descendente: ");
			Listas.mostrarClientesArray(list.ordenDescendente());
			
			System.setOut(pantalla);
			System.out.println();
			System.out.println("Punto 4 - Metodo orden descendente por apellido finalizado.");
			System.out.println("El resultado es: ");
			System.out.print("Listado clientes en orden descendente: ");
			Listas.mostrarClientesArray(list.ordenDescendente());
			
			//Punto 5 - Hay repetidos
			
			System.setOut(archivoSalida);
			System.out.println();
			System.out.println("Punto 5 - Metodo hay repetidos.");
			System.out.println("El resultado es: " + (list.hayRepetidos()? "Hay clientes con el mismo apellido" : 
				"No hay clientes con el mismo apellido"));
			
			System.setOut(pantalla);
			System.out.println();
			System.out.println("Punto 5 - Metodo hay repetidos finalizado.");
			System.out.println("El resultado es: " + (list.hayRepetidos()? "Hay clientes con el mismo apellido" : 
					"No hay clientes con el mismo apellido"));
			
			//Punto 6 - Búsqueda Múltiple
								
			System.setOut(archivoSalida);
			System.out.println();
			System.out.println("Punto 6 - Metodo busqueda multiple.");
			System.out.println("El resultado es: ");
//			list.busquedaMultiple(5);
//			
//			System.setOut(pantalla);
//			System.out.println();
//			System.out.println("Punto 6 - Metodo busqueda multiple finalizado.");
//			System.out.println("El resultado es: ");
				
			//Punto 7 - Igual Valores
			
			Listas list2 = new Listas(MAXIMO_ENTEROS, clientesList);
			
			System.setOut(archivoSalida);
			System.out.println();
			System.out.println("Punto 7 - Metodo igual valores.");
			System.out.print("Array de enteros generado: ");
			Listas.mostrarIntArray(list.getIntList());
			System.out.println("El resultado es: " + (list.igualValores(list2.getIntList())? 
					"Hay valores iguales entre los dos array de enteros" : "No hay valores iguales entre los dos array de enteros"));
			
			System.setOut(pantalla);
			System.out.println();
			System.out.println("Punto 7 - Metodo igual valores finalizado.");
			System.out.print("Array de enteros generado: ");
			Listas.mostrarIntArray(list.getIntList());
			System.out.println("El resultado es: " + (list.igualValores(list2.getIntList())? 
					"Hay valores iguales entre los dos array de enteros" : "No hay valores iguales entre los dos array de enteros"));
			
			System.out.println();
			System.out.println("Fin de proceso.");
			System.out.println("El archivo de log se guardara en " + ruta);
			
		}
		catch (ObjetoInexistenteException e) {
			
			e.printStackTrace();
			
		}
		catch(IOException ex1) {
						
			System.err.println("El archivo " + ruta + " no existe.");
			
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
