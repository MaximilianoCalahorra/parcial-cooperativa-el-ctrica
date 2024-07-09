package datos;

///Clase Consumo:
public class Consumo 
{
	//Atributos:
	private int idConsumo;
	private float horasValle;
	private float horasPico;
	private float horasResto;
	
	//Constructor:
	public Consumo() {}
	
	public Consumo(float horasValle, float horasPico, float horasResto) 
	{
		this.horasValle = horasValle;
		this.horasPico = horasPico;
		this.horasResto = horasResto;
	}

	//Getters:
	public int getIdConsumo()
	{
		return idConsumo;
	}

	public float getHorasValle() 
	{
		return horasValle;
	}

	public float getHorasPico() 
	{
		return horasPico;
	}

	public float getHorasResto()
	{
		return horasResto;
	}

	//Setters:
	protected void setIdConsumo(int idConsumo)
	{
		this.idConsumo = idConsumo;
	}

	public void setHorasValle(float horasValle) 
	{
		this.horasValle = horasValle;
	}

	public void setHorasPico(float horasPico)
	{
		this.horasPico = horasPico;
	}

	public void setHorasResto(float horasResto)
	{
		this.horasResto = horasResto;
	}
	
	//To String:
	public String toString() 
	{
		return "Consumo = [ID = #" + idConsumo + ", Horas valle = " + horasValle + ", Horas pico = " + horasPico + ", Horas resto = " + horasResto;
	}
}
