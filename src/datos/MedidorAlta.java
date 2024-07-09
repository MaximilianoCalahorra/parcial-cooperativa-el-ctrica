package datos;

///Clase MedidorAlta:
public class MedidorAlta
{
	//Atributos:
	private int idMedidorAlta;
	private Cliente cliente;
	private int nroSerie;
	private String domicilioMedidor;
	private int zona;
	
	//Constructor:
	public MedidorAlta() {}
	
	public MedidorAlta(Cliente cliente, int nroSerie, String domicilioMedidor, int zona) 
	{
		this.cliente = cliente;
		this.nroSerie = nroSerie;
		this.domicilioMedidor = domicilioMedidor;
		this.zona = zona;
	}

	//Getters:
	public int getIdMedidorAlta() 
	{
		return idMedidorAlta;
	}

	public Cliente getCliente() 
	{
		return cliente;
	}

	public int getNroSerie() 
	{
		return nroSerie;
	}

	public String getDomicilioMedidor() 
	{
		return domicilioMedidor;
	}

	public int getZona()
	{
		return zona;
	}

	//Setters:
	protected void setIdMedidorAlta(int idMedidorAlta)
	{
		this.idMedidorAlta = idMedidorAlta;
	}

	public void setCliente(Cliente cliente)
	{
		this.cliente = cliente;
	}

	public void setNroSerie(int nroSerie)
	{
		this.nroSerie = nroSerie;
	}

	public void setDomicilioMedidor(String domicilioMedidor) 
	{
		this.domicilioMedidor = domicilioMedidor;
	}

	public void setZona(int zona) 
	{
		this.zona = zona;
	}
	
	//To String:
	public String toString() 
	{
		return "MedidorAlta = [ID = #" + idMedidorAlta + ", " + cliente.toString() + ", Numero de serie = #" + nroSerie + ", Domicilio medidor = " + domicilioMedidor + ", Zona = #" + zona + "]"; 
	}
}
