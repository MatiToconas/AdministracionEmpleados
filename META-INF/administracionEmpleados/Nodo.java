package administracionEmpleados;

public class Nodo 
{
	private ITrabajador trabajador;
	 private Nodo siguiente;
	
	 public Nodo (ITrabajador trabajador, Nodo siguiente)
	 {
		 this.trabajador = trabajador;
		 this.siguiente = siguiente;
	 }
	
	public Nodo getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	public ITrabajador getTrabajador() {
		return trabajador;
	}
	public void setTrabajador(ITrabajador trabajador) {
		this.trabajador = trabajador;
	}
	

}
