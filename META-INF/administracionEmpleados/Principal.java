package administracionEmpleados;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) 
	{
		Empresa lista = new Empresa( );
				
		Fecha f0 = new Fecha(24,05,2000);
		lista.agregarDirectivo(new Trabajador(36454234, "Juan", "Gomez",TipoCargo.DIRECTOR_DEPARTAMENTO, f0, "Licenciado en Administracion de Empresas", 200000 ));
		lista.imprimir();
		
		Fecha f1 = new Fecha(24,05,2000);		
		lista.agregarDirectivo(new Trabajador(12345678, "Mia", "Paez",TipoCargo.DIRECTOR_GENERAL, f1, "Licenciado en Administracion de Empresas", 250000 ));
		lista.imprimir();
	
		
		Scanner dato = new Scanner(System.in);
		
		boolean salir = false;
		
		int opcion;
		
		while(!salir)
		{
			System.out.println("MENU DE OPCIONES");
			System.out.println("================");
			
			System.out.println("01. Agregar Empleado");
			System.out.println("02. Agregar Directivo");
			System.out.println("03. Quitar Empleado");
			System.out.println("04. Quitar Directivo");
			System.out.println("05. Quitar Empleado por DNI");
			System.out.println("06. Quitar Directivo por DNI");
			System.out.println("07. Mostrar lista de trabajadores");
			System.out.println("08. Obtener trabajador");
			System.out.println("09. Liquidar sueldos");
			System.out.println("10. Monto total a pagar");
			System.out.println("11. Trabajador con el salario minimo");
			System.out.println("12. Trabajador con el salario maximo");
			System.out.println("13. Promedio de salarios");
			System.out.println("14. Trabajador mas antiguo");
			System.out.println("15. Trabajador mas reciente");
			System.out.println("16. Salir");
			System.out.println();
			
			try
			{
				System.out.print("Introduce un numero: ");
				opcion = dato.nextInt(); 
				
				long dni;
				String nombre, apellido, titulo = null; 
				TipoCargo cargo = null;
				String tienetitulo;
				int dia, mes, anio,num;
				double salario;				
				
				
				switch(opcion)
				{
				case 1:
					System.out.println("");
					System.out.println("ALTA DE UN EMPLEADO");
					System.out.print("Ingrese el Dni: ");
					dni = dato.nextLong();
					System.out.println("Ingrese el Nombre: ");
					nombre = dato.next();
					System.out.print("Ingrese el Apellido: ");
					apellido = dato.next();
					System.out.println(" MENU DE OPCION PARA ELEGIR EL CARGO");
					System.out.println("1. Jefe");
					System.out.println("2. Supervisor");
					System.out.println("3. Operario");
					System.out.print("Ingrese un numero: ");
					num = dato.nextInt();
					switch(num)
					{
					case 1: 
						cargo = TipoCargo.JEFES;
						break;
					case 2:
						cargo = TipoCargo.SUPERVISOR;
						break;
					case 3:
						cargo = TipoCargo.OPERARIO;
						break;
					default:
						System.out.println("Las opciones son entre 1 y 3");
					}
					System.out.println("Vamos a ingresar la fecha de ingreso");
					System.out.print("Ingrese el dia:");
					dia = dato.nextInt();
					System.out.print("Ingrese el mes:");
					mes = dato.nextInt();
					System.out.print("Ingrese el anio:");
					anio = dato.nextInt();

					System.out.print("풲iene Titulo Universitario? Ingrese si o no: ");
					tienetitulo = dato.next();
					switch (tienetitulo)
					{
					case "si" :
						System.out.print("Por favor ingrese su titulo: ");
						titulo = dato.next();
						break;
					case "no":
					titulo=null;
					break;
					default:
						System.out.println("Ingrese si o no");
					}
					System.out.print("Ingrese el Salario: ");
					salario = dato.nextDouble();
					Fecha fecha = new Fecha(dia,mes,anio);
					
					lista.agregarEmpleado(new Trabajador(dni, nombre, apellido, cargo, fecha, titulo, salario));
					System.out.println("Empleado agregado Correctamente");
					lista.imprimir();
					break;
					
				case 2:
					Trabajador eliminar;
					System.out.println();
					System.out.println("");
					System.out.println("ALTA DE UN DIRECTIVO");
					
					System.out.print("Ingrese el Dni: ");
					dni = dato.nextLong();
					System.out.println("Ingrese el Nombre: ");
					nombre = dato.next();
					System.out.println("Ingrese el Apellido: ");
					apellido = dato.next();
					System.out.println("INGRESE UNA OPCION PARA ELEGIR EL CARGO");
					System.out.println("1. Director General");
					System.out.println("2. Director De Departamento");
					System.out.print("Ingrese un numero: ");
					num = dato.nextInt();
					switch(num)
					{
					case 1: 
						cargo = TipoCargo.DIRECTOR_GENERAL;
						break;
					case 2:
						cargo = TipoCargo.DIRECTOR_DEPARTAMENTO;
						break;
					default:
						System.out.println("Las opciones son entre 1 y 2");
					}
					
					System.out.println("Vamos a ingresar la fecha de ingreso");
					System.out.print("Ingrese el dia:");
					dia = dato.nextInt();
					System.out.print("Ingrese el mes:");
					mes = dato.nextInt();
					System.out.print("Ingrese el anio:");
					anio = dato.nextInt();

					System.out.print("풲iene Titulo Universitario? Ingrese si o no:  ");
					tienetitulo = dato.next();
					switch (tienetitulo)
					{
					case "si" :
						System.out.println("Por favor ingrese su titulo: ");
						titulo = dato.next();
						break;
					case "no":
					titulo=null;
					}
					System.out.println("Ingrese Salario");
					salario = dato.nextDouble();
					
					Fecha fecha1 = new Fecha(dia,mes,anio);
					
					lista.agregarEmpleado(new Trabajador(dni, nombre, apellido, cargo, fecha1, titulo, salario));
					System.out.println("Empleado agregado Correctamente");
					lista.imprimir();
					break;
					
				case 3:
					System.out.println("BAJA DE EMPLEADO");
					
					
					System.out.print("Ingrese el Dni: ");
					dni = dato.nextLong();
					System.out.println("Ingrese el Nombre: ");
					nombre = dato.next();
					System.out.print("Ingrese el Apellido: ");
					apellido = dato.next();
					System.out.println(" MENU DE OPCION PARA ELEGIR EL CARGO");
					System.out.println("1. Jefe");
					System.out.println("2. Supervisor");
					System.out.println("3. Operario");
					System.out.print("Ingrese un numero: ");
					num = dato.nextInt();
					switch(num)
					{
					case 1: 
						cargo = TipoCargo.JEFES;
						break;
					case 2:
						cargo = TipoCargo.SUPERVISOR;
						break;
					case 3:
						cargo = TipoCargo.OPERARIO;
						break;
					default:
						System.out.println("Las opciones son entre 1 y 3");
					}
					System.out.println("Vamos a ingresar la fecha de ingreso");
					System.out.print("Ingrese el dia:");
					dia = dato.nextInt();
					System.out.print("Ingrese el mes:");
					mes = dato.nextInt();
					System.out.print("Ingrese el anio:");
					anio = dato.nextInt();

					System.out.print("풲iene Titulo Universitario? Ingrese si o no: ");
					tienetitulo = dato.next();
					switch (tienetitulo)
					{
					case "si" :
						System.out.print("Por favor ingrese su titulo: ");
						titulo = dato.next();
						break;
					case "no":
					titulo=null;
					break;
					default:
						System.out.println("Ingrese si o no");
					}
					System.out.print("Ingrese el Salario: ");
					salario = dato.nextDouble();
					
					Fecha f = new Fecha(dia,mes,anio);
					
					lista.quitarDirectivo(new Trabajador(dni, nombre, apellido, cargo, f, titulo, salario));
					
					lista.imprimir();
					
					break;
				case 4:
					System.out.println("BAJA DE DIRECTIVO");
					
					
					System.out.print("Ingrese el Dni: ");
					dni = dato.nextLong();
					System.out.println("Ingrese el Nombre: ");
					nombre = dato.next();
					System.out.print("Ingrese el Apellido: ");
					apellido = dato.next();
					System.out.println(" MENU DE OPCION PARA ELEGIR EL CARGO");
					System.out.println("1. Jefe");
					System.out.println("2. Supervisor");
					System.out.println("3. Operario");
					System.out.print("Ingrese un numero: ");
					num = dato.nextInt();
					switch(num)
					{
					case 1: 
						cargo = TipoCargo.DIRECTOR_GENERAL;
						break;
					case 2:
						cargo = TipoCargo.DIRECTOR_DEPARTAMENTO;
						break;
					default:
						System.out.println("Las opciones son entre 1 y 2");
					}
					
					System.out.println("Vamos a ingresar la fecha de ingreso");
					System.out.print("Ingrese el dia:");
					dia = dato.nextInt();
					System.out.print("Ingrese el mes:");
					mes = dato.nextInt();
					System.out.print("Ingrese el anio:");
					anio = dato.nextInt();

					System.out.print("풲iene Titulo Universitario? Ingrese si o no: ");
					tienetitulo = dato.next();
					switch (tienetitulo)
					{
					case "si" :
						System.out.print("Por favor ingrese su titulo: ");
						titulo = dato.next();
						break;
					case "no":
					titulo=null;
					break;
					default:
						System.out.println("Ingrese si o no");
					}
					System.out.print("Ingrese el Salario: ");
					salario = dato.nextDouble();
					
					Fecha f2 = new Fecha(dia,mes,anio);
					
					lista.quitarDirectivo(new Trabajador(dni, nombre, apellido, cargo, f2, titulo, salario));
					
					lista.imprimir();
				break;
				
				case 5:
					System.out.println("BAJA DE EMPLEADO POR DNI");
					
					
					System.out.println("Ingrese el DNI: ");
					dni = dato.nextLong();
					
					lista.quitarEmpleado(dni);
					lista.imprimir();
					break;
					
				case 6:
					System.out.println("BAJA DE DIRECTIVO POR DNI");
					
					
					System.out.println("Ingrese el DNI: ");
					dni = dato.nextLong();
					
					lista.quitarEmpleado(dni);
					lista.imprimir();
					break;
					
				case 7:
					System.out.println("LISTA DE TRABAJADORES");
					lista.imprimir();
					break;
					
				case 8:
					System.out.println("OBTENER TRABAJADOR POR DNI");
					
					System.out.println("Ingrese el DNI: ");
					dni = dato.nextLong();
			
					System.out.println(lista.obtenerTrabajador(dni));
					
					break;
					
				case 9:
					System.out.println("LIQUIDAR SUELDOS");
					
					lista.liquidarSueldos();
					break;
					
				case 10:
					System.out.println("MONTO TOTAL A PAGAR");
					
					lista.obtenerMontoTotalAPagar();
					lista.imprimir();
					break;
					
				case 11:
					System.out.println("SALARIO MINIMO");
			
					System.out.println(lista.obtenerTrabajadorSalarioMinimo());

					break;
					
				case 12:
					System.out.println("SALARIO MAXIMO");
					
					System.out.println(lista.obtenerTrabajadorSalarioMaximo());
					break;
					
				case 13:
					System.out.println();
					break;
					
				case 14:
					System.out.println();
					break;
					
				case 15:
					System.out.println();
					break;
				
				case 16:
					salir = true;
					break; 
				
					default:
						System.out.println("Las opciones son entre 1 y 14");
				}
				
				} catch(InputMismatchException  e)
			{
					System.out.println("Debes ingresar un numero");
					dato.next();
				
			}
		}
		
		System.out.println("Fin del menu");
	}

}
