package unla.proyectos.version2.services.implementation;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import unla.proyectos.version2.converters.PedidoConverter;
import unla.proyectos.version2.entities.Producto;
import unla.proyectos.version2.entities.Cliente;
import unla.proyectos.version2.entities.Pedido;
import unla.proyectos.version2.models.ProductoModel;
import unla.proyectos.version2.models.FechaBusqueda;
import unla.proyectos.version2.models.PedidoModel;
import unla.proyectos.version2.repositories.IPedidoRepository;
import unla.proyectos.version2.services.IPedidoService;





@Service("pedidoService")
public class PedidoService implements IPedidoService {

	@Autowired
	@Qualifier("pedidoRepository")
	private IPedidoRepository pedidoRepository;
	
	@Autowired
	@Qualifier("pedidoConverter")
	private PedidoConverter pedidoConverter;
	
	@Autowired
	@Qualifier("productoService")
	private ProductoService productoService;
	
	
	@Autowired
	@Qualifier("localService")
	private LocalService localService;
	
	@Autowired
	@Qualifier("clienteService")
	private ClienteService clienteService;

	
	@Override
	public List<Pedido> getAll() {
		return pedidoRepository.findAll();
	}
	
	

	@Override
	public List<Pedido> traerAceptados() {
		
		List<Pedido> aceptados = new ArrayList<Pedido>();
		
		
		for(Pedido p: getAll()) {
			
			if(p.isTomado()) {
				
				aceptados.add(p);
				
			}
			
		
		}
		
		
		return aceptados;
	}
	
	
	
	@Override
	public List<Pedido> traerCancelados() {
		
		List<Pedido> cancelados = new ArrayList<Pedido>();
		
		
		for(Pedido p: getAll()) {
			
			if(!p.isTomado()) {
				
				cancelados.add(p);
				
			}
			
		
		}
		
		
		return cancelados;
	}
	
	
	
	@Override
	public List<Pedido> traerEntreFechas(FechaBusqueda f) {
		
		List<Pedido> pedidos = new ArrayList<Pedido>();
		
		
		for(Pedido p: getAll()) {
			
			if(p.getFechaPedido().isAfter(f.getFechaDesde())&&p.getFechaPedido().isBefore(f.getFechaHasta())) {
				
				pedidos.add(p);
				
			}
			
		
		}
		
		
		return pedidos;
	}
	
	
	
	@Override
	public List<Pedido> traerEntreFechasLocal(FechaBusqueda f) {
		
		List<Pedido> pedidos = new ArrayList<Pedido>();
		
		
	
		
		
		for (Pedido p: traerEntreFechas(f)) {
			
			
			if(p.getLocal().getId()==f.getLocal().getId()) {
				
				pedidos.add(p);
			}
			
			
		}
		
		
		
		return pedidos;
	}
	
	
	@Override
	public List<Pedido> traerEntreFechasVendedor(FechaBusqueda f) {
		
		List<Pedido> pedidos = new ArrayList<Pedido>();
		
		
	
		
		
		for (Pedido p: traerEntreFechas(f)) {
			
			
			if(p.getVendedor().getId()==f.getVendedor().getId()) {
				
				pedidos.add(p);
			}
			
			
		}
		
		
		
		return pedidos;
	}
	
	

	@Override
	public PedidoModel insertOrUpdate(PedidoModel pedidoModel) {
		
		
		Pedido p = pedidoConverter.modelToEntity(pedidoModel);
		

		

		pedidoRepository.flush();
		Pedido pedido = pedidoRepository.save(p);
		
		
		return pedidoConverter.entityToModel(pedido);
	}
	
	@Override
	public PedidoModel Update(PedidoModel pedidoModel) {
		pedidoModel.setLocal(localService.findById(pedidoModel.getLocal().getId()));
		pedidoModel.setProducto(productoService.findById(pedidoModel.getProducto().getId()));
		pedidoModel.setCliente(clienteService.findByIdPersona(pedidoModel.getCliente().getId()));

		Pedido pedido = pedidoRepository.save(pedidoConverter.modelToEntity(pedidoModel));
		return pedidoConverter.entityToModel(pedido);
	}
	
	
	@Override
	public boolean remove(long id) {
		try {
			pedidoRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public PedidoModel findById(long id) {
		return pedidoConverter.entityToModel(pedidoRepository.findById(id));
	}

	//@Override
	//public PedidoModel findByCliente(Cliente cliente) {
	//	return pedidoConverter.entityToModel(pedidoRepository.findByCliente(cliente));
	//}
	
	
	

	
	
}