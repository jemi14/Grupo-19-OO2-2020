package unla.proyectos.version2.services.implementation;
import java.util.ArrayList;
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
	
		
		
		//Si se pidio mas de lo que teniamos
		if(p.getCantidad()>totalPorProducto(p.getProducto())) {
			
			p.setDescripcion( "Usted desea mas productos de los que tenemos. Cuando tengamos stock nos "
					+ "comunicaremos para que usted confirme si sigue interesado en la compra.");
			
			//solo en este caso no tomo el pedido.
			p.setTomado(false);
			
		}
		
		
		else { //Si lo pedido es menor a lo que tenemos
			
			
			//Si nos alcanza lo que hay en la sucursal seleccionada
			
			if(pedidoModel.getCantidad()<=totalPorProductoYLocal(p.getProducto(), p.getLocal())) {
				
				p.setDescripcion("Contamos con su pedido en la sucursal elegida, pronto estara disponible su pedido. Se realizara la entrega en los proximos 7 días.");
				p.setFechaEntrega(p.getFechaPedido().plusDays(7));
				p.setTomado(true);
				
				
				
				//Resta cantidades a los stocks "LOTES" de la sucursal.
				reservarStock(stockPorLocalYProducto(pedidoModel.getLocal(),pedidoModel.getProducto()), pedidoModel.getCantidad());	
				
				
				
				
			}
			
			
			
			
			
			
			else //Si necesitamos de mas Sucursales
			{
				p.setDescripcion("En esa sucursal no contamos con tantos productos,usaremos las sucursales mas proximas. Productos llegando de las sucursales: ");
				p.setFechaEntrega(p.getFechaPedido().plusDays(15));
				p.setTomado(true);
				
				
				//Hago lo mismo pero la cantidad de veces que necesite, avanzando siempre a la
				//Sucursal mas cercana
			
				
				ArrayList<StockModel> lista = stockPorLocalYProducto(pedidoModel.getLocal(),pedidoModel.getProducto());
				int cantidadAReservar = pedidoModel.getCantidad();
				
				while(cantidadAReservar>0) {
					
					
					p.setDescripcion(p.getDescripcion() +lista.get(0).getLocal().getLocalidad() +"- ");
					
					System.out.print("Entre al WHILE y me faltan: " +cantidadAReservar);
					
					for (StockModel s: lista) {
					System.out.print("Busco en: " +s.toString());
					}
					
					cantidadAReservar = reservarStock(lista, cantidadAReservar);
				
				//Si no ha terminado, lo hago con otro local
				if(cantidadAReservar>0) {
					
					//Busco el local mas cercano
					LocalModel localCercano = localService.localMasCercano(lista.get(0).getLocal(),pedidoModel.getProducto(), this );
					lista = stockPorLocalYProducto(localCercano, lista.get(0).getProducto());
					
					
					
				}
				
				}//cierra el while
				
				
				
			}
			
			
		}
		
		
		
		
		return p;
	}
	
	
	
	public ArrayList<StockModel> stockPorLocal(LocalModel localModel){
		
		
		ArrayList<StockModel> stocks =  new ArrayList<StockModel>();
		
		
		for(Stock s: getAll()) {
			
			
			if(s.getLocal().getLocalidad().equals(localModel.getLocalidad())) {
				
				
				stocks.add(stockConverter.entityToModel(s));
				
			}
			
		}
		
		
		
		
		return stocks;
		
	}
	
	
	
	public ArrayList<StockModel> stockPorLocalYProducto(LocalModel localModel, ProductoModel productoModel){
		
		
		ArrayList<StockModel> stocks =  new ArrayList<StockModel>();
		
		stocks = stockPorLocal(localModel);
		
		
		ArrayList<StockModel> stocksRetorno =  new ArrayList<StockModel>();
		
		
		for(StockModel s: stocks) {
			
			if(s.getProducto().getNombre()==productoModel.getNombre()) {
				
				
				stocksRetorno.add(s);
				
			}
			
			
		}
		
		

		
		return stocksRetorno;
		
	}
	
	
	
	
	
	public int reservarStock(ArrayList<StockModel> stocks, int cantidad) {
		
		
	
		
		int restaReservar = cantidad;
		
		int elementosLista = stocks.size();
		int cantidadRecorrida = 0 ; 
		
		System.out.println("La lista tiene: ----> " +elementosLista);
		
		while(restaReservar > 0  &&  cantidadRecorrida<elementosLista) {
			
			
			for(StockModel s: stocks) {
				
				
				//Si alcanza lo que hay en el stock s
				if(s.getCantidad()>=restaReservar) {
					
					s.setCantidad(s.getCantidad()-restaReservar);
					
					System.out.println("Este stock tengo que updatear" +s);
					restaReservar = 0; 
					
					Update(s);
					
					cantidadRecorrida++;
					
				}
				
				
				
				//Si ese stock no alcanza
				
				//Si alcanza lo que hay en el stock s
				if(s.getCantidad()<restaReservar) {
					restaReservar = restaReservar -s.getCantidad();
					s.setCantidad(0);
					
					System.out.println("Este stock tengo que updatear" +s);
					
					
					Update(s);
					
					
					cantidadRecorrida++;
					
				}
				
				
				
			}
			
			
		}//Cierra el while
		
		
		
		
		return restaReservar;
	}//cierra el void
	
	
	
	
	
}