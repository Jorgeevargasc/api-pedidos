package co.com.accenture.pago.facturacion;

import java.util.Date;

import co.com.accenture.pago.model.Producto;

public class Facturacion {
	
	private static final int valorEnvio=5000;
	
	public double calcularValorTotal(double valorPedido) {
		double valorTotal = valorPedido;
		double iva=0.19;
		iva*=valorTotal;
		if(valorTotal<=100000) {
			valorTotal+=valorEnvio;
		}		
		if(valorTotal>70000) {
			valorTotal+=iva;			
		}
		return valorTotal;
	}
	
	public double calcularValorPedido(int valorProducto, int cantidad) {
		double valorPedido = 0;
		valorPedido = valorProducto*cantidad;
		return valorPedido;
	}

}
