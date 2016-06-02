package datos;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Vector;

import gestionyutilidades.Utilidades;


/*
 * Restricciones:
 * 		Nada
 * Metodos aniadidos:
 ********************
 *		String getPrestigio()
 *		String cuentatoCadena()
 * 		void addCuenta(CuentaImp c)
 * 		void deleteCuenta(long numCuenta)
 *
 * Metodos heredados:
 ********************
 * 		public String toString()
 * 		public int compareTo(ClienteImp c)
 * 		public ClienteImp clone()
 * 		public boolean equals(Object o)
 * 		public int hashCode()
 * 
 * 
 * 
 * */

public class ClienteImp extends PersonaImp implements Cliente,Cloneable,Serializable{
	/*-----------------------*/
	/*Atributos b�sicos*/
	private long idCliente;
	private Vector<CuentaImp> cuentas;
	private String observaciones;
	private String contraseña;

	
	/*Atributos Compartidos*/
	private static final long serialVersionUID = 1183469131124915878L;
	public static long contadorclientes=0;
	/*----------------------*/
	
	/*Constructores ordinarios*/
	public ClienteImp(){
		super();
		Utilidades u=new Utilidades();
		/*Estas 4 lineas son para obtener el idCliente*/
		
		if(contadorclientes!=0){idCliente=contadorclientes+1;}
		else{idCliente=u.cogerUltimaId("idclientes.dat")+1;}
		contadorclientes=idCliente;
		u.escribirUltimaId(idCliente,"idclientes.dat");
		
		/*-------------------------------------------*/
		this.cuentas=new Vector<CuentaImp>(0,1);
		this.observaciones=null;
		this.contraseña=null;
	}
	
	public ClienteImp(String nombre,String apellido,GregorianCalendar fnacimiento,String dni,char genero){
		super(nombre,apellido,fnacimiento,dni,genero);
		Utilidades u=new Utilidades();
		/*Estas 4 lineas son para obtener el idCliente*/
		if(contadorclientes!=0){idCliente=contadorclientes+1;}
		else{idCliente=u.cogerUltimaId("idclientes.dat")+1;}
		contadorclientes=idCliente;
		u.escribirUltimaId(idCliente,"idclientes.dat");
		/*-------------------------------------------*/
		this.cuentas=new Vector<CuentaImp>(0,1);
		this.observaciones=null;
		this.contraseña=null;
	}
	
	public ClienteImp(String nombre,String apellido,GregorianCalendar fnacimiento,String dni,char genero,String observaciones,String contraseña){
		super(nombre,apellido,fnacimiento,dni,genero);
		Utilidades u=new Utilidades();
		/*Estas 4 lineas son para obtener el idCliente*/
		if(contadorclientes!=0){
			idCliente=contadorclientes+1;
			}
		else{
			idCliente=u.cogerUltimaId("idclientes.dat")+1;
			}
		contadorclientes=idCliente;
		u.escribirUltimaId(idCliente,"idclientes.dat");
		/*-------------------------------------------*/
		this.cuentas=new Vector<CuentaImp>(0,1);
		this.observaciones=observaciones;
		this.contraseña=contraseña;
	}
	
	/*----------------*/

	
	@Override
	public long getIdCliente(){
		return this.idCliente;
	}
	
	
	@Override
	public String getObservaciones(){
		return this.observaciones;
	}
	
	public Vector<CuentaImp> getCuentas(){
		return this.cuentas;
	}
	@Override
	public String getContraseña(){
		return this.contraseña;
	}

	/*METODOS CONSULTORES REDEFINIDOS*/
	@Override
	public String getNombre(){
		return (super.getNombre());
	}
	
	@Override
	public String getApellido(){
		return(super.getApellido());
	}
	@Override
	public String getDni(){
		return(super.getDni());
	}
	@Override
	public GregorianCalendar getFNacimiento(){
		return (super.getFNacimiento());
	}
	@Override
	public char getGenero(){
		return(super.getGenero());
	}
	/**---------------
	 * Modificadores-
	 * --------------
	 ***/
	

	@Override
	public void setObservaciones(String observaciones){
		this.observaciones=observaciones;
	}
	@Override
	public void setContraseña(String contraseña){
		this.contraseña=contraseña;
	}
	public void setCuentas(Vector<CuentaImp> cuentas){
		this.cuentas=cuentas;
	}
	
	/*METODOS MODIFICADORES REDEFINIDOS*/
	@Override
	public void setNombre(String nombre){
		super.setNombre(nombre);
	}
	@Override
	public void setApellido(String apellido){
		super.setApellido(apellido);
	}
	@Override
	public void setDni(String dni)throws PersonaNoValida{
		super.setDni(dni);
	}
	@Override
	public void setGenero(char genero) throws PersonaNoValida{
		super.setGenero(genero);
	}
	@Override
	public void setFNacimiento(GregorianCalendar fNacimiento) throws PersonaNoValida{
		super.setFNacimiento(fNacimiento);
	}
	/*Metodos a�adidos*/

	
	//addCuenta
	/*
	 * Breve comentario:
	 * 	-Este metodo añadira una CuentaImp al vector cuentas
	 * Cabecera:
	 * 	void addCuenta(CuentaImp c)
	 * Precondiciones:
	 * 	Nada
	 * Entradas:
	 * 	Una CuentaImp
	 * Salidas:
	 * 	Nada
	 * Postcondiciones:	
	 * 	Nada
	 * 
	 * */
	public void addCuenta(CuentaImp c){
		this.cuentas.add(c);
	}
	
	//deleteCuenta
	/*
	 * Breve comentario:
	 * 	-Este metodo eliminara una CuentaImp del vector cuentas
	 * Cabecera:
	 * 	void deleteCuenta(long numCuenta)
	 * Precondiciones:
	 * 	Nada, si el numCuenta no existe no eliminara nada
	 * Entradas:
	 * 	Un long id
	 * Salidas:
	 * 	Nada
	 * Postcondiciones:	
	 * 	Nada
	 * 
	 * */
	public void deleteCuenta(long numCuenta){
		for(int i=0;i<this.cuentas.size();i++){	
			if(this.cuentas.elementAt(i).getNumCuenta()==numCuenta){
				this.cuentas.removeElementAt(i);
			}
		}
	}

	
	
	/*getPrestigio
	 * 
	 * Breve comentario:
	 * 		-Este metodo hará la media de todos los saldos de sus cuentas
	 * 		y retornara un prestigio segun la media:
	 * 				-Media mayor 20.000€ -> Buena
	 * 				-Media entre 0€ y 19.999€ -> Normal
	 * 				-Media menor a 0€ -> Mala
	 * 				-Si no tiene Cuentas -> NULL
	 * 	Cabecera: 
	 * 		String getPrestigio()
	 * 	Precondiciones:
	 * 		Nada 	
	 * 	Entradas:
	 * 		Nada
	 * 	Salidas:
	 * 		Un  Prestigio (String)
	 * 	Postcondiciones:
	 * 		El prestigio retornara asociado al nombre -> Funcion
	 * */
	
	public String getPrestigio(){
		String prestigio=null;
		double totalCuenta=0;
			for(int i=0;i<this.cuentas.size();i++){
				totalCuenta=totalCuenta+this.cuentas.elementAt(i).getSaldo();
			}
			double media=totalCuenta/this.cuentas.size();
			
			
			if(media<0.0){
				prestigio="Mala";
			}
			else if(media>=20000.0){
				prestigio="Buena";
			}
			else if(media>0.0 && media<20000.0){
				prestigio="Normal";
			}
		
		return prestigio;
	}

	
	/*ClientetoCadena
	 * Breve comentario: 
	 * 		el método devuelve un String con los valores de todos los atributos del cliente.
	 * Cabecera:
	 * 		String clientetoCadena()
	 * precondiciones:
	 * 		 nada
	 * entrada:
	 * 		 nada
	 * salida:
	 * 		 un String
	 * postcondiciones:
	 * 		 el String retornara asociado  al nombre -> Funcion
	 */
	public String clientetoCadena(){
		return getIdCliente()+", "+getNombre()+", "+getApellido();
	}

	/*-------FIN METODOS AÑADIDOS---------*/
	
	
	/*--------METODOS HEREDADOS-----------*/

	@Override
	public String toString() {
		String cuenta="";
		for(int i=0;i<cuentas.size();i++){
			cuenta=cuenta.concat(cuentas.elementAt(i).toString())+"\n";
		}
		return "Nombre cliente: "+getNombre()+", IdCliente: " + idCliente + "\ncuentas:" + cuenta + "\n observaciones: " + observaciones + "\n\n--------------------------------";
	}
	@Override
	public int hashCode(){
		return (int)(idCliente+1/2*Integer.parseInt(contraseña));
	}
	
	/*
	 * CompareTo
	 * 	Criterio de comparacion: 
	 * 		El Cliente es comparado por su id de cliente, retornará 1 si es mayor,
	 * 															   -1 si es menor,
	 * 																0 si son iguales.
	 * */
	public int compareTo(ClienteImp c) {
		int comparado=0;
		if(this.idCliente>c.getIdCliente()){
			comparado=1;
		}
		else if (this.idCliente<c.getIdCliente()){
			comparado=-1;
		}
		return comparado;
	}
	
	public ClienteImp clone(){
		ClienteImp copia=null;
		copia = (ClienteImp) clone();
		return copia;
	}
	
	/* equals
	 * Criterio de igualdad: Dos clientes son iguales si su idCliente son iguales.
 	 * */
	@Override
	public boolean equals(Object o){
		boolean igual=false;
		if(o!=null && o  instanceof ClienteImp) {
			ClienteImp c = (ClienteImp)  o;
				if(c.idCliente == this.idCliente){
					igual = true;
				}
			
		}
			
		
		
		return igual;
	}
	
	
	
/*-------FIN METODOS HEREDADOS---------*/
	
	
}

