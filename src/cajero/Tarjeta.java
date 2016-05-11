package cajero;

public interface Tarjeta {

	/*
	 * Estudio
	 * 	Propiedades
	 * 		Basicas:
	 * 			-char tipo , consultable y modificable
	 * 			-int numtarjeta, consultable
	 * 		Derivadas:
	 * 			-int contador
	 * */
	//consultores y modificadores
	public char getTipo();

	public void setTipo(char tipo) throws TarjetaExcepcion;

	public long getNumtarjeta();
	  /*
	   * Estudio de la interfaz de CogerUltimaID
	   * 
	   * Comentario: 
	   * 	El metodo recogera la Id escrita en ese fichero(long) y la devolvera asociada al nombre
	   * Cabecera: 
	   * 	long CogerUltimaID()
	   * Precondiciones:Nada
	   * 	
	   * Entradas:Nada
	   * Salidas:un long (ID)
	   * Postcondiciones:
	   * 	El long retornara asociado al nombre -> Funcion
	   * */
	  
	long CogerUltimaID();
	/*
	 * Estudio de la interfaz de escribirUltimaID
	 * 
	 * Comentario: 
	 * 	El metodo sobreescribir� la Id escrita en el fichero
	 * Cabecera: 
	 * 	long CogerUltimaID()
	 * Precondiciones:Nada
	 * 	
	 * Entradas:Nada
	 * Salidas:un long (ID)
	 * Postcondiciones:
	 * 	El long retornara asociado al nombre -> Funcion
	 * */

	void escribirUltimaID(long id);

}