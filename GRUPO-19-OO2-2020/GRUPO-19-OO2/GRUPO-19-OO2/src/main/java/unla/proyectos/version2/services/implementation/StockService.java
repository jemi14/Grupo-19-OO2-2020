package unla.proyectos.version2.services.implementation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import unla.proyectos.version2.converters.StockConverter;
import unla.proyectos.version2.entities.Producto;
import unla.proyectos.version2.entities.Stock;
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
	
}