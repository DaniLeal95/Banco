package test;

import datos.TarjetaImp;

public class TestTarjeta {
	public static void main(String args[]){
		TarjetaImp t0=new TarjetaImp();
		TarjetaImp t1=new TarjetaImp('C');
		TarjetaImp t2=new TarjetaImp('d');
		TarjetaImp t3=new TarjetaImp(t1);
			
			
		System.out.println(t0.toString());
		System.out.println(t1.toString());
		System.out.println(t2.toString());
		System.out.println(t3.toString());
			
		if(t1.equals(t2)){
			System.out.println("Esta mal");
		}
		if(t1.equals(t3)==false){
			System.out.println("esta mal");
		}
	}
		
}
