package unla.proyectos.version2.services;

import java.util.List;

import unla.proyectos.version2.entities.Producto;
import unla.proyectos.version2.entities.Stock;
import unla.proyectos.version2.models.LocalModel;
import unla.proyectos.version2.models.PedidoModel;
import unla.proyectos.version2.models.ProductoModel;
import unla.proyectos.version2.models.StockModel;

public interface IStockService {

	public List<Stock> getAll();
	
	public StockModel findById(long id);
	
	public StockModel findByProducto(Producto producto);
	
	public StockModel insert(StockModel stockModel);
	
	public StockModel Update(StockModel stockModel);
	
	public boolean remove(long id);
	
	public int totalPorProducto(ProductoModel productoModel);
	
	public int totalPorProductoYLocal(ProductoModel productoModel, LocalModel localModel);
	
	public PedidoModel calculoDescripcionPedido(PedidoModel pedidoModel);
	
}