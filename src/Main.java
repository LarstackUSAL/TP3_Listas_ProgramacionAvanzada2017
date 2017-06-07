import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Main {

	public static final int MAXIMO_ENTEROS = 5;
	public static final int MAXIMO_OBJETOS = 5;
	public static final int RANDOM_MIN = 100;
	public static final int RANDOM_MAX = 999;
	
	public static void main(String[] args) {

		File archivo = null;
		PrintStream archivoSalida = null;
		PrintStream pantalla = System.out;
		String ruta = ".//ARCHIVOS//Log_Ej2.txt";
		String mensaje = "";
				
		try {
						
			archivo = new File(ruta);
			archivoSalida = new PrintStream(archivo);
			System.setOut(archivoSalida);
			
			if (!archivo.exists())
				archivo.createNewFile();
				
			//Punto 1 - Constructor alternativo
			ArrayList <Clientes> clientesList = new ArrayList <Clientes> (MAXIMO_OBJETOS);
			
			Clientes cliente = new Clientes(33514490, "Ricciotti", "Leonardo", Validador.stringToCalendar("19880124", "yyyyMMdd"));
			clientesList.add(cliente);
			
			Clientes cliente = new Clientes(32322749, "Sandobal", "Micaela", Validador.stringToCalendar("19860414", "yyyyMMdd"));
			clientesList.add(cliente);
			
			Clientes cliente = new Clientes(15056331, "Zurita", "Marcos", Validador.stringToCalendar("19650731", "yyyyMMdd"));
			clientesList.add(cliente);
			
			Clientes cliente = new Clientes(28745123, "Perez", "Juan", Validador.stringToCalendar("19981205", "yyyyMMdd"));
			clientesList.add(cliente);
			
			Clientes cliente = new Clientes(24952384, "Zurita", "Roberto", Validador.stringToCalendar("19750819", "yyyyMMdd"));
			clientesList.add(cliente);
			
			Listas list = new Listas(MAXIMO_ENTEROS, clientesList);
			
			//Punto 2 - Quitar Objeto
			
			
						
		}
		catch(IOException ex1) {
			
			System.err.println("El archivo " + ruta + " no existe");
			ex1.toString();
			System.err.println(ex1.getMessage());
			ex1.printStackTrace();
			
		}
		finally {
			
			if(archivoSalida != null)  
				archivoSalida.close(); 
			
			mensaje = "Hasta luego. ";
			System.setOut(pantalla);
			System.out.println(mensaje);
			System.exit(0);
			
		}
		
	}

}

/*
//Escritura de archivos

FileWriter archivo = new FileWriter("MiArchivo.txt");	// Si no existe lo crea, si existe lo pisa
														// FileWriter archivo = new FileWriter(“MiArchivo.txt”, true);	//Append de archivo
PrintWriter archivoSalida = new PrintWriter(archivo);
archivoSalida.println("Hola");
for (int i = 0; i < 10; i++)
     archivoSalida.println("Linea " + i);
archivoSalida.close();
*/


/*
public class MuestraContenidoArchivo {

	public static void main(String[] args) throws IOException {	// throws porque todo el manejo de archivos genera excepciones
		Scanner stdin=new Scanner(System.in);
		System.out.println("Ingrese el nombre del archivo: ");
		String nombre=stdin.next();
		File archivo=new File(nombre);
		if archivo.exists() {
			Scanner archivoEntrada=new Scanner(archivo);
			while (archivoEntrada.hasNext()) {	
				String lineaActual = archivoEntrada.nextLine(); 
				System.out.println(lineaActual );
			}
		}
		else
			throw new IOException();	// Si el archivo no existe, podría ponerse: if archivo.createNewFile()	//devuelve false si ya existía


	}

}
*/