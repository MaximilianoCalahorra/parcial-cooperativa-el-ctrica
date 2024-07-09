package negocio;

import dao.LecturaDao;
import datos.Lectura;
import datos.MedidorAlta;
import java.util.List;

///Clase LecturaABM:
public class LecturaABM 
{
	//Atributo:
	private static LecturaABM instancia = null;
		
	//Constructor:
	protected LecturaABM() {}
		
	//Obtener instancia:
	public static LecturaABM getInstance() 
	{
		if(instancia == null) 
		{
			instancia = new LecturaABM();
		}
		return instancia;
	}
	
	//Traer:
	//CU 7:
	public List<Lectura> traerLecturas()
	{
		return LecturaDao.getInstance().traerLecturas();
	}
	
	//CU 8:
	public List<Lectura> traerLecturas(MedidorAlta ma)
	{
		return LecturaDao.getInstance().traerLecturas(ma);
	}
	
	//CU 9:
	public Lectura traerLectura(MedidorAlta ma, int mes, int anio) 
	{
		return LecturaDao.getInstance().traerLectura(ma, mes, anio);
	}
}
