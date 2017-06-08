import java.util.Calendar;

public class Clientes implements Comparable <Clientes> {

	private int numeroDocumento;
	private String apellido;
	private String nombre;
	private Calendar fechaNacimiento;
	
	public Clientes() {}
	
	public Clientes(int numeroDocumento, String nombre, String apellido, Calendar fechaNacimiento) {
		
		super();
		this.setNumeroDocumento(numeroDocumento);
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	@Override
	public boolean equals(Object cliente) {
	
		return this.numeroDocumento == (int)((Clientes) cliente).getNumeroDocumento();				
				
	}

	@Override
	public int compareTo(Clientes cliente) {

		return this.apellido.compareTo(cliente.getApellido());
		
	}
	
}
