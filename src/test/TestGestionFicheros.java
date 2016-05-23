package test;

import java.util.GregorianCalendar;

import cajero.ExcepcionPersona;
import cajero.TarjetaExcepcion;
import datos.ClienteImp;
import datos.CuentaImp;
import datos.TarjetaImp;
import gestionyutilidades.GestionFicheros;

public class TestGestionFicheros {

	public static void main(String[] args) throws TarjetaExcepcion, ExcepcionPersona {
		GestionFicheros gf=new GestionFicheros();
		
		
		
		//gf.mostrarFicheromaestro();
		
		//TarjetaImp t4=new TarjetaImp('D');
		//CuentaImp c1=new CuentaImp(500);
		//c1.setTarjeta(t4);
		//System.out.println(c1.toString());
		
		//CuentaImp ccopiado=new CuentaImp(c1,8000);
		//	gf.escribirMovimiento(ccopiado);
		//	GregorianCalendar fnacimiento=new GregorianCalendar(12, 10, 1995);
		//ClienteImp c2=new ClienteImp("Eduardo","Mano","Tijeras",fnacimiento,"53284930W",'H');
		//c2.addCuenta(c1);
		//gf.escribirCliente(c2);
		//gf.escribirCliente(cliente);
		
		//gf.escribirMovimiento(ccopiado);
		gf.mostrarFicheromaestro();
		gf.mostrarFicheromovimiento();
		gf.actualizaClientes();
		gf.mostrarFicheromaestro();
		
		
		
	}

}
