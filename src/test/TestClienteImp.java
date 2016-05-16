package test;

import cajero.ExcepcionPersona;
import cajero.TarjetaExcepcion;
import datos.ClienteImp;
import datos.CuentaImp;
import datos.TarjetaImp;

public class TestClienteImp {

	public static void main(String[] args) {
		try {
			TarjetaImp t1=new TarjetaImp('D');
			TarjetaImp t2=new TarjetaImp('C');
			TarjetaImp t3=new TarjetaImp('C');
			TarjetaImp t4=new TarjetaImp('D');
			CuentaImp c1=new CuentaImp(500);
			CuentaImp c2=new CuentaImp(900);
			
			c1.setTarjeta(t1);
			c1.setTarjeta(t3);
			c2.setTarjeta(t2);
			c2.setTarjeta(t4);
			
			
			ClienteImp cl1=new ClienteImp("Daniel Leal",20,"53284930W",'H',"Este tio es el amo");
			ClienteImp cl2=new ClienteImp("Estefania Lucrecia",25,"53224930W",'M',"Pues... yo le daba");
			
			cl1.addCuenta(c2);
			cl2.addCuenta(c1);
			
			System.out.println(cl1.toString());
			System.out.println(cl2.toString());
		} catch (TarjetaExcepcion te) {
			System.out.println(te);
		} catch (ExcepcionPersona ep) {
			System.out.println(ep);
		}
	}

}
