package co.com.accenture.pago.model;

public class Cliente {
	
	private String idCliente;
	private String nombre;
	private String direccion;
	
	public Cliente(String idCliente, String nombre, String direccion) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
	


}
