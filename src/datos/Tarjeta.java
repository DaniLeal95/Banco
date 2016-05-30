package datos;

import cajero.TarjetaExcepcion;

public interface Tarjeta {

	/*
	 * Estudio
	 * 	Propiedades
	 * 	Propiedades basicas
	 * 		string tipo -> consultable y modificable
	 * 		long numTarjeta -> consultable
	 * 	Propiedades Compartidas
	 * 		long contadortarjeta -> consultable
	 * */
	//consultores y modificadores
	public char getTipo();

	public void setTipo(char tipo) throws TarjetaExcepcion;

	public long getNumtarjeta();


}