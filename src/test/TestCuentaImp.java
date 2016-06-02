package test;

import java.util.Vector;

import datos.CuentaImp;
import datos.TarjetaImp;

public class TestCuentaImp {

	public static void main(String[] args) {
		CuentaImp c1=new CuentaImp(500);
		CuentaImp c2=new CuentaImp(900);
		TarjetaImp t1=new TarjetaImp('D',"1234");
		TarjetaImp t2=new TarjetaImp('C',"5678");
		TarjetaImp t3=new TarjetaImp('C',"9123");
		TarjetaImp t4=new TarjetaImp('D',"4567");
		Vector<TarjetaImp> tarjetas=new Vector(0,1);
		tarjetas.add(t1);
		tarjetas.add(t2);
		
		CuentaImp c3=new CuentaImp(1200,tarjetas);
		//añadir tarjetas
		
		c1.añadirTarjeta(t1);
		c1.añadirTarjeta(t3);
		c2.añadirTarjeta(t2);
		c2.añadirTarjeta(t4);
			
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		
		//eliminar Tarjetas
		//c1.eliminarTarjeta(t1);
		//c2.eliminarTarjeta(t1);
		//System.out.println("deberia de faltar la tarjeta "+t1.getNumtarjeta()+" ->"+c1.toString());
		//System.out.println("deberia de seguir igual -> "+c2.toString());
		
	}

}
