package datos;

///Clase ItemFactura:
public class ItemFactura 
{
	//Atributos:
	private String detalle;
	private float cantidad;
	private double precio;
	
	//Constructor:
	public ItemFactura(String detalle, float cantidad, double precio)
	{
		this.detalle = detalle;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	//Getters:
	public String getDetalle()
	{
		return detalle;
	}

	public float getCantidad() 
	{
		return cantidad;
	}

	public double getPrecio()
	{
		return precio;
	}

	//Setters:
	public void setDetalle(String detalle) 
	{
		this.detalle = detalle;
	}

	public void setCantidad(float cantidad)
	{
		this.cantidad = cantidad;
	}

	public void setPrecio(double precio)
	{
		this.precio = precio;
	}
	
	//To String:
	public String toString() 
	{
		return "ItemFactura = [Detalle = " + detalle + ", Cantidad = " + cantidad + ", Precio = $" + precio + "]";
	}
	
	//Calcular:
	//CU 11:
	public double calcularSubTotal() 
	{
		return cantidad * precio;
	}
}
