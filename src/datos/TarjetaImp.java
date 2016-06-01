package datos;

import java.io.Serializable;

import cajero.TarjetaExcepcion;
import gestionyutilidades.Utilidades;

public class TarjetaImp implements Tarjeta,Serializable,Comparable<TarjetaImp>,Cloneable {
	Utilidades u=new Utilidades();
	private static final long serialVersionUID = -2452366085707864944L;
	/* 
	 * Clase Implementada de Tarjeta 

	 * 	Metodos añadidos
	 * 		String tarjetatoCadena()
	 * 	
	 * 	Metodos heredados:
	 * 		int hashCode()
	 * 		boolean equals(Object o)
	 * 		int compareTo(TarjetaImp t)
	 * 		TarjetaImp clone()
	 * 		String toString()
	 * 
	 * */
	//basicas
	private char tipo;
	private long numtarjeta;
	//compartidas
	public static long contadortarjeta=0;
	
	//constructores
	public TarjetaImp(){
		if(contadortarjeta!=0){
			numtarjeta=contadortarjeta++;	
		}
		else{ 
			numtarjeta=u.cogerUltimaId("idtarjeta.dat")+1;
		}
		contadortarjeta=numtarjeta;
		u.escribirUltimaId(numtarjeta,"idtarjeta.dat");
		tipo=' ';
	}
	
	
	public TarjetaImp(char tipo) {
		this();
		if(Character.toUpperCase(tipo)=='C' || Character.toUpperCase(tipo)=='D'){
			this.tipo=tipo;
		}
		
	}
	/*Constructor de copia*/
	public TarjetaImp(TarjetaImp tp){
		this.tipo=tp.getTipo();
		this.numtarjeta=tp.numtarjeta;
	}
	/**------------------------------------------------------**/
	/*Consultores*/
	@Override
	public char getTipo() {
		return tipo;
	}

	@Override
	public long getNumtarjeta() {
		return numtarjeta;
	}
	
	public long getNumTarjetas(){
		return contadortarjeta;
	}

	
	//modificadores
	@Override
	public void setTipo(char tipo) throws TarjetaExcepcion {
		
		if(Character.toUpperCase(tipo)=='C' || Character.toUpperCase(tipo)=='D'){
			this.tipo = tipo;
		}
		else {
			throw new TarjetaExcepcion("Solo puede ser de Credito o de Debito");
		}
	}
	
	/*
	 * METODOS HEREDADOS
	 * 
	 * */
	
	//Metodos sobrescritos
	@Override
	public int hashCode() {
		return (int)(this.numtarjeta*1.2+1/2*this.numtarjeta);
	}
	
	/*
	 * Metodo equals
	 * 	Criterio de igualdad:Dos tarjetas son iguales si su numero de tarjeta y su tipo son iguales.
	 * */
	@Override
	public boolean equals(Object o){
		boolean igual=false;
		
		if(o!=null && o instanceof TarjetaImp) {
			TarjetaImp t = (TarjetaImp) o;
			if(this.numtarjeta==t.numtarjeta && this.tipo==t.tipo){
				igual=true;
			}
			
		}
		
		return igual;
		
	}
	
	/*CompareTo
	 * ********
	 *  Criterio de comparacion: Compara por numero de tarjeta, retornara 1 si es mayor, -1 si es menor y 0 cuando sean iguales
	 * */
	@Override
	public int compareTo(TarjetaImp t)
	{
		int compara = 0;
		if(this.numtarjeta<t.numtarjeta)
			compara = -1;
		else
			if(this.tipo>t.tipo)
				compara = 1;
		return compara;
	}
	
	/*Clone*/
	
	@Override
	public TarjetaImp clone()
	{
		TarjetaImp copia = null;
		try{
			copia = (TarjetaImp) super.clone();
		}
		catch(CloneNotSupportedException e){
			System.out.println(e);
		}
		return copia;
	}
	
	
	@Override
	public String toString() {
		String tip="Debito";
		if(tipo=='C')tip="Credito";	//esto simplemente es estetico, 
					//para que en vez que en el toString muestre un char nos muestre una cadena
		
		return "Numtarjeta: " + (numtarjeta) +", tipo: " + tip ;
	}
	/*
	*	Métodos añadidos
	*/
	/*
	 * cabecera: cadena aCadena()
	 * comentario: el método devuelve una cadena con los valores de todos los atributos de la cuenta.
	 * precondiciones: nada
	 * entrada: nada
	 * salida: una cadena
	 * postcondiciones: cadena asociada al nombre -> Funcion
	 */
	public String tarjetatoCadena()
	{
		return getNumtarjeta()+","+getTipo();
	}
	



}
