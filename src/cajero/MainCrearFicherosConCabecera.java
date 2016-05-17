package cajero;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;

import datos.ClienteImp;
import datos.CuentaImp;
import datos.TarjetaImp;

public class MainCrearFicherosConCabecera {

	public static void main(String[] args) {
		File f = null;

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		

		try {
			
			// Abrir fichero para escribir
			f = new File("ClientesMaestro.dat");
			fos = new FileOutputStream(f.getAbsoluteFile());
			oos = new ObjectOutputStream(fos);
			
			/*
			 * Meto Unos cientes
			 * */
			TarjetaImp t1=new TarjetaImp('D');
			TarjetaImp t3=new TarjetaImp('C');
			CuentaImp c2=new CuentaImp(900);
			
			c2.setTarjeta(t1);
			c2.setTarjeta(t3);
			
			GregorianCalendar fnacimiento=new GregorianCalendar(1995, 12, 10);
			
			
			
			ClienteImp cl1 = new ClienteImp("Daniel", "Leal","Reyes",fnacimiento,"53284930W",'H',"Este tio es el amo");
			
			
			
			cl1.addCuenta(c2);
			System.out.println(cl1.toString());
			
			//oos.writeObject(cl1);
			
		} catch (IOException ioe) {
			System.out.println(ioe);
		} catch (TarjetaExcepcion e) {
			e.printStackTrace();
		} catch (ExcepcionPersona e) {
			e.printStackTrace();
		}

		finally {
			if (oos != null) {
				try {
					// Cerrar fichero
					oos.close();
				} catch (IOException e) {

					System.out.println(e);
				}
			}

		}

			
			
		
		
		
		

	}

}


