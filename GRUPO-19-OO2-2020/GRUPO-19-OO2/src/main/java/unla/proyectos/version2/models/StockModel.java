package unla.proyectos.version2.models;

import java.time.LocalDate;


public class StockModel {

	private long id;
	
	private ProductoModel producto;

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

	@Override
	public String toString() {
		return "StockModel [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", fechaIngreso="
				+ fechaIngreso + "]";
	}
	
	
	

}
