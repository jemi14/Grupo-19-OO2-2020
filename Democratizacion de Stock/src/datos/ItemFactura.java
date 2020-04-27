package datos;
import datos.Factura;
import datos.Producto;

public class ItemFactura {

	private long idItemFactura;
	private Factura factura;
	private Producto producto;
	
	
	public ItemFactura(long idItemFactura, Factura factura, Producto producto) {
		
		this.idItemFactura=idItemFactura;
		this.factura=factura;
		this.producto=producto;	
		
		
		
	}


	public long getIdItemFactura() {
		return idItemFactura;
	}


	public void setIdItemFactura(long idItemFactura) {
		this.idItemFactura = idItemFactura;
	}


	public Factura getFactura() {
		return factura;
	}


	public void setFactura(Factura factura) {
		this.factura = factura;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	@Override
	public String toString() {
		return "ItemFactura [idItemFactura=" + idItemFactura + ", factura=" + factura + ", producto=" + producto + "]";
	}
	
	
}
