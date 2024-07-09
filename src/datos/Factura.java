package datos;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

///Clase Factura:
public class Factura 
{
	//Atributos:
	private LocalDate fecha;
	private String nroCliente;
	private String cliente;
	private int nroMedidor;
	private List<ItemFactura> itemsFactura;
	
	//Constructor:
	public Factura(LocalDate fecha, String nroCliente, String cliente, int nroMedidor) 
	{
		this.fecha = fecha;
		this.nroCliente = nroCliente;
		this.cliente = cliente;
		this.nroMedidor = nroMedidor;
		this.itemsFactura = new ArrayList<ItemFactura>();
	}

	//Getters:
	public LocalDate getFecha()
	{
		return fecha;
	}

	public String getNroCliente() 
	{
		return nroCliente;
	}

	public String getCliente()
	{
		return cliente;
	}

	public int getNroMedidor()
	{
		return nroMedidor;
	}
	
	public List<ItemFactura> getItemsFactura()
	{
		return itemsFactura;
	}

	//Setters:
	public void setFecha(LocalDate fecha) 
	{
		this.fecha = fecha;
	}

	public void setNroCliente(String nroCliente)
	{
		this.nroCliente = nroCliente;
	}

	public void setCliente(String cliente) 
	{
		this.cliente = cliente;
	}

	public void setNroMedidor(int nroMedidor) 
	{
		this.nroMedidor = nroMedidor;
	}
	
	//To String:
	public String toString() 
	{
		String factura = "Factura = [Fecha = " + fecha + ", Numero de cliente = #" + nroCliente + ", Cliente = " + cliente + ", Numero de medidor = #" + nroMedidor + ", ItemsFactura = [";
		for(ItemFactura itemFactura: itemsFactura) 
		{
			factura += itemFactura.toString() + ", ";
		}
		return factura;
	}
	
	//Agregar:
	//CU 10:
	public boolean agregarItemFactura(String detalle, float cant, double precio) 
	{
		return itemsFactura.add(new ItemFactura(detalle, cant, precio));
	}
	
	//Calcular:
	//CU 12:
	public double calcularTotal() 
	{
		double total = 0;
		for(ItemFactura itemFactura: itemsFactura) 
		{
			total += itemFactura.calcularSubTotal();
		}
		return total;
	}
}
