package negocio;

import dao.MedidorAltaDao;
import datos.MedidorAlta;
import java.util.List;

///Clase MedidorAltaABM:
public class MedidorAltaABM 
{
	//Atributo:
	private static MedidorAltaABM instancia = null;
		
	//Constructor:
	protected MedidorAltaABM() {}
		
	//Obtener instancia:
	public static MedidorAltaABM getInstance() 
	{
		if(instancia == null) 
		{
			instancia = new MedidorAltaABM();
		}
		return instancia;
	}
	
	//Traer:
	//CU 5:
	public List<MedidorAlta> traerMedidoresAlta()
	{
		return MedidorAltaDao.getInstance().traerMedidoresAlta();
	}
	
	//CU 6:
	public MedidorAlta traerMedidorAlta(int nroSerie) 
	{
		return MedidorAltaDao.getInstance().traerMedidorAlta(nroSerie);
	}
}
