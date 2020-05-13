package datos;
import java.time.LocalDate;
import datos.Lote;
import datos.Stock;


import java.util.ArrayList;
import java.util.List;


public class Producto {
	
	private long idProducto;
	private String descripcion;
	private double precioUnitario;
	private LocalDate fechaAlta;
	private Lote lote;
	private List<Stock> lstStock;
	private List<Producto> lstProductos;
	
	public Producto(long idProducto, String descripcion, double precioUnitario, LocalDate fechaAlta, Lote lote) {
		
		this.idProducto=idProducto;
		this.descripcion=descripcion;
		this.precioUnitario=precioUnitario;
		this.fechaAlta=fechaAlta;
		this.lote=lote;
		this.lstStock = new ArrayList<Stock>();
		this.lstProductos = new ArrayList<Producto>();
		
		
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public List<Stock> getLstStock() {
		return lstStock;
	}

	public void setLstStock(List<Stock> lstStock) {
		this.lstStock = lstStock;
	}

	public List<Producto> getLstProductos() {
		return lstProductos;
	}

	public void setLstProductos(List<Producto> lstProductos) {
		this.lstProductos = lstProductos;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", descripcion=" + descripcion + ", precioUnitario="
				+ precioUnitario + ", fechaAlta=" + fechaAlta + ", lote=" + lote + ", lstStock=" + lstStock
				+ ", lstProductos=" + lstProductos + "]";
	}

	
}
