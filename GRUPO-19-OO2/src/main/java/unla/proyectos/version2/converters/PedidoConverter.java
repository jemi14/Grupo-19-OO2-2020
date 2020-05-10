package unla.proyectos.version2.converters;

import org.springframework.stereotype.Component;

import unla.proyectos.version2.entities.Pedido;
import unla.proyectos.version2.models.PedidoModel;



@Component("pedidoConverter")
public class PedidoConverter {

	public PedidoModel entityToModel(Pedido pedido) {
		
		return new PedidoModel(pedido.getId(), pedido.getCantidad(), pedido.getProducto());
	}
	
	public Pedido modelToEntity (PedidoModel pedidoModel) {
		
		return new Pedido(pedidoModel.getId(), pedidoModel.getCantidad(), pedidoModel.getProducto());
	}
	
	
}
