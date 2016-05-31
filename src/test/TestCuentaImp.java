package test;

import datos.CuentaImp;
import datos.TarjetaImp;

public class TestCuentaImp {

	public static void main(String[] args) {
		
		
			TarjetaImp t1=new TarjetaImp('D');
			TarjetaImp t2=new TarjetaImp('C');
			TarjetaImp t3=new TarjetaImp('C');
			TarjetaImp t4=new TarjetaImp('D');
			CuentaImp c1=new CuentaImp(500);
			CuentaImp c2=new CuentaImp(900);
			
			c1.añadirTarjeta(t1);
			c1.añadirTarjeta(t3);
			c2.añadirTarjeta(t2);
			c2.añadirTarjeta(t4);
			
			
			System.out.println(c1.toString());
			System.out.println(c2.toString());
		
	}

}
