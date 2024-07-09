package test;

import datos.Factura;
import negocio.ClienteABM;
import negocio.CoopElectrica;
import negocio.InspectorABM;
import negocio.LecturaABM;
import negocio.MedidorAltaABM;
import negocio.PersonaABM;

///Clase Test:
public class Test
{
	public static void main(String[] args) 
	{
		///Test 1:
		System.out.println("Test 1:");
		System.out.println("Personas:");
		System.out.println(PersonaABM.getInstance().traerPersonas());
		
		///Test 2:
		System.out.println("\nTest 2:");
		System.out.println("Cliente con el ID #2:");
		System.out.println(ClienteABM.getInstance().traerCliente(2));
	
		///Test 3:
		System.out.println("\nTest 3:");
		System.out.println("Inspector con el ID #3:");
		System.out.println(InspectorABM.getInstance().traerInspector(3));
			
		///Test 4:
		System.out.println("\nTest 4:");
		System.out.println("Medidores con su respectivo cliente:");
		System.out.println(MedidorAltaABM.getInstance().traerMedidoresAlta());
		
		///Test 5:
		System.out.println("\nTest 5:");
		System.out.println("Medidor de alta con numero de serie #934152 y su respectivo cliente:");
		System.out.println(MedidorAltaABM.getInstance().traerMedidorAlta(934152));
		
		///Test 6:
		System.out.println("\nTest 6:");
		System.out.println("Lecturas con su respectivo medidor de alta, inspector y consumo:");
		System.out.println(LecturaABM.getInstance().traerLecturas());	
		
		///Test 7:
		System.out.println("\nTest 7:");
		System.out.println("Lecturas del medidor de alta con numero de serie #438823 con él, inspector y consumo:");
		System.out.println(LecturaABM.getInstance().traerLecturas(MedidorAltaABM.getInstance().traerMedidorAlta(438823)));
		
		///Test 8:
		System.out.println("\nTest 8:");
		System.out.println("Lectura del medidor de alta con numero de serie #438823 con él, inspector y consumo tomada en 1/2019:");
		System.out.println(LecturaABM.getInstance().traerLectura(MedidorAltaABM.getInstance().traerMedidorAlta(438823), 1, 2019));
		
		///Test 9:
		System.out.println("\nTest 9:");
		System.out.println("Factura 10/2/2019:");
		Factura factura = CoopElectrica.getInstance().generarFactura(MedidorAltaABM.getInstance().traerMedidorAlta(438823), 2, 2019, 3226.0, 300, 2.26, 2.16, 2.061);
		System.out.println(factura);
		System.out.println("Total de la factura: $" + factura.calcularTotal());
	}
}
