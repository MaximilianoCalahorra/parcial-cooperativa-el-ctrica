package datos;

///Clase Cliente:
public class Cliente extends Persona
{
	//Atributos:
	private String nroCliente;
	
	//Constructor:
	public Cliente() {}
	
	public Cliente(String nombre, String apellido, long dni, String nroCliente) 
	{
		super(nombre, apellido, dni);
		this.nroCliente = nroCliente;
	}
	
	//Getter:
	public String getNroCliente() 
	{
		return nroCliente;
	}
	
	//Setter:
	public void setNroCliente(String nroCliente) 
	{
		this.nroCliente = nroCliente;
	}
	
	//To String:
	public String toString() 
	{
		return "Cliente = [" + super.toString() + ", Numero de cliente = #" + nroCliente + "]";
	}
}
