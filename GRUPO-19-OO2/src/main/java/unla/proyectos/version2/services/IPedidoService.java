package unla.proyectos.version2.services;
import java.util.List;

import unla.proyectos.version2.entities.Pedido;
import unla.proyectos.version2.models.PedidoModel;





public interface IPedidoService {
	
	 public List<Pedido> getAll();
	   
	    public PedidoModel findById(long id);
	    public PedidoModel findByCantidad(int cantidad);
	    public PedidoModel insert(PedidoModel pedidoModel);
	    public PedidoModel update(PedidoModel pedidoModel);
	    public boolean remove(long id);

}
