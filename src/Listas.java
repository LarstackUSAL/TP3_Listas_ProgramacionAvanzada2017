import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Listas {

	private ArrayList <Integer> intList;
	private ArrayList <Clientes> clientesList = new ArrayList <Clientes> (Main.MAXIMO_OBJETOS);
	
	public Listas() {}
	
	public Listas(int size, ArrayList <Clientes> clientesList) {
		
		super();
		this.intList = new ArrayList <Integer> (size);
		this.clientesList = clientesList;
		
		for(int i = 0; i < size; ++i) {
			
			intList.add(Validador.generarEnteroRandom(100, 999));
			
		}
			
	}
	
	public ArrayList<Integer> getIntList() {
		return intList;
	}

	public void setIntList(ArrayList<Integer> intList) {
		this.intList = intList;
	}

	public ArrayList<Clientes> getClientesList() {
		return clientesList;
	}

	public void setClientesList(ArrayList<Clientes> clientesList) {
		this.clientesList = clientesList;
	}

	public boolean quitarObjeto(Clientes cliente) throws ObjetoInexistenteException {

		if(clientesList.contains(cliente)) 
			return clientesList.remove(cliente);
		
		throw new ObjetoInexistenteException();

	}
	
	public int maximoValor() {
		
		return Collections.max(this.intList, null);
		
	}
	
	public ArrayList <Clientes> ordenDescendente() {
		
		Collections.reverse(this.clientesList);
		
		return this.clientesList;
		
	}
	
	public boolean hayRepetidos() {
		
		for (int i = 0; i < clientesList.size(); ++i) {
			
			Clientes cliente = clientesList.get(i);
			
			int frequencia = Collections.frequency(clientesList, cliente);
			
			if(frequencia > 1)
				return true;
						
		}
		
		return false;
		
	}

	public ArrayList <Integer> busquedaMultiple(int valor) throws ObjetoInexistenteException {
		
		Iterator <Integer> listIterator = this.intList.iterator();
		
		ArrayList <Integer> arrayResultado = new ArrayList <Integer> ();
		
		int i = 0;
		
		while(listIterator.hasNext()) {
			
			i++;
			
			int valorIterado = listIterator.next();
			
			if(valorIterado == valor)
				arrayResultado.add(i);
			
		}
	
		if(arrayResultado.isEmpty())
			throw new ObjetoInexistenteException();
		
		return arrayResultado;
		
	}
	
	public boolean igualValores(ArrayList <Integer> intArray) {
		
		return !Collections.disjoint(intArray, this.intList);
		
	}
	
	public ArrayList<String> getIntArrayStringList(ArrayList<Integer> intList) {
		
		Iterator<Integer> intListIterator = intList.iterator();
		ArrayList<String> intArrayStringList = new ArrayList<String>();
		
		while (intListIterator.hasNext()) {
			
			intArrayStringList.add(String.valueOf(intListIterator.next()));
		}
		
		return intArrayStringList;
	}
	
	public ArrayList<String> getClientesArrayStringList(ArrayList<Clientes> clientesList) {
		
		Iterator<Clientes> clientesListIterator = clientesList.iterator();
		ArrayList<String> clientesArrayStringList = new ArrayList<String>();

		while (clientesListIterator.hasNext()) {
			
			Clientes clienteIt = clientesListIterator.next();
			
			clientesArrayStringList.add("Nro. Documento: " + clienteIt.getNumeroDocumento() + " " +
			"Apellido y Nombre: " + clienteIt.getApellido() + ", " + clienteIt.getNombre() + " " +
			"Fecha Nacimiento: " + Validador.calendarToString(clienteIt.getFechaNacimiento(), "dd/MM/yyyy"));
		}
		
		return clientesArrayStringList;
	}

	public void printClientesArray(ArrayList<Clientes> clientesList, PrintStream archivoSalida, PrintStream pantalla) {
		
		System.setOut(archivoSalida);
		System.out.println();
		System.out.println("Array de clientes: ");
		ArrayList<String> clientesArrayStringList = this.getClientesArrayStringList(clientesList);
		
		for (String cliente : clientesArrayStringList) {
			
			System.out.println(cliente) ;
		}
		
		System.setOut(pantalla);
		System.out.println();
		System.out.println("Array de clientes: ");
		
		for (String cliente : clientesArrayStringList) {
			
			System.out.println(cliente) ;
		}
	}

	public void printIntArray(ArrayList<Integer> intList, PrintStream archivoSalida, PrintStream pantalla) {
		
		System.setOut(archivoSalida);
		System.out.print("Array de enteros: ");
		ArrayList<String> intArrayStringList = this.getIntArrayStringList(intList);
		
		for (String entero : intArrayStringList) {
			
			System.out.print(entero + " ") ;
		}
		
		System.setOut(pantalla);
		System.out.print("Array de enteros: ");
		
		for (String entero : intArrayStringList) {
			
			System.out.print(entero + " ") ;
		}
	}
	
	
}
