package negocio;

import datos.Factura;
import datos.Lectura;
import datos.MedidorAlta;
import java.time.LocalDate;

///Clase CoopElectrica:
public class CoopElectrica 
{
	//Atributo:
	private static CoopElectrica instancia = null;
	
	//Constructor
	protected CoopElectrica() {}
	
	//Obtener instancia:
	public static CoopElectrica getInstance() 
	{
		if(instancia == null) 
		{
			instancia = new CoopElectrica();
		}
		return instancia;
	}
	
	//Generar:
	//CU 13:
	public Factura generarFactura(MedidorAlta ma, int mes, int anio, double precioCargoFijo, int limite, double precioValle, double precioPico, double precioResto) 
	{
		LocalDate fecha = LocalDate.of(anio, mes, 10); //Fecha de la factura.
		String nroCliente = ma.getCliente().getNroCliente(); //Número de cliente de la factura.
		String cliente = ma.getCliente().getApellido() + ", " + ma.getCliente().getNombre(); //Cliente de la factura.
		int nroMedidor = ma.getNroSerie(); //Número de medidor de la factura.
		Factura factura = new Factura(fecha, nroCliente, cliente, nroMedidor); //Generamos la factura sin los ItemFactura.
		Lectura lecturaMes = LecturaABM.getInstance().traerLectura(ma, mes, anio); //Obtenemos la lectura del medidor 'ma' en determinado 'mes' y 'anio'.
		int mesLecturaAnterior = mes - 1; //El mes anterior debería ser 'mes' - 1.
		int anioLecturaAnterior = anio; //El año debería ser el mismo teniendo en cuenta lo anterior sobre el mes.
		if(mes == 1) //Sin embargo, si 'mes' es 1:
		{
			mesLecturaAnterior = 12; //El mes anterior es 12.
			anioLecturaAnterior--; //El año de la lectura anterior es uno menos.
		}
		Lectura lecturaMesAnterior = LecturaABM.getInstance().traerLectura(ma, mesLecturaAnterior, anioLecturaAnterior); //Obtenemos la lectura del mes anterior.
		float consumoHorasValle = lecturaMes.getConsumo().getHorasValle() - lecturaMesAnterior.getConsumo().getHorasValle(); //Obtenemos el consumo en horas valle.
		float consumoHorasPico = lecturaMes.getConsumo().getHorasPico() - lecturaMesAnterior.getConsumo().getHorasPico(); //Obtenemos el consumo en horas pico.
		float consumoHorasResto = lecturaMes.getConsumo().getHorasResto() - lecturaMesAnterior.getConsumo().getHorasResto(); //Obtenemos el consumo en horas resto.
		factura.agregarItemFactura("Cargo fijo", 1, precioCargoFijo); //Agregamos el ItemFactura de cargo fijo.
		if((precioPico * consumoHorasPico) > limite) //Si el total de cargo variable pico supera el límite:
		{
			precioPico *= 1.1; //El precio por cada hora pico de consumo aumenta en un 10%.
		}
		factura.agregarItemFactura("Cargo variable Pico", consumoHorasPico, precioPico); //Agregamos el ItemFactura de cargo variable pico.
		if((precioResto * consumoHorasResto) > limite) //Si el total de cargo variable resto supera el límite:
		{
			precioResto *= 1.1; //El precio por cada hora resto de consumo aumenta en un 10%.
		}
		factura.agregarItemFactura("Cargo variable Resto", consumoHorasResto, precioResto); //Agregamos el ItemFactura de cargo variable resto.
		if((precioValle * consumoHorasValle) > limite) //Si el total de cargo variable valle supera el límite:
		{
			precioValle *= 1.1; //El precio por cada hora valle de consumo aumenta en un 10%.
		}
		factura.agregarItemFactura("Cargo variable Valle", consumoHorasValle, precioValle); //Agregamos el ItemFactura de cargo variable valle.
		return factura; //Retornamos la factura con toda su información cargada.
	}
}
