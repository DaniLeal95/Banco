package datos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Vector;

import cajero.ExcepcionPersona;
import gestionyutilidades.Utilidades;


/*
 * Restricciones:
 * 		Nada
 * Metodos aniadidos:
 ******************
 ****************
 * Metodos heredados
 * 		public String toString()
 * 		public int compareTo
 * 		public ClienteImp clone()
 * 
 * 
 * 
 * */

public class ClienteImp extends PersonaImpl implements Cliente,Cloneable,Serializable{
	/*-----------------------*/
	/*Atributos b�sicos*/
	private long idCliente;
	private Vector<CuentaImp> cuentas;
	private String observaciones;

	
	/*Atributos Compartidos*/
	private static final long serialVersionUID = 1183469131124915878L;
	public static long contadorclientes=0;
	/*----------------------*/
	
	/*
	 * Creamos una variable de clase de Utilidades.
	 * */
	Utilidades u=new Utilidades();
	/*Constructores*/
	public ClienteImp(){
		super();
		/*Estas 4 lineas son para obtener el idCliente*/
		if(contadorclientes!=0){idCliente=contadorclientes+1;}
		else{idCliente=u.cogerUltimaId("idclientes.dat")+1;}
		contadorclientes=idCliente;
		u.escribirUltimaId(idCliente,"idclientes.dat");
		/*-------------------------------------------*/
		this.cuentas=new Vector<CuentaImp>(0,1);
		this.observaciones=null;
	}
	
	public ClienteImp(String nombre,String apellido1,String apellido2,GregorianCalendar fnacimiento,String dni,char genero) throws ExcepcionPersona{
		super(nombre,apellido1,apellido2,fnacimiento,dni,genero);
		/*Estas 4 lineas son para obtener el idCliente*/
		if(contadorclientes!=0){idCliente=contadorclientes+1;}
		else{idCliente=u.cogerUltimaId("idclientes.dat")+1;}
		contadorclientes=idCliente;
		u.escribirUltimaId(idCliente,"idclientes.dat");
		/*-------------------------------------------*/
		this.cuentas=new Vector<CuentaImp>(0,1);
		this.observaciones=null;
	}
	
	public ClienteImp(String nombre,String apellido1,String apellido2,GregorianCalendar fnacimiento,String dni,char genero,String observaciones) throws ExcepcionPersona{
		super(nombre,apellido1,apellido2,fnacimiento,dni,genero);
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
	}
	
	/*----------------*/
	
	/***************
	 **Consultores**
	 ***************/
	
	public long getIdCliente(){
		return this.idCliente;
	}
	
	public String getObservaciones(){
		return this.observaciones;
	}
	
	public Vector<CuentaImp> getCuentas(){
		return this.cuentas;
	}
	
	/*---------------
	 * Modificadores-
	 * --------------
	 * */
	
	public void addCuenta(CuentaImp c){
		this.cuentas.add(c);
	}
	
	public void setObservaciones(String observaciones){
		this.observaciones=observaciones;
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


	

	
	
	
	
	/*----------------*/

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
	 * Breve comentario:
	 * 	 Este metodo recibe y se compara con un objeto ClienteImp,
	 * 		se comparara por el id del Cliente.
	 * 			Si el idCliente propio es mayor al que recibe entonces retornara 1
	 * 			Si el idCliente propio es menor al que recibe entonces retornara -1
	 * 			en otro caso retornara 0.
	 * Cabecera:
	 * 		int compareTo(ClienteImp c)
	 * Precondiciones;
	 * 		nada
	 * Entradas:
	 * 		Un objeto ClienteImp
	 * Salidas:
	 * 		un entero
	 * Postcondiciones;
	 * 		el entero retornara asociado al nombre -> Funcion.
	 * 															
	 * 		
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
		copia = (ClienteImp) super.clone();
		return copia;
	}
	

	
	
}

