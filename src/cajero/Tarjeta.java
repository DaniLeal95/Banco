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
	char getTipo();

	void setTipo(char tipo) throws TarjetaExcepcion;

	int getNumtarjeta();
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
	  
	int CogerUltimaID();
	/*
	 * Estudio de la interfaz de escribirUltimaID
	 * 
	 * Comentario: 
	 * 	El metodo sobreescribirá la Id escrita en el fichero
	 * Cabecera: 
	 * 	long CogerUltimaID()
	 * Precondiciones:Nada
	 * 	
	 * Entradas:Nada
	 * Salidas:un long (ID)
	 * Postcondiciones:
	 * 	El long retornara asociado al nombre -> Funcion
	 * */

	void escribirUltimaID(int id);

}