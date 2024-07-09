package datos;

import java.time.LocalDate;

///Clase Lectura:
public class Lectura 
{
	//Atributos:
	private int idLectura;
	private LocalDate fecha;
	private MedidorAlta medidorAlta;
	private Inspector inspector;
	private Consumo consumo;
	
	//Constructor:
	public Lectura() {}
	
	public Lectura(LocalDate fecha, MedidorAlta medidorAlta, Inspector inspector, Consumo consumo) 
	{
		this.fecha = fecha;
		this.medidorAlta = medidorAlta;
		this.inspector = inspector;
		this.consumo = consumo;
	}

	//Getters:
	public int getIdLectura()
	{
		return idLectura;
	}

	public LocalDate getFecha() 
	{
		return fecha;
	}

	public MedidorAlta getMedidorAlta() 
	{
		return medidorAlta;
	}

	public Inspector getInspector() 
	{
		return inspector;
	}

	public Consumo getConsumo() 
	{
		return consumo;
	}

	//Setters:
	protected void setIdLectura(int idLectura) 
	{
		this.idLectura = idLectura;
	}

	public void setFecha(LocalDate fecha) 
	{
		this.fecha = fecha;
	}

	public void setMedidorAlta(MedidorAlta medidorAlta)
	{
		this.medidorAlta = medidorAlta;
	}

	public void setInspector(Inspector inspector)
	{
		this.inspector = inspector;
	}

	public void setConsumo(Consumo consumo)
	{
		this.consumo = consumo;
	}
	
	//To String:
	public String toString() 
	{
		return "Lectura = [ID = #" + idLectura + ", " + medidorAlta.toString() + ", " + inspector.toString() + ", " + consumo.toString() + "]";
	}
}
