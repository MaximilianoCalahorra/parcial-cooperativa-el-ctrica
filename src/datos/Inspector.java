package datos;

///Clase Inspector:
public class Inspector extends Persona
{
	//Atributos:
	private String zona;
	
	//Constructor:
	public Inspector() {}
	
	public Inspector(String nombre, String apellido, long dni, String zona) 
	{
		super(nombre, apellido, dni);
		this.zona = zona;
	}
	
	//Getter:
	public String getZona() 
	{
		return zona;
	}
	
	//Setter:
	public void setZona(String zona) 
	{
		this.zona = zona;
	}
	
	//To String:
	public String toString() 
	{
		return "Inspector = [" + super.toString() + ", Zona = " + zona + "]";
	}
}
