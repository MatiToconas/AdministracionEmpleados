package administracionEmpleados;

import java.util.Calendar;

public class Trabajador implements ITrabajador
{
	long dni;
	String nombre, apellido, titulo;
	TipoCargo cargo;
	Fecha fechaIngreso;
	double salario, premio;


  Trabajador(long dni, String nombre, String apellido, TipoCargo cargo, Fecha fechaIngreso, String titulo, double salario)
	{
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cargo = cargo;
		this.fechaIngreso = fechaIngreso;
		this.titulo = titulo;
		this.salario = salario;
		this.premio= 0;
	}


	@Override
public String toString() {
	return "Trabajador [DNI = " + dni + ", NOMBRE = " + nombre + ", APELLIDO =" + apellido + ", TITULO =" + titulo
			+ ", CARGO = " + cargo + ", FECHAINGRESO =" + fechaIngreso + ", SALARIO = " + salario + "]";
}


	@Override
	public boolean esEmpleado()
	{
		if (cargo == TipoCargo.JEFES || cargo == TipoCargo.OPERARIO || cargo == TipoCargo.SUPERVISOR )
		{
			return true;
		}
		
		else return false;
	}

	@Override
	public boolean esDirectivo() {
		if (cargo == TipoCargo.DIRECTOR_DEPARTAMENTO || cargo == TipoCargo.DIRECTOR_GENERAL)
		{
			return true;
		}
		else return false;
		
	}

	@Override
	public TipoCargo getCargo() {
		
		return cargo;
	}

	
	public int setMesesAntiguedad()
	{
		Calendar ingreso = Calendar.getInstance();
		ingreso.set(fechaIngreso.dia , fechaIngreso.mes -1, fechaIngreso.anio);
		
		Calendar actual = Calendar.getInstance();
		
		int anios_diferencia = Anios();
		
		int meses = Math.abs((anios_diferencia * 12) + (actual.get(Calendar.MONTH) - ingreso.get(Calendar.MONTH)));
		
		if (actual.get(Calendar.DATE) < fechaIngreso.dia)
		{
			meses--;
		}
		return meses;
	}
	
	public int Anios ()
	{
		Calendar ingreso = Calendar.getInstance();
		ingreso.set(fechaIngreso.dia, fechaIngreso.mes-1, fechaIngreso.anio);
		
		Calendar actual = Calendar.getInstance();
		
		int diferencia = actual.get(Calendar.YEAR) - ingreso.get(Calendar.YEAR);
		
		if (ingreso.get(Calendar.DAY_OF_YEAR) > actual.get(Calendar.DAY_OF_YEAR))
		{
			diferencia--;
		}
		
		return diferencia;
	}
	
	@Override
	public int getMesesAntiguedad() 
	{	
		
		return setMesesAntiguedad();
	}

	@Override
	public void setTituloUniversitario(String titulo) {
		
		this.titulo = titulo;
		
	}

	@Override
	public String getTituloUniversitario() {
		
		return titulo;
	}

	@Override
	public boolean tieneTituloUniversitario() {
		return titulo!=null;
	}

	@Override
	public void setTituloPostgrado(String titulo) throws ExcepcionOperacionNoPermitida 
	{
		if (cargo == TipoCargo.DIRECTOR_DEPARTAMENTO || cargo == TipoCargo.DIRECTOR_GENERAL)
		{
			this.titulo = titulo;
		}
		else throw new ExcepcionOperacionNoPermitida("Por favor elija un cargo directivo para agregar un titulo posgrado");
	}

	@Override
	public String getTituloPostgrado() {
		return titulo;
	}

	@Override
	public boolean tieneTituloPostgrado() {
		return titulo!=null;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public String getApellido() {
		return apellido;
	}

	@Override
	public long getDni() {
		return dni;
	}
	
	int cargoDirecto = 0, cargoIndirecto = 0;
	@Override
	public void agregarTrabajadorACargo(ITrabajador trabajador) throws ExcepcionOperacionNoPermitida 
	{
		
		if (cargo == TipoCargo.DIRECTOR_DEPARTAMENTO || cargo == TipoCargo.DIRECTOR_GENERAL)
		{
			if (trabajador.esEmpleado())
			{
			this.agregarTrabajadorACargo(trabajador);
			cargoIndirecto = cargoIndirecto+1;
			}
			else 
			{
				this.agregarTrabajadorACargo(trabajador);
				cargoDirecto = cargoDirecto+1;
			}
		}		
		else if (cargo == TipoCargo.JEFES || cargo == TipoCargo.SUPERVISOR)
		{
			this.agregarTrabajadorACargo(trabajador);
			cargoDirecto = cargoDirecto+1;
		}
		else throw new ExcepcionOperacionNoPermitida("Por favor elija un cargo directivo o empleado que no sea operario");
	}


	@Override
	public void setJefe(ITrabajador jefe) 
	{
	   this.setJefe(jefe);
		
	}

	@Override
	public void setSalario(double salario) 
	{
		this.salario = salario;
		
	}

	@Override
	public double getSalario() {
		return salario;
	}

	public void premio ()
	{
		if (esDirectivo() == true)
		{
			if (getMesesAntiguedad() >= 12)
			{	
				
				if (tieneTituloUniversitario() && tieneTituloPostgrado() && cargoDirecto>=1 && cargoIndirecto>=1 )
				{
					premio= 100000 + 15000 + 25000+(1000*cargoDirecto) + (500*cargoIndirecto);
				}
				else if (tieneTituloUniversitario() && tieneTituloPostgrado())
				{
					premio= 100000 + 15000 + 25000;
				}
				else if (tieneTituloUniversitario() && cargoDirecto>=1 && cargoIndirecto>=1)
				{
					premio = 100000 + 15000 + (1000*cargoDirecto) + (500*cargoIndirecto);
				}
				
				else premio = 100000 + (1000*cargoDirecto) + (500*cargoIndirecto);
			}
			
		     else 
				 {
					if (tieneTituloUniversitario() && tieneTituloPostgrado() && cargoDirecto>=1 && cargoIndirecto>=1)
					{
						premio= 50000 + 15000 + 25000 + (1000*cargoDirecto);
					}
					else if (tieneTituloUniversitario() && tieneTituloPostgrado())
					{
						premio= 50000 + 15000 + 25000;
					}
					else if (tieneTituloUniversitario() && cargoDirecto>=1 && cargoIndirecto>=1)
					{
						premio = 50000 +15000 + (1000*cargoDirecto) + (500*cargoIndirecto);
					}
				
						premio = 50000 + (1000*cargoDirecto) + (500*cargoIndirecto);
				 }
		}
		
		else {
				if  (cargo == TipoCargo.JEFES || cargo == TipoCargo.SUPERVISOR)
				{
					if (getMesesAntiguedad() >= 12)
					{	
						
						if (tieneTituloUniversitario() && cargoDirecto>=1)
						{
							premio = 60000 + 15000 + (1000*cargoDirecto);
						}
						
						else premio = 60000 + (1000*cargoDirecto);
					}
				}
				
				else 
				{
					if (tieneTituloUniversitario() && cargoDirecto>1)
					{
						premio = 30000 + 15000 + (1000*cargoDirecto);
					}
					
					else premio = 30000 + (1000*cargoDirecto);
				}
			 }
	}
	
	
	@Override
	public double getPremio() {
		return premio;
	}

	@Override
	public double getMontoACobrar() 
	{
		return salario + premio;
	}

	@Override
	public int getCantidadEmpleadosACargoDirecto() 
	{
		
		return cargoDirecto;
	}

	@Override
	public int getCantidadEmpleadosACargoTotal() 
	{
		
		return getCantidadEmpleadosACargoDirecto() + cargoIndirecto;
	}

}
