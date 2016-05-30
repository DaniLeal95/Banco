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
 *		
 *
 *	Heredadadas:
 *	************
 *		boolean equals(CuentaImp),
 *		int hashCode(),
 *		void toString()
 * 
 * 
 */

public class CuentaImp implements  Cuenta, Serializable {
	
	Utilidades u=new Utilidades();
	
	
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
		
	
			this.saldo=saldo;
			if(contadorCuentas!=0)numCuenta=contadorCuentas+1;
			else numCuenta=u.cogerUltimaId("idcuenta.dat")+1;
			contadorCuentas++;
			u.escribirUltimaId(numCuenta,"idcuenta.dat");
			
			
			tarjetas=new Vector<TarjetaImp>(0,1);
		

	}
	
	
	public CuentaImp(CuentaImp c,double saldo){
		this.numCuenta=c.numCuenta;
		this.saldo=saldo;
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
	
	public void setTarjeta(TarjetaImp t){
		this.tarjetas.add(t);
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (numCuenta ^ (numCuenta >>> 32));
		return result;
	}

	/*
	 *Estudio de la Interfaz de equals
	 *Comentario:Va a comprobar si dos objetos de tipo Cuenta son iguales o no
	 *Cabecera: boolean equals(Object o)
	 *Precondiciones:
	 *Entradas: un objeto de tipo Object 
	 *Salidas: un boolean
	 *Poscondiciones:devolvera true si son iguales y false si no lo son 
	 * */
	@Override
	public boolean equals(Object o) {
		boolean eq=false;
		
		if(o!=null && o instanceof CuentaImp)
			{
				CuentaImp c=(CuentaImp)o;
				if(this.numCuenta==c.numCuenta && this.saldo==c.saldo)
					{
						eq=true;
				}//fin if
		}//fin if
		return(eq);
	}
	


	
	
	
	/*HEREDADAS DE OBJECT*/

	@Override
	public String toString() {
		String tarjeta="";
		for(int i=0;i<tarjetas.size();i++){
			tarjeta=tarjeta.concat("\n\t\t"+tarjetas.elementAt(i).toString());
		}
		return "\n\tNumCuenta: " + numCuenta + ", saldo: " + saldo + "euros, \n\t\ttarjetas: " + tarjeta + "";
	}
	
	
	








	
}
