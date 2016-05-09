package cajero;

public interface Persona {

	/*Modificadores y Consultores*/
	String getNombre();

	int getEdad();

	String getDni();

	char getSexo();

	

	//consultores
	void setNombre(String nombre);

	void setEdad(int edad) throws ExcepcionPersona;

	void setDni(String dni) throws ExcepcionPersona;

	void setSexo(char sexo) throws ExcepcionPersona;


}