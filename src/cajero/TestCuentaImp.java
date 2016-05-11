package cajero;

public class TestCuentaImp {

	public static void main(String[] args) {
		
			int a=2;
			double b=2.5;
			double c=a/b;
			System.out.println(c);
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
			
			
			System.out.println(c1.toString());
			System.out.println(c2.toString());
		
		} catch (TarjetaExcepcion te) {
			System.out.println(te);
		}
		
	}

}
