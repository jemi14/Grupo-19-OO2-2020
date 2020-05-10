package unla.proyectos.version2.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import unla.proyectos.version2.entities.Stock;
import unla.proyectos.version2.models.StockModel;


@Component("stockConverter")
public class StockConverter {

	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;
	
	public StockModel entityToModel(Stock stock) {
		return new StockModel(stock.getId(), productoConverter.entityToModel(stock.getProducto()), stock.getCantidad(), stock.getFechaIngreso());
	}

	public Stock modelToEntity(StockModel stockModel) {
		return new Stock(stockModel.getId(), productoConverter.modelToEntity(stockModel.getProducto()) , stockModel.getCantidad(), stockModel.getFechaIngreso());
	}
}