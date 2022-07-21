package administracionEmpleados;

import java.util.InputMismatchException;
import java.util.Scanner;

//import administracionEmpleados.Trabajador;

public class Empresa implements IEmpresa 
{
	Scanner teclado = new Scanner (System.in);
	
	Nodo primero;
	Nodo ultimo;
	
	public Empresa()
	{
		primero = null;
		ultimo = null;
	}

	
	public boolean estaVacia()
	{
		return primero == null;
	}
	
	public void imprimir() 
	{
		if (estaVacia())
		{
			System.out.println("La lista esta vacia. Por favor ingrese trabajadores para poder verlos en la lista");
		}
		else 
		{
		
			Nodo n = this.primero;
			System.out.println("");
			System.out.println("             LISTA DE TRABAJADORES      ");
			System.out.println("*****************************************************");
			while (n != null)
			{
				System.out.println(n.getTrabajador() + " ");
				n = n.getSiguiente();
			}
			System.out.println("");
			System.out.println("*****************************************************");
		}
	}
	
	

	@Override
	public void agregarEmpleado(ITrabajador trabajador) 
	{
		Nodo actual;
		 if (estaVacia())
		 {
			 actual = new Nodo(trabajador, null );
			 primero = actual;
			 ultimo = actual;
			 
		 }
		 else 
		 {
			 actual = new Nodo(trabajador,null);
			 ultimo.setSiguiente(actual);
			 ultimo = actual;
		 }
		
	}

	
	@Override
	public void agregarDirectivo(ITrabajador trabajador) 
	{

		Nodo actual;
		
		 if (estaVacia())
		 {
			 actual = new Nodo(trabajador, null );
			 primero = actual;
			 ultimo = actual;
			 
		 }
		 else 
		 {
			 actual = new Nodo(trabajador,null);
			 ultimo.setSiguiente(actual);
			 ultimo = actual;
		 }
		
	}

	@Override
	public void quitarEmpleado(ITrabajador trabajador) 
	{
		if (estaVacia())
		 {
			System.out.println("La lista esta vacia");
			 
		 }
		 else 
		 {
				 if (primero == ultimo && trabajador == primero.getTrabajador())
				 {
					 primero = ultimo = null;
				 }
				 
				 else if (trabajador == primero)
				 {
					 primero = primero.getSiguiente();
				 }
				 
				 else
				 {
					 Nodo aux,anterior;
					 anterior = primero;
					 aux = primero.getSiguiente();
					 
					 while (aux != null && aux.getTrabajador() != trabajador)
					 {
						 anterior = anterior.getSiguiente();
						 aux = aux.getSiguiente();
					 }
					 
					 if(aux != null)
					 {
						 anterior.setSiguiente(aux.getSiguiente());
						 if (aux == ultimo)
						 {
							ultimo = anterior; 
						 }
					 }
				 }
		}
	}



	@Override
	public void quitarDirectivo(ITrabajador trabajador) 
	{
		if (estaVacia())
		 {
			System.out.println("La lista esta vacia");
			 
		 }
		 else 
		 {
				 if (primero == ultimo && trabajador == primero.getTrabajador())
				 {
					 primero = ultimo = null;
				 }
				 
				 else if (trabajador == primero)
				 {
					 primero = primero.getSiguiente();
				 }
				 
				 else
				 {
					 Nodo aux,anterior;
					 anterior = primero;
					 aux = primero.getSiguiente();
					 
					 while (aux != null && aux.getTrabajador() != trabajador)
					 {
						 anterior = anterior.getSiguiente();
						 aux = aux.getSiguiente();
					 }
					 
					 if(aux != null)
					 {
						 anterior.setSiguiente(aux.getSiguiente());
						 if (aux == ultimo)
						 {
							ultimo = anterior; 
						 }
					 }
				 }
		}
	}

	@Override
	public void quitarEmpleado(long dni) 
	{
		if (estaVacia())
		 {
			System.out.println("La lista esta vacia");
			 
		 }
		 else 
		 {
				 if (primero == ultimo && dni == primero.getTrabajador().getDni())
				 {
					 primero = ultimo = null;
				 }
				 
				 else if (dni == primero.getTrabajador().getDni())
				 {
					 primero = primero.getSiguiente();
				 }
				 
				 else
				 {
					 Nodo aux,anterior;
					 anterior = primero;
					 aux = primero.getSiguiente();
					 
					 while (aux != null && aux.getTrabajador().getDni()!= dni)
					 {
						 anterior = anterior.getSiguiente();
						 aux = aux.getSiguiente();
					 }
					 
					 if(aux != null)
					 {
						 anterior.setSiguiente(aux.getSiguiente());
						 if (aux == ultimo)
						 {
							ultimo = anterior; 
						 }
					 }
				 }
		}
		
		
	}

	@Override
	public void quitarDirectivo(long dni) 
	{
		if (estaVacia())
		 {
			System.out.println("La lista esta vacia");
			 
		 }
		 else 
		 {
				 if (primero == ultimo && dni == primero.getTrabajador().getDni())
				 {
					 primero = ultimo = null;
				 }
				 
				 else if (dni == primero.getTrabajador().getDni())
				 {
					 primero = primero.getSiguiente();
				 }
				 
				 else
				 {
					 Nodo aux,anterior;
					 anterior = primero;
					 aux = primero.getSiguiente();
					 
					 while (aux != null && aux.getTrabajador().getDni()!= dni)
					 {
						 anterior = anterior.getSiguiente();
						 aux = aux.getSiguiente();
					 }
					 
					 if(aux != null)
					 {
						 anterior.setSiguiente(aux.getSiguiente());
						 if (aux == ultimo)
						 {
							ultimo = anterior; 
						 }
					 }
				 }
		}
		
	}
	
	
	public void modificar (double salario)

	{
		Nodo actual = new Nodo();
		actual = primero;
		
		while (actual != null)
		{
			if (actual.getTrabajador().getSalario() == salario)
			{
				System.out.print("Ingrese el nuevo valor para salario: ");
				actual.getTrabajador().setSalario(teclado.nextInt());
			}
			actual = actual.getSiguiente();
		}
	}

	@Override
	public ITrabajador obtenerTrabajador(long dni) 
	{
		Nodo actual = primero;
		
		while ((actual != null) && actual.getTrabajador().getDni() != dni)
		{
			actual = actual.getSiguiente();
		}
		System.out.print("El trabajador buscado es: ");
		return actual.getTrabajador();
	}

	double total;
	@Override
	public void liquidarSueldos() 
	{
		Trabajador liquidar = null;
		total = liquidar.getSalario() +liquidar.getPremio();
		
	}

	@Override
	public double obtenerMontoTotalAPagar() 
	{
		return total;
	}

	@Override
	public ITrabajador obtenerTrabajadorSalarioMinimo() 
	{
		
		if (estaVacia())
		 {
			System.out.println("La lista esta vacia");
			 
		 }
		
			Nodo minimo = primero;
			
			while (minimo  != null)
			{
				if (minimo .getTrabajador().getSalario() > minimo .getSiguiente().getTrabajador().getSalario())
				{
					minimo  = minimo .getSiguiente();
				}
				return minimo .getTrabajador();
			}
		
			return  minimo .getTrabajador();
	}

	@Override
	public ITrabajador obtenerTrabajadorSalarioMaximo() 
	{
		Nodo maximo = primero;
		while (maximo != null)
		{
			if (maximo.getTrabajador().getSalario() < maximo.getSiguiente().getTrabajador().getSalario())
			{
				maximo = maximo.getSiguiente();
			}
			return maximo.getTrabajador();
		}
	
		return  maximo.getTrabajador();
	}
	
	public int largo()
	{
		int list = 0;
		Nodo n = this.primero;
		while (n != null)
		{
			list++;
			n = n.getSiguiente();
		}
		
		return list;
	}

	public double suma ()
	{
		Nodo aux;
		if (estaVacia())
		{
			return 0;
		}
		else
			
		aux = primero;
		double suma=0;
		while(aux!=null) 
		{
			suma = suma + aux.getTrabajador().getSalario();
			aux = aux.getSiguiente();
		}
		return suma;
	}
	@Override
	public double obtenerPromedioSalarios() 
	{
		if(estaVacia()) 
		{
			return 0;
		}
		
		else
		{
			double resultado= suma() / (double) largo();
			return resultado;
		}
		
	}

	@Override
	public ITrabajador obtenerTrabajadorMasAntiguo() 
	{
		Nodo maximo = primero;
		while (maximo != null)
		{
			if (maximo.getTrabajador().getMesesAntiguedad() > maximo.getSiguiente().getTrabajador().getMesesAntiguedad())
			{
				maximo = maximo.getSiguiente();
			}
			return maximo.getTrabajador();
		}
	
		return  maximo.getTrabajador();

	}

	@Override
	public ITrabajador obtenerTrabajadorMasReciente() 
	{
		Nodo minimo = primero;
		while (minimo != null)
		{
			if (minimo.getTrabajador().getMesesAntiguedad() < minimo.getSiguiente().getTrabajador().getMesesAntiguedad())
			{
				minimo = minimo.getSiguiente();
			}
			return minimo.getTrabajador();
		}
	
		return  minimo.getTrabajador();
	}
	
	public void menu()
	{
		Empresa lista = new Empresa( );
		
		Fecha f0 = new Fecha(23,06,2019);
		lista.agregarDirectivo(new Trabajador(36454234, "Juan", "Gomez",TipoCargo.DIRECTOR_DEPARTAMENTO, f0, "Licenciado en Administracion de Empresas", 32 ));
		lista.imprimir();
		
		Fecha f1 = new Fecha(24,05,2020);		
		lista.agregarDirectivo(new Trabajador(12345678, "Mia", "Paez",TipoCargo.JEFES, f1, "Licenciado en Administracion de Empresas", 48 ));
		lista.imprimir();
	
		
		Scanner dato = new Scanner(System.in);
		
		boolean salir = false;
		
		int opcion;
		
		while(!salir)
		{
			System.out.println("");
			System.out.println("MENU DE OPCIONES");
			System.out.println("================");
			
			System.out.println("01. Agregar Empleado");
			System.out.println("02. Agregar Directivo");
			System.out.println("03. Quitar Empleado");
			System.out.println("04. Quitar Directivo");
			System.out.println("05. Quitar Empleado por DNI");
			System.out.println("06. Quitar Directivo por DNI");
			System.out.println("07. Obtener trabajador");
			System.out.println("08. Monto total a pagar");
			System.out.println("09. Trabjador con el salario minimo");
			System.out.println("10. Trabajador con el salario maximo");
			System.out.println("11. Promedio de salarios");
			System.out.println("12. Trabajador mas antiguo");
			System.out.println("13. Trabajador mas reciente");
			System.out.println("14. Modificar salario");
			System.out.println("15. Mostrar lista de trabajadores");
			System.out.println("16. Salir");
			System.out.println();
			
			try
			{
				System.out.print("Introduce un numero: ");
				opcion = dato.nextInt(); 
				
				long dni = 0;
				String nombre, apellido, titulo = null; 
				TipoCargo cargo = null;
				String tienetitulo;
				int dia = 0, mes = 0, anio = 0,num;
				double salario = 0;				
				
				
				switch(opcion) {
				
				case 1:
					
					System.out.println("\nALTA DE UN EMPLEADO");
					
					
					long ban;
					do {		
					try {
						
						ban=0;
						
					System.out.print("Ingrese DNI:");
					dni = dato.nextLong();
				
					}catch(InputMismatchException a) {
						System.out.println("CARACTER NO VALIDO! POR FAVOR REINGRESE SOLO NUMEROS");
						
						ban=1;
						dato.next();
					}	
					}while(ban !=0);
					
					
					
					
					System.out.print("Ingrese Nombre:");
					 nombre =dato.next();
					
					
					System.out.print("Ingrese Apellido:");
					apellido=dato.next();
					System.out.println("\nIngrese el tipo de cargo");
					System.out.println("1. Jefe");
					System.out.println("2. Supervisor");
					System.out.println("3. Operario");
					System.out.print("\nIngrese un numero: ");
					num= dato.nextInt();
					
					switch(num) {
					
					case 1:	cargo = TipoCargo.JEFES; 
					break;
					case 2: cargo = TipoCargo.SUPERVISOR; 
					break;
					case 3: cargo = TipoCargo.OPERARIO; 
					break;
					default: System.out.println("¡OPCION INCORRECTA!");
					
					}
					
					
					
					int ban1;
					do {			
					try {
						
						ban1=0;
				
					System.out.println("Vamos a ingresar la fecha de ingreso:");
					System.out.print("Ingrese dia: ");
					dia = dato.nextInt();
				
					}catch(InputMismatchException a) {
						System.out.println("CARACTER NO VALIDO! POR FAVOR REINGRESE SOLO NUMEROS");
						
						ban1=1;
						dato.next();
					}	
					
					}while(ban1 !=0);
					
					
					
					int ban2;
					do {		
					try {
						
						ban2=0;
				
					System.out.print("Ingrese mes: ");
					mes = dato.nextInt();
				
					}catch(InputMismatchException a) {
						System.out.println("CARACTER NO VALIDO! POR FAVOR REINGRESE SOLO NUMEROS");
						
						ban2=1;
						dato.next();
					}	
					
					}while(ban2 !=0);
					
					
					
					int ban3;
					do {		
					try {
						
						ban3=0;
			
					System.out.print("Ingrese año: ");
					anio = dato.nextInt();
				
					}catch(InputMismatchException a) {
						System.out.println("CARACTER NO VALIDO! POR FAVOR REINGRESE SOLO NUMEROS");
						
						ban3=1;
						dato.next();
					}	
					
					}while(ban3 !=0);
				
				
					
					System.out.print("¿Tiene titulo universitario? Ingrese SI o NO: ");
					tienetitulo = dato.next();
					
					switch(tienetitulo) {
				
					case "si":
						System.out.print("Por favor ingrese su titulo: ");
						titulo = dato.next(); break;
					case "no":
						titulo=null; break;
						default:
							System.out.println("Ingrese si o no: ");
					}
					
					
					
					double ban4;
					do {
					try {
						
						ban4=0;
						
					System.out.print("Ingrese salario: ");
					salario = dato.nextDouble();
					
					}catch (InputMismatchException ae) {
						System.out.println("CARACTER NO VALIDO! POR FAVOR REINGRESE SOLO NUMEROS");
						
						ban4=1;
					dato.next();
					}
					
					}while (ban4 !=0);
					
					
					
					Fecha fecha = new Fecha(dia, mes, anio);
					lista.agregarEmpleado(new Trabajador (dni, nombre, apellido, cargo, fecha, titulo, salario));
					System.out.println("\n¡EMPLEADO AGREGADO CORRECTAMENTE!\n");
					break;
					
				case 2:
					System.out.println();
					System.out.println("");
					System.out.println("ALTA DE UN DIRECTIVO");
					
					long aux;
					do {		
					
					try {
						
						aux=0;
						
					System.out.print("Ingrese DNI:");
					dni = dato.nextLong();
				
					}catch(InputMismatchException a) {
						System.out.println("CARACTER NO VALIDO! POR FAVOR REINGRESE SOLO NUMEROS");
						
						aux=1;
						dato.next();
					}	
					
					}while(aux !=0);
					
					
					
					System.out.print("Ingrese el Nombre: ");
					nombre = dato.next();
					System.out.print("Ingrese el Apellido: ");
					apellido = dato.next();
					System.out.println("\nINGRESE UNA OPCION PARA ELEGIR EL CARGO");
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
						System.out.println("Las opciones son entre 1 y 2 ");
					}
					
					System.out.println("Vamos a ingresar la fecha de ingreso");
					
					
					int aux1;
					do {		
					
					try {
						
						aux1=0;
						
					System.out.print("Ingrese dia:");
					dia = dato.nextInt();
				
					}catch(InputMismatchException a) {
						System.out.println("CARACTER NO VALIDO! POR FAVOR REINGRESE SOLO NUMEROS");
						
						aux1=1;
						dato.next();
					}	
					
					}while(aux1 !=0);
					
					
					
					int aux2;
					do {		
					
					try {
						
						aux2=0;
						
					System.out.print("Ingrese mes:");
					mes = dato.nextInt();
				
					}catch(InputMismatchException a) {
						System.out.println("CARACTER NO VALIDO! POR FAVOR REINGRESE SOLO NUMEROS");
						
						aux2=1;
						dato.next();
					}	
					
					}while(aux2 !=0);
					
					
					
					int aux3;
					do {		
					
					try {
						
						aux3=0;
						
					System.out.print("Ingrese año:");
					anio = dato.nextInt();
				
					}catch(InputMismatchException a) {
						System.out.println("CARACTER NO VALIDO! POR FAVOR REINGRESE SOLO NUMEROS");
						
						aux3=1;
						dato.next();
					}	
					
					}while(aux3 !=0);
					
					
					System.out.print("¿Tiene Titulo Universitario? Ingrese SI o NO:  ");
					tienetitulo = dato.next();
					switch (tienetitulo)
					{
					case "si" :
						System.out.print("Por favor ingrese su titulo: ");
						titulo = dato.next();
						break;
					case "no":
					titulo=null;
					}
					
					
					double aux4;
					do {		
					try {
						
						aux4=0;
						
					System.out.print("Ingrese salario:");
					salario = dato.nextDouble();
				
					}catch(InputMismatchException a) {
						System.out.println("CARACTER NO VALIDO! POR FAVOR REINGRESE SOLO NUMEROS");
						
						aux4=1;
						dato.next();
					}	
					}while(aux4 !=0);
										
					Fecha fecha1 = new Fecha(dia,mes,anio);
					
					lista.agregarEmpleado(new Trabajador(dni, nombre, apellido, cargo, fecha1, titulo, salario));
					System.out.println("\n¡¡DIRECTIVO AGREGADO CORRECTAMENTE!!\n");
					System.out.println("");
					break;
					
				case 3:
					System.out.println("BAJA DE EMPLEADO");
					Trabajador eliminar;
					
					System.out.print("Ingrese el Dni: ");
					dni = dato.nextLong();
					System.out.print("Ingrese el Nombre: ");
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

					System.out.print("¿Tiene Titulo Universitario? Ingrese si o no: ");
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
					eliminar = new Trabajador(dni, nombre, apellido, cargo, f, titulo, salario);
					lista.quitarEmpleado(eliminar);
					System.out.println("¡¡EMPLEADO ELIMINADO CORRECTAMENTE!!");
					System.out.println("");
					break;
				case 4:
					System.out.println("BAJA DE DIRECTIVO");
					System.out.println("");
				break;
				
				case 5:
					System.out.println("BAJA DE EMPLEADO POR DNI");
					
					System.out.print("Ingrese el Dni: ");
					dni = dato.nextLong();
					lista.quitarEmpleado(dni);
					System.out.println("\n¡¡EMPLEADO ELIMINADO CORRECTAMENTE!!\n");
					System.out.println("");
					break;
					
				case 6:
					System.out.println("BAJA DE DIRECTIVO POR DNI");
					System.out.print("Ingrese el Dni: ");
					dni = dato.nextLong();
					lista.quitarDirectivo(dni);
					System.out.println("\n¡¡EMPLEADO ELIMINADO CORRECTAMENTE!!\n");
					System.out.println("");
					break;
					
				case 7:
					try {
						
						System.out.println("\nBUSCAR TRABAJADOR");
						System.out.print("Ingrese dni:");
						dni = dato.nextLong();
						
						System.out.println("El trabajador buscado es: " +lista.obtenerTrabajador(dni));
						
						}
						catch(NullPointerException a){
							
							System.out.println("\n¡DNI NO ENCONTRADO!\n");
						}
					System.out.println("");
						break;
					
				case 8:
					System.out.println("MONTO TOTAL A PAGAR");
					System.out.println(lista.obtenerMontoTotalAPagar());
					System.out.println("");
					break;
					
				case 9:
					System.out.println("TRABAJADOR CON SALARIO MINIMO");
					System.out.println(lista.obtenerTrabajadorSalarioMinimo());
					System.out.println("");
					break;
					
				case 10:
					System.out.println("TRABAJADOR CON SALARIO MAXIMO");
					System.out.println(lista.obtenerTrabajadorSalarioMaximo());
					System.out.println("");
					break;
					
				case 11:
					System.out.print("PROMEDIO DE SALARIOS: ");
					System.out.println(lista.obtenerPromedioSalarios());
					System.out.println("");
					break;
					
				case 12:
					System.out.println("TRABAJADOR MAS ANTIGUO");
					System.out.println(lista.obtenerTrabajadorMasAntiguo());
					System.out.println("");
					break;
					
				case 13:
					System.out.println("TRABAJADOR MAS RECIENTE");
					System.out.println(lista.obtenerTrabajadorMasReciente());
					System.out.println("");
					break;
					
				case 14:
					System.out.println("MODIFICAR SALARIO");
					System.out.print("Ingrese el salario a modificar: ");
					salario =dato.nextDouble();
					lista.modificar(salario);
					System.out.println("\n ¡¡SALARIO MODIFICADO CORRECTAMENTE!!\\n");
					break;
					
				case 15:
			
						lista.imprimir();
						System.out.println("");
						break;
					
				case 16:
					salir = true;
					break; 
				
					default:
						System.out.println("Las opciones son entre 1 y 16");
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
