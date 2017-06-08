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
		
		for(int i = 0; i < intList.size(); ++i) {
			
			intList.add(Validador.generarEnteroRandom(Main.RANDOM_MIN, Main.MAXIMO_ENTEROS));
			
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
		else 
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
			
			if(frequencia > 0)
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
	
	public static void mostrarIntArray(ArrayList <Integer> intArray) {
		
		for (Integer i : intArray) 
			System.out.println(i + " ");
		
	}
	
	public static void mostrarClientesArray(ArrayList <Clientes> clienteArray) {
		
		for (Clientes i : clienteArray) {
			
			System.out.print("Nro. Documento: " + i.getNumeroDocumento() + " ");
			System.out.print("Apellido y Nombre: " + i.getApellido() + ", " + i.getNombre() + " ");
			System.out.print("Fecha Nacimiento: " + Validador.calendarToString(i.getFechaNacimiento(), "dd/MM/yyyy") + " ");
			System.out.println();
		
		}
				
	}
	
}
