package test;

import java.util.GregorianCalendar;

import datos.ClienteImp;
import datos.CuentaImp;
import datos.PersonaNoValida;
import datos.TarjetaImp;
import gestionyutilidades.GestionFicheros;

public class TestClienteImp {

	public static void main(String[] args) {
		GestionFicheros gf=new GestionFicheros();
		
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
			
			GregorianCalendar fnacimiento=new GregorianCalendar(1995, 12, 10);
			GregorianCalendar fnacimiento2=new GregorianCalendar(1990, 6, 5);
			
			
			
			ClienteImp cl1 = new ClienteImp("Daniel", "Leal Reyes",fnacimiento,"53284930W",'H',"Este tio es el amo","123456");
			ClienteImp cl2=new ClienteImp("Estefania", "Lucrecia Padron",fnacimiento2,"53224930W",'M',"Pues... yo le daba","123456");
			
			
			
			/*cl1.addCuenta(c2);
			cl2.addCuenta(c1);
			System.out.println(cl1.toString());
			System.out.println(cl2.toString());
			
			gf.escribirCliente(cl1);
			gf.escribirCliente( cl2);*/
			
			GregorianCalendar fechaValida=new GregorianCalendar(1992,4,16);
			//GregorianCalendar fechanoValida=new GregorianCalendar(2002,4,16);
			GregorianCalendar fechanoValida2=new GregorianCalendar(2000,5,2);
			try{
				cl1.setFNacimiento(fechaValida);
				//cl1.setFNacimiento(fechanoValida);
				cl1.setFNacimiento(fechanoValida2);
			}catch(PersonaNoValida p){
				System.out.println(p);
			}
		
	
		
	}

}
