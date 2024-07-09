package negocio;

import dao.InspectorDao;
import datos.Inspector;

///Clase InspectorABM:
public class InspectorABM 
{
	//Atributo:
	private static InspectorABM instancia = null;
		
	//Constructor:
	protected InspectorABM() {}
		
	//Obtener instancia:
	public static InspectorABM getInstance() 
	{
		if(instancia == null) 
		{
			instancia = new InspectorABM();
		}
		return instancia;
	}
	
	//Traer:
	//CU 4:
	public Inspector traerInspector(int idInspector) 
	{
		return InspectorDao.getInstance().traer(idInspector);
	}
}
