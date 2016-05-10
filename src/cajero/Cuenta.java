package cajero;


/*
 * Propiedades:
 * 
 * 	Numero De Cuenta- int , consultable
 * 	Saldo- int, consultable y modificable
 * 	
 * 	Compartida
 * 		CONTADOR- long(6 cifras) - consultable y modificable
 * 	
 * 
 * 
 * 
 * */
public interface Cuenta {
	//Consultores
	public int getNumCuenta();
	public long getSaldo();
	//modificadores
	public void setSaldo(long saldo);
	
	 /*
	   * Estudio de la interfaz de CogerUltimaID
	   * 
	   * Comentario: 
	   * 	El metodo recogera La ultima ID,que est� registrado y retornar� la id
	   * Cabecera: 
	   * 	long CogerUltimaID()
	   * Precondiciones:
	   * 	
	   * Entradas:
	   * Salidas:
	   * Poscondiciones:
	   * */
	  
	public int CogerUltimaID();
	
	
	  /*
	   * Estudio de la interfaz de escribirUltimaID
	   * 
	   * Comentario: 
	   * 	El metodo sobreescribir� la Id escrita en el fichero
	   * Cabecera: 
	   * 	void escribirUltimaID()
	   * 
	   * Precondiciones:Nada
	   * Entradas:un long(id)
	   * Salidas:nada
	   * Postcondiciones:nada
	   * 
	   * */	
	public void escribirUltimaID(int id);
	
}
