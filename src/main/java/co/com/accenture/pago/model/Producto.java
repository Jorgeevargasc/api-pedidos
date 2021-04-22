package co.com.accenture.pago.model;

public class Producto {
	private int id;
	private String producto;
	private int valorProducto;
	
	public Producto(int id, String producto, int valorProducto) {
		this.id = id;
		this.producto = producto;
		this.valorProducto = valorProducto;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public int getValorProducto() {
		return valorProducto;
	}
	public void setValorProducto(int valorProducto) {
		this.valorProducto = valorProducto;
	}
	
	
}
