package cajero;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestCuentaImp {

	public static void main(String[] args) {
		File f = null;

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {

			CuentaImp cuenta1 = new CuentaImp(500);
			CuentaImp cuenta2 = new CuentaImp(700);
			CuentaImp cuenta3 = new CuentaImp(900);
			CuentaImp cuenta4 = new CuentaImp(800);
			CuentaImp cuenta5 = new CuentaImp(800);
			System.out.println(cuenta1.toString());
			System.out.println(cuenta2.toString());
			System.out.println(cuenta3.toString());
			System.out.println(cuenta4.toString());
			System.out.println(cuenta5.toString());


			// Abrir fichero para escribir
			f = new File("CuentaMaestro.dat");
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			// Introducir datos
			oos.writeObject(cuenta1);
			oos.writeObject(cuenta2);
			oos.writeObject(cuenta3);
			oos.writeObject(cuenta4);
			oos.writeObject(cuenta5);
		
		} catch (Exception e) {
			System.out.println(e);
		}

		finally {
			if (oos != null) {
				try {
					// Cerrar fichero
					oos.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}

		}

	}

}
