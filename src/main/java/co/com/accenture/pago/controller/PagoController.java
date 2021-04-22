package co.com.accenture.pago.controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.accenture.pago.facturacion.Facturacion;
import co.com.accenture.pago.model.Cliente;
import co.com.accenture.pago.model.Pedido;
import co.com.accenture.pago.model.Producto;

@RestController
@RequestMapping("/pedidos")
public class PagoController {

	Facturacion facturacion = new Facturacion();
	Producto p1 = new Producto(1, "Producto 1", 30000);
	Producto p2 = new Producto(2, "Producto 2", 40000);
	List<Producto> listaProductos = new ArrayList<>();
	Cliente cliente = new Cliente("12345", "Jorge Vargas", "11# 14-08");
	List<Cliente> listaClientes = new ArrayList<>();
	List<Pedido> listaPedidos = new ArrayList<>();
	LocalDateTime fechaPedido;
	
	@GetMapping()
	public List<Pedido> listarPedidos() {
		return listaPedidos;
	}

	@GetMapping("/productos")
	public List<Producto> listarProductos() {
		return listaProductos;
	}
	
	@GetMapping("/clientes")
	public List<Cliente> listarClientes(){
		return listaClientes;
	}

	@PostMapping
	public void realizarPedido(@RequestBody Pedido pedido) {
		listaProductos.add(p1);
		listaProductos.add(p2);
		pedido.setFechaPedido(fechaPedido.now());
		calcularPedido(pedido);
		listaPedidos.add(pedido);
		System.out.println("Insertado");
	}

	@PutMapping
	public void editarPedido(@RequestBody Pedido pedido) {
		pedido.setFechaPedido(fechaPedido.now());		
		for (Pedido p:listaPedidos) {
			if (pedido.getIdPedido() == p.getIdPedido()) {
				calcularPedido(pedido);
				if ((pedido.getValorPedido() >= p.getValorPedido()) && (ChronoUnit.HOURS
						.between(p.getFechaPedido(), pedido.getFechaPedido()) < 20)) {
					p.setIdProducto(pedido.getIdProducto());
					p.setCantidad(pedido.getCantidad());
					p.setValorPedido(pedido.getValorPedido());
					p.setValorTotal(pedido.getValorTotal());
				}
				break;
			}			
		}
	}

	@DeleteMapping
	public void eliminarPedido(@RequestBody Pedido pedido) {
		pedido.setFechaPedido(fechaPedido.now());
		for(Pedido p:listaPedidos){
			if(pedido.getIdPedido()==p.getIdPedido()) {
				if(ChronoUnit.HOURS.between(p.getFechaPedido(), pedido.getFechaPedido())<=12) {
					listaPedidos.remove(p);
					break;					
				} else if(ChronoUnit.HOURS.between(p.getFechaPedido(), pedido.getFechaPedido())>12) {
					p.setEstado("cancelado");
					p.setValorTotal(p.getValorTotal()*0.1);
				}
				break;
			}
		}
	}

	public void calcularPedido(Pedido pedido) {
		for(Producto p:listaProductos){			
			if(pedido.getIdProducto()==p.getId()) {
				pedido.setValorPedido(facturacion.calcularValorPedido(p.getValorProducto(), pedido.getCantidad()));
				pedido.setValorTotal(facturacion.calcularValorTotal(pedido.getValorPedido()));
				pedido.setEstado("activo");
				}
			break;
			}		
		}
}
