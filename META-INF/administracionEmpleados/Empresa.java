package administracionEmpleados;
//import administracionEmpleados.Trabajador;

public class Empresa implements IEmpresa 
{
	
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
		Nodo n = this.primero;
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
		Nodo actual, anterior;
		boolean encontrado;
		actual = primero;
		anterior = null;
		encontrado = false;
		while((actual != null) && (!encontrado))
		{
			encontrado = (actual.getTrabajador() == trabajador);
			if (!encontrado)
			{
				anterior = actual;
				actual = actual.getSiguiente();
			}
		}
		
		if (actual != null)
		{
			if (actual == primero)
			{
				primero = actual.getSiguiente();
			}
			else 
			{
				anterior.setSiguiente(actual.getSiguiente());
			}
			actual = null;
		}
	}

	
	
	@Override
	public void quitarDirectivo(ITrabajador trabajador) 
	{
		Nodo actual, anterior;
		boolean encontrado;
		actual = primero;
		anterior = null;
		encontrado = false;
		while((actual != null) && (!encontrado))
		{
			encontrado = (actual.getTrabajador() == trabajador);
			if (!encontrado)
			{
				anterior = actual;
				actual = actual.getSiguiente();
			}
		}
		
		if (actual != null)
		{
			if (actual == primero)
			{
				primero = actual.getSiguiente();
			}
			else 
			{
				anterior.setSiguiente(actual.getSiguiente());
			}
			actual = null;
		}
		
	}

	@Override
	public void quitarEmpleado(long dni) 
	{
		Nodo actual, anterior;
		boolean encontrado;
		actual = primero;
		anterior = null;
		encontrado = false;
		while((actual != null) && (!encontrado))
		{
			encontrado = (actual.getTrabajador().getDni() == dni);
			if (!encontrado)
			{
				anterior = actual;
				actual = actual.getSiguiente();
			}
		}
		
		if (actual != null)
		{
			if (actual == primero)
			{
				primero = actual.getSiguiente();
			}
			else 
			{
				anterior.setSiguiente(actual.getSiguiente());
			}
			actual = null;
		}
		
		
	}

	@Override
	public void quitarDirectivo(long dni) 
	{
		Nodo actual, anterior;
		boolean encontrado;
		actual = primero;
		anterior = null;
		encontrado = false;
		while((actual != null) && (!encontrado))
		{
			encontrado = (actual.getTrabajador().getDni() == dni);
			if (!encontrado)
			{
				anterior = actual;
				actual = actual.getSiguiente();
			}
		}
		
		if (actual != null)
		{
			if (actual == primero)
			{
				primero = actual.getSiguiente();
			}
			else 
			{
				anterior.setSiguiente(actual.getSiguiente());
			}
			actual = null;
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
		return actual.getTrabajador();
	}

	double total;
	@Override
	public void liquidarSueldos() 
	{
		Trabajador liquidar = new Trabajador(0, null, null, null, null, null, 0 );
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
		Nodo aux = primero;
		double minimo = primero.getTrabajador().getSalario();
		while (aux != null)
		{
			if (aux.getTrabajador().getSalario() < aux.getSiguiente().getTrabajador().getSalario())
			{
				minimo = aux.getSiguiente().getTrabajador().getSalario();
			}
			return aux.getTrabajador();
		}
	
		return aux.getTrabajador();
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
	
		return maximo.getTrabajador();
	}

	@Override
	public double obtenerPromedioSalarios() 
	{
		
		return 0;
	}

	@Override
	public ITrabajador obtenerTrabajadorMasAntiguo() 
	{
		
		return null;
	}

	@Override
	public ITrabajador obtenerTrabajadorMasReciente() 
	{
		
		return null;
	}

}
