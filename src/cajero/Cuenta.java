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
public interface Cuenta{
	//Consultores
	public long getNumCuenta();
	public double getSaldo();
	//modificadores
	public void setSaldo(double saldo);
	
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
	  
	public long CogerUltimaID();
	
	
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
	public void escribirUltimaID(long id);
	
}
