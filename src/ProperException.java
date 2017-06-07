
public class ProperException {

	
	
}

/*		
//Excepciones propias

public class DenominadorCeroExcepcion extends Exception {
	private int n;
	
	public DenominadorCeroExcep () {}
	public DenominadorCeroExcep (String s) {
		super(s);
	}
	
	public void setNumerator(int _n) { 
		n = _n;
	}
	
}
*/

/*	
//Excepciones con comprobación

public int invocadorA() {
	try { 
		hazTrabajo();
	} 
	
	catch (Exception e) {
		System.out.println("Error");
	}
} 

public int invocadorB() throws Exception {
	hazTrabajo();
} 

public void hazTrabajo() throws Exception {
	throw new Exception();
}
*/