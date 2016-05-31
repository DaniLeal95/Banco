package datos;

import java.io.Serializable;
import java.util.Vector;

import gestionyutilidades.Utilidades;


/*
 *Restricciones :
 **************
 * 	Ninguna
 *
 * Funcionalidades:
 * ***************
 * 	
 * 	Aniadidas:
 *	********
 *		void añadirTarjeta(TarjetaImp t)
 *		String cuentatoCadena()
 *		
 *
 *	Heredadadas:
 *	************
 *		boolean equals(CuentaImp),
 *		int hashCode(),
 *		void toString(),
 *		CuentaImp clone(),
 *		int compareTo(CuentaImp c),
 *		boolean equals(Object o).
 * 
 * 
 */

public class CuentaImp implements  Cuenta, Serializable, Cloneable, Comparable<CuentaImp> {
	
	
	
	
	/**
	 * UID
	 */
	private static final long serialVersionUID = 1183469131124915878L;

	//ATRIBUTOS
	private long numCuenta;
	private double saldo;
	private Vector<TarjetaImp> tarjetas;
	

	
	//PropiedadesCompartidas
	public static long contadorCuentas=0;
	
	//constructores
	public CuentaImp(){
		Utilidades u=new Utilidades();
		saldo=0;
		
		if(contadorCuentas!=0){numCuenta=contadorCuentas+1; } 
		else{ 
			numCuenta=u.cogerUltimaId("idcuenta.dat")+1;
		}
		contadorCuentas=numCuenta;
		u.escribirUltimaId(numCuenta,"idcuenta.dat");
		tarjetas=new Vector<TarjetaImp>(0,1);
		
	}
	
	public CuentaImp(long saldo){
		this();
		this.saldo=saldo;
		tarjetas=new Vector<TarjetaImp>(0,1);
	}
	//Constructor de copia
	public CuentaImp(CuentaImp c){
		this.numCuenta=c.numCuenta;
		this.saldo=c.saldo;
		this.tarjetas=c.tarjetas;
	}
	
	//Consultores

	public long getNumCuenta(){
		return(this.numCuenta);
	}
	public double getSaldo(){
		return(this.saldo);
	}
	public Vector<TarjetaImp> getTarjetas(){
		return (this.tarjetas);
	}
	//modificadores
	
	public void setSaldo(double saldo){
		this.saldo=saldo; 
		
	}
	
	
	
	
	/*-------------------------
	 * FUNCIONALIDADES A�ADIDAS
	 * ------------------------
	 * */
	
	/*
	 * setTarjeta
	 * 	Breve Comentario:
	 * -----------------
	 * 		Este metodo recibe por parametros una TarjetaImp y lo a�ade al vector de tarjetas
	 * 
	 * 	Cabecera:
	 * ----------
	 * 		void setTarjeta(TarjetaImp t)
	 * 		
	 * Precondiciones:
	 * --------------
	 * 		Nada
	 * 
	 * Entradas:
	 * ----------
	 * 		Una tarjetaImp
	 * 
	 * Salidas:
	 * ---------
	 * 		Nada
	 * 
	 * Postcondiciones:
	 * ----------------
	 * 		Nada
	 * 
	 * */
	
	public void añadirTarjeta(TarjetaImp t){
		this.tarjetas.add(t);
	}
	
		/*CuentatoCadena
		 * Breve comentario: 
		 * 		el método devuelve un String con los valores de todos los atributos de la Cuenta.
		 * Cabecera:
		 * 		String cuentatoCadena()
		 * precondiciones:
		 * 		 nada
		 * entrada:
		 * 		 nada
		 * salida:
		 * 		 un String
		 * postcondiciones:
		 * 		 el String retornara asociado  al nombre -> Funcion
		 */
		public String cuentatoCadena(){
			return getNumCuenta()+", "+getSaldo()+", "+getTarjetas();
		}
	
	
	
	
	//HEREDADAS
	@Override
	public int hashCode() {
		int result = 1;
		result= (int)(this.numCuenta*this.saldo/100*1.6);
		return result;
	}

	/*
	 *Equals
	 *	
	 *	Criterio de igualdad: 
	 *			dos Cuentas son iguales si tienen el mismo numCuenta y el mismo saldo.
	 * */
	@Override
	public boolean equals(Object o) {
		boolean iguales=false;
		
		if(o!=null && o instanceof CuentaImp)
			{
				CuentaImp c=(CuentaImp)o;
				if(this.numCuenta==c.numCuenta && this.saldo==c.saldo)
					{
						iguales=true;
				}//fin if
		}//fin if
		return(iguales);
	}
	

	@Override
	public CuentaImp clone(){
		CuentaImp copia=null;
		try{
			
			copia=(CuentaImp) super.clone();
			copia.numCuenta=this.numCuenta;
			
		}catch(CloneNotSupportedException cnse){
			
			System.out.println(cnse);
			
		}
		
		return copia;
	}
	/*	CompareTo
	 * 	*********
	 * 	Criterio de comparacion;
	 * 		Compara por numCuenta, retorna 1 si es mayor, -1 si es menor y 0 si son iguales.
	 * 
	 * */
	@Override
	public int compareTo(CuentaImp c){
		int comparada= 0;
		
		return comparada;
	}
	
	

	@Override
	public String toString() {
		String tarjeta="";
		for(int i=0;i<tarjetas.size();i++){
			tarjeta=tarjeta.concat("\n\t\t"+tarjetas.elementAt(i).toString());
		}
		return "\n\tNumCuenta: " + numCuenta + ", saldo: " + saldo + "euros, \n\t\ttarjetas: " + tarjeta + "";
	}
	
	
	








	
}
