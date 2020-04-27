package datos;
import datos.Producto;

public class Stock {
	
	private long idStock;
	private Producto producto;
	
	public Stock(long idStock, Producto producto) {

		this.idStock=idStock;
		this.producto=producto;
}

	public long getIdStock() {
		return idStock;
	}

	public void setIdStock(long idStock) {
		this.idStock = idStock;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Stock [idStock=" + idStock + ", producto=" + producto + "]";
	}
	

}
