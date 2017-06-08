public class ObjetoInexistenteException extends Exception {

	public ObjetoInexistenteException() {

		super();

	}

	@Override
	public void printStackTrace()
	{
		System.out.println("El objeto es inexistente.");
	}

}
