package unla.proyectos.version2.services.implementation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import unla.proyectos.version2.converters.PedidoConverter;
import unla.proyectos.version2.entities.Pedido;
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
	public PedidoModel insertOrUpdate(PedidoModel pedidoModel) {
		
		System.out.println(pedidoModel.getCantidad());
		System.out.println(pedidoModel.getProducto());
		System.out.println(pedidoModel.getLocal());
		System.out.println(pedidoModel.getCliente());
		System.out.println(pedidoModel.getCantidad());
		
		Pedido p = pedidoConverter.modelToEntity(pedidoModel);

		//System.out.println("-----" +p.getPersona().toString());

		pedidoRepository.flush();
		Pedido pedido = pedidoRepository.saveAndFlush(p);

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