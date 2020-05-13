package unla.proyectos.version2.services;

import java.util.List;

import unla.proyectos.version2.entities.Producto;
import unla.proyectos.version2.entities.Stock;
import unla.proyectos.version2.models.StockModel;



public interface IStockService {

	public List<Stock> getAll();
	
	public StockModel findById(long id);
	
	public StockModel findByProducto(Producto producto);
	
	public StockModel insert(StockModel stockModel);
	
	public StockModel Update(StockModel stockModel);
	
	public boolean remove(long id);
	
}