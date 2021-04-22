package co.com.accenture.pago.model;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Pedido {
	
	private int idPedido;
	private int idCliente;
	private int idProducto;
	private int cantidad;
	private double valorPedido;
	private double valorTotal;
	private String estado;
	private LocalDateTime fechaPedido;
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getValorPedido() {
		return valorPedido;
	}
	public void setValorPedido(double valorPedido) {
		this.valorPedido = valorPedido;
	}	
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public LocalDateTime getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(LocalDateTime fechaPedido) {
		this.fechaPedido = fechaPedido;
	}


	
	
	
	
	
	
	


	
	
	
	
}
