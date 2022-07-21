package administracionEmpleados;

public class Fecha 
{
	//ATRIBUTOS
		int dia;
		int mes;
		int anio;
		
		//CONSTRUCTOR
		public Fecha (int dia ,int mes, int anio)
		{
			this.dia = dia;
			this.mes = mes;
			this.anio = anio;
		}

		@Override
		public String toString() {
			return " [" + dia + "/" + mes + "/" + anio + "]";
		}
}
