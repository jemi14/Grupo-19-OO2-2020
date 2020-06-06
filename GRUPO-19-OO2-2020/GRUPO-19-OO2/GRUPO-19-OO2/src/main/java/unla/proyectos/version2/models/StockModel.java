package unla.proyectos.version2.models;

import java.time.LocalDate;

public class StockModel {

	private long id;
	private ProductoModel producto;
	private LocalModel local;
	private int cantidad;
	private LocalDate fechaIngreso;

	public StockModel() {}

	public StockModel(long id, ProductoModel producto, int cantidad, LocalDate fechaIngreso) {
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
		this.fechaIngreso = fechaIngreso;
	}
	
	public StockModel( ProductoModel producto, int cantidad, LocalDate fechaIngreso) {
		
		this.producto = producto;
		this.cantidad = cantidad;
		this.fechaIngreso = fechaIngreso;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ProductoModel getProducto() {
		return producto;
	}

	public void setProducto(ProductoModel producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public StockModel(long id, ProductoModel producto, LocalModel local, int cantidad, LocalDate fechaIngreso) {
		super();
		this.id = id;
		this.producto = producto;
		this.local = local;
		this.cantidad = cantidad;
		this.fechaIngreso = fechaIngreso;
	}
	
	public StockModel(long id, ProductoModel producto, int cantidad, LocalDate fechaIngreso, LocalModel local) {
		super();
		this.id = id;
		this.producto = producto;
		this.local = local;
		this.cantidad = cantidad;
		this.fechaIngreso = fechaIngreso;
	}
		
	public StockModel(ProductoModel producto, LocalModel local, int cantidad, LocalDate fechaIngreso) {
		super();	
		this.producto = producto;
		this.local = local;
		this.cantidad = cantidad;
		this.fechaIngreso = fechaIngreso;
	}

	public LocalModel getLocal() {
		return local;
	}

	public void setLocal(LocalModel local) {
		this.local = local;
	}

	@Override
	public String toString() {
		return "StockModel [id=" + id + ", producto=" + producto + ", local=" + local + ", cantidad=" + cantidad
				+ ", fechaIngreso=" + fechaIngreso + "]";
	}
}
