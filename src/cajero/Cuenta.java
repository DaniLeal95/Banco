package cajero;


/*
 * Propiedades:
 * 
 * 	Numero De Cuenta- int , consultable
 * 	Titular - String , consultable y modificable
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
	int getNumCuenta();
	
	 /*
	   * Estudio de la interfaz de CogerUltimaID
	   * 
	   * Comentario: 
	   * 	El metodo recogera La ultima ID,que esté registrado y retornará la id
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
	   * 	El metodo sobreescribirá la Id escrita en el fichero
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
