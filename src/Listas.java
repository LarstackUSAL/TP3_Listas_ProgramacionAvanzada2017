import java.util.ArrayList;
import java.util.Iterator;


public class Listas {

	private ArrayList <Integer> intList;
	private ArrayList <Clientes> clientesList = new ArrayList <Clientes> (Main.MAXIMO_OBJETOS);
	//separar por ;
	//orden por edad
	//igual por nombre
	
	public Listas() {}
	
	public Listas(int size, ArrayList <Clientes> clientesList) {
		
		super();
		this.intList = new ArrayList <Integer> (size);
		this.clientesList = clientesList;
		
		for(int i = 0; i < intList.size(); ++i) {
			
			intList.add(Validador.generarEnteroRandom(Main.RANDOM_MIN, Main.MAXIMO_ENTEROS));
			
		}
		
		
	}


	
//	intList.add(5);
//
//	Listas prueba = new Listas();
//
//	try {
//		prueba.quitarObjeto(5);
//		
//	} catch (MicaException e) {
//
//		e.printStackTrace();
//	}

	public void quitarObjeto(Integer element) throws MicaException {

		if(intList.remove(element)) {
	
			throw new Exception();
	
		}

	}

}