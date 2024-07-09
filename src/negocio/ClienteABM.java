package negocio;

import dao.ClienteDao;
import datos.Cliente;

///Clase ClienteABM:
public class ClienteABM 
{
	//Atributo:
	private static ClienteABM instancia = null;
		
	//Constructor:
	protected ClienteABM() {}
		
	//Obtener instancia:
	public static ClienteABM getInstance() 
	{
		if(instancia == null) 
		{
			instancia = new ClienteABM();
		}
		return instancia;
	}
	
	//Traer:
	//CU 3:
	public Cliente traerCliente(int idCliente) 
	{
		return ClienteDao.getInstance().traer(idCliente);
	}
}
