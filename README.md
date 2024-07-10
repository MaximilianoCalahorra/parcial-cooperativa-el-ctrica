# Descripción del programa

Consiste en mi resolución a un parcial viejo de la materia Orientación a Objetos II de la carrera de Sistemas de la UNLa.

Está desarrollado completamente en Java mediante el paradigma de la POO, aplicando conceptos tales como clases, atributos, métodos, polimorfismo, reutilización de código, manejo de excepciones y de fechas y horas, herencia y clases abstractas, y con aplicación y manejo de la persistencia mediante el uso de Hibernate.

### Diagrama de clases
![image](https://github.com/MaximilianoCalahorra/parcial-cooperativa-electrica/assets/152804837/5ba589c2-728d-4437-83d7-d1bef9fc70f2)

### Casos de uso
- #1: + traerPersonas(): List\<Persona>
- #2: + traerPersona(int id): Persona
- #3: + traerCliente(int id): Cliente
- #4: + traerInspector(int id): Inspector
- #5: + traerMedidoresAlta(): List\<MedidorAlta>
- #6: + traerMedidorAlta(int nroSerie): MedidorAlta
- #7: + traerLectura(): List\<Lectura>
- #8: + traerLectura(MedidorAlta ma): List\<Lectura>
  - Las lecturas son mensuales antes del día 10 para cada medidor.
- #9: + traerLectura(MedidorAlta ma, int mes, int anio): Lectura
- #10: + agregarItemFactura(String detalle, int cant, double precio): boolean
- #11: + calcularSubTotal(): double
- #12: + calcularTotal(): double
- #13: + generarFactura(MedidorAlta mAlta, int mes, int anio, double precioCargoFijo, int limite, double precioValle, double precioPico, double precioResto): Factura
  - La factura se genera al vuelo (no se persiste).
  - La fecha de factura es 10/mes/anio.
  - El atributo cliente setea "apellido, nombres".
  - Para calcular el consumo se hace la diferencia entre la lectura del mes/anio de la factura y la lectura del mes anterior. Por ejemplo, si la factura es 01/2019 se necesitan las lecturas del 12/2018 y 01/2019, mientras que si la factura es 03/2019 se necesitan las lectuas del 02/2019 y 03/2019.
  - La factura va a tener cuatro itemFactura: Cargo fijo, Cargo variable Pico, Cargo variable Resto y Cargo variable Valle; la cantidad es 1 para el Cargo fijo y en el resto el valor que determine en c/u la diferencia de las lecturas.
  - Los precios y el límite son parámetro del CU. Si los cargos variables superan el límite, el precio se incrementa un 10%.

### Test
- #1: Traer todas las personas.
- #2: Traer cliente id=2.
- #3: Traer inspector id=3.
- #4: Traer todos los medidores, cada uno con su cliente.
- #5: Traer medidor de alta y su cliente nroSerie=934152.
- #6: Traer todas las lecturas con el consumo y el medidor.
- #7: Traer todas las lecturas y el consumo del medidorAlta = MedidorAlta [idMedidorAlta=1, nroSerie=438823, domicilioMedidor=29 Septiembre 3500 R.Escalada, cliente=Cliente: idPersona=1, apellido=Perez, nombre=Ana, dni=11111111, nroCliente=111111]
- #8: Traer lectura y el consumo medidorAlta=MedidorAlta [idMedidorAlta=1, nroSerie=438823, domicilioMedidor=29 Septiembre 3500 R.Escalada, cliente=Cliente: idPersona=1, apellido=Perez, nombre=Ana, dni=11111111, nroCliente=111111], mes=1, año=2019.
- #9: Generar y mostrar factura: 10/02/2019
medidorAlta=MedidorAlta [idMedidorAlta=1, nroSerie=438823, domicilioMedidor=29 Septiembre 3500 R.Escalada, cliente=Cliente: idPersona=1, apellido=Perez, nombre=Ana, dni=11111111, nroCliente=111111]

precioCargoFijo=3226.0

limite=300

precioValle=2.26

precioPico=2.16

precioResto=2.061

Factura [fechaFactura=xxxxxxxx, nroCliente=xxxxxx, cliente=xxxxx, xxxxxxxx, nroMedidor=xxxxx

ItemFactura [detalle=Cargo fijo, cantidad=1, precio=xxxxxx, subtotal=xxxxxx],

ItemFactura [detalle=Cargo variable Pico, cantidad=xxxxxx, precio=xxxxxx, subtotal=xxxxxx],

ItemFactura [detalle=Cargo variable Resto, cantidad=xxxxxx, precio=xxxxxx, subtotal=xxxxxx],

ItemFactura [detalle=Cargo variable Valle, cantidad=xxxxxx, precio=xxxxxx, subtotal=xxxxxx]

Total a pagar=xxxxxx

*Gracias por interesarte en visitar este repositorio y leer acerca de él.*

**¡Saludos!**

**Maximiliano Calahorra.**
