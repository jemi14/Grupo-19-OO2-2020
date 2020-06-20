package unla.proyectos.version2.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import unla.proyectos.version2.entities.Persona;
import unla.proyectos.version2.entities.Pedido;
import unla.proyectos.version2.models.PersonaModel;
import unla.proyectos.version2.models.PedidoModel;



@Component("pedidoConverter")
public class PedidoConverter {
	
	
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;
	
	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;
	
	@Autowired
	@Qualifier("clienteConverter")
	private ClienteConverter clienteConverter;
	

	
	 public PedidoModel entityToModel(Pedido pedido){
	        return new PedidoModel(pedido.getId(), productoConverter.entityToModel(pedido.getProducto()),localConverter.entityToModel(pedido.getLocal()),clienteConverter.entityToModel(pedido.getCliente()),
	        		 pedido.getCantidad(), pedido.getFechaPedido(), pedido.getFechaEntrega(), pedido.isPagado(), pedido.isEntregado() , pedido.getDescripcion());
	    }

	    public Pedido modelToEntity(PedidoModel pedidoModel){
	        return new Pedido(pedidoModel.getId(), productoConverter.modelToEntity(pedidoModel.getProducto()),localConverter.modelToEntity(pedidoModel.getLocal()), clienteConverter.modelToEntity(pedidoModel.getCliente()), 
	        		  pedidoModel.getCantidad(), pedidoModel.getFechaPedido(), pedidoModel.getFechaEntrega(), pedidoModel.isPagado(), pedidoModel.isEntregado(), pedidoModel.getDescripcion());
	    }
	
	

}
