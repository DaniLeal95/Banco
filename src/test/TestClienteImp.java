package test;

import java.util.GregorianCalendar;

import cajero.ExcepcionPersona;
import cajero.TarjetaExcepcion;
import datos.ClienteImp;
import datos.CuentaImp;
import datos.TarjetaImp;
import gestionyutilidades.GestionFicheros;

public class TestClienteImp {

	public static void main(String[] args) {
		GestionFicheros gf=new GestionFicheros();
		
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
			
			GregorianCalendar fnacimiento=new GregorianCalendar(1995, 12, 10);
			GregorianCalendar fnacimiento2=new GregorianCalendar(1990, 6, 5);
			
			
			
			ClienteImp cl1 = new ClienteImp("Daniel", "Leal","Reyes",fnacimiento,"53284930W",'H',"Este tio es el amo");
			ClienteImp cl2=new ClienteImp("Estefania", "Lucrecia","Padron",fnacimiento2,"53224930W",'M',"Pues... yo le daba");
			
			
			
			cl1.addCuenta(c2);
			cl2.addCuenta(c1);
			System.out.println(cl1.toString());
			System.out.println(cl2.toString());
			
			gf.escribirCliente("ClientesMaestro.dat", cl1);
			gf.escribirCliente("ClientesMaestro.dat", cl2);
			
			
		} catch (TarjetaExcepcion te) {
			System.out.println(te);
		} catch (ExcepcionPersona ep) {
			System.out.println(ep);
		}
		
	}

}
