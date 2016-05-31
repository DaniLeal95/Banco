package datos;


import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Vector;

import cajero.ExcepcionPersona;
import gestionyutilidades.Utilidades;


/*
 * Restricciones:
 * 		Nada
 * Metodos aniadidos:
 ********************
 *		String getPrestigio()
 *		String cuentatoCadena()
 *
 * Metodos heredados:
 ********************
 * 		public String toString()
 * 		public int compareTo(ClienteImp c)
 * 		public ClienteImp clone()
 * 		public boolean equals(Object o)
 * 
 * 
 * 
 * */

public class ClienteImp extends Persona implements Cliente,Cloneable,Serializable,Comparable<ClienteImp>{
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
	
	/*
	 * Creamos una variable de clase de Utilidades.
	 * */
	/*Constructores*/
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
	
	public ClienteImp(String nombre,String apellido,GregorianCalendar fnacimiento,String dni,char genero) throws ExcepcionPersona{
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
	
	public ClienteImp(String nombre,String apellido,GregorianCalendar fnacimiento,String dni,char genero,String observaciones,String contraseña) throws ExcepcionPersona{
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
	/*METODOS REDEFINIDOS*/
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
	
	/**---------------
	 * Modificadores-
	 * --------------
	 ***/
	
	public void addCuenta(CuentaImp c){
		this.cuentas.add(c);
	}
	
	@Override
	public void setObservaciones(String observaciones){
		this.observaciones=observaciones;
	}
	@Override
	public void setContraseña(String contraseña){
		this.contraseña=contraseña;
	}
	
	
	/*Metodos a�adidos*/

	
	
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
	 *  
	 * 
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
	
	/*
	 * 
	 * */
	@Override
	public ClienteImp clone(){
		ClienteImp copia=null;
		try{
			copia = (ClienteImp) super.clone();
		}catch(CloneNotSupportedException cnse){
			System.out.println(cnse);
		}
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

