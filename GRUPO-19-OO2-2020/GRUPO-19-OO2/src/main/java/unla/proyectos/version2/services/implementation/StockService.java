package unla.proyectos.version2.services.implementation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import unla.proyectos.version2.converters.StockConverter;
import unla.proyectos.version2.entities.Producto;
import unla.proyectos.version2.entities.Stock;
import unla.proyectos.version2.models.LocalModel;
import unla.proyectos.version2.models.PedidoModel;
import unla.proyectos.version2.models.ProductoModel;
import unla.proyectos.version2.models.StockModel;
import unla.proyectos.version2.repositories.IStockRepository;
import unla.proyectos.version2.services.IStockService;





@Service("stockService")
public class StockService implements IStockService {

	@Autowired
	@Qualifier("stockRepository")
	private IStockRepository stockRepository;
	
	@Autowired
	@Qualifier("stockConverter")
	private StockConverter stockConverter;
	
	@Autowired
	@Qualifier("productoService")
	private ProductoService productoService;
	
	
	@Autowired
	@Qualifier("localService")
	private LocalService localService;

	
	@Override
	public List<Stock> getAll() {
		return stockRepository.findAll();
	}

	@Override
	public StockModel insert(StockModel stockModel) {

		Stock stock = stockRepository.save(stockConverter.modelToEntity(stockModel));
		return stockConverter.entityToModel(stock);
	}
	
	@Override
	public StockModel Update(StockModel stockModel) {
		stockModel.setLocal(localService.findById(stockModel.getLocal().getId()));
		stockModel.setProducto(productoService.findById(stockModel.getProducto().getId()));
		Stock stock = stockRepository.save(stockConverter.modelToEntity(stockModel));
		return stockConverter.entityToModel(stock);
	}
	
	
	@Override
	public boolean remove(long id) {
		try {
			stockRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public StockModel findById(long id) {
		return stockConverter.entityToModel(stockRepository.findById(id));
	}

	@Override
	public StockModel findByProducto(Producto producto) {
		return stockConverter.entityToModel(stockRepository.findByProducto(producto));
	}
	
	
	
	public int totalPorProducto(ProductoModel productoModel) {
		
		
		int cantidad = 0; 
		
		for (Stock stock: getAll()) {
			
			if(stock.getProducto().getNombre().equals(productoModel.getNombre())) {
				cantidad = cantidad + stock.getCantidad();
			}
			
		}
		
		return cantidad;
	}
	
	
	
	public int totalPorProductoYLocal(ProductoModel productoModel, LocalModel localModel) {
		
		
		int cantidad = 0; 
		
		for (Stock stock: getAll()) {
			
			if(stock.getProducto().getNombre().equals(productoModel.getNombre())&&
					stock.getLocal().getId()==(localModel.getId())) {
				
				cantidad = cantidad + stock.getCantidad();
				
			}
			
		}
		
		return cantidad;
	}
	
	
	public PedidoModel calculoDescripcionPedido(PedidoModel pedidoModel) {
		
		PedidoModel p = pedidoModel;
		int cantidad = 0; 
		
		
		//Si se pidio mas de lo que teniamos
		if(p.getCantidad()>totalPorProducto(p.getProducto())) {
			
			p.setDescripcion( "Usted desea mas productos de los que tenemos. Cuando tengamos stock nos "
					+ "comunicaremos para que usted confire si sigue interesado en la compra.");
			
		}else { //Si lo pedido es menor a lo que tenemos
			
			
			//Si nos alcanza lo que hay en la sucursal seleccionada
			
			if(pedidoModel.getCantidad()<=totalPorProductoYLocal(p.getProducto(), p.getLocal())) {
				
				p.setDescripcion("Contamos con su pedido en la sucursal elegida, pronto estara disponible su pedido. Se realizara la entrega en los proximos 7 días.");
				p.setFechaEntrega(p.getFechaPedido().plusDays(7));
				
				
				
				
			}else //Si necesitamos de mas Sucursales
			{
				p.setDescripcion("En esa sucursal no contamos con tantos productos, pero se los haremos llegar desde las sucursales mas proximas, lamentamos si hay alguna demora.");
				p.setFechaEntrega(p.getFechaPedido().plusDays(15));
				
			}
			
			
		}
		
		
		
		
		return p;
	}
	
	
	
	
}