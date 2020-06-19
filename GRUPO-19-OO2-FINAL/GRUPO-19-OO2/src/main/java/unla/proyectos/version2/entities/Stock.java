package unla.proyectos.version2.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.LocalDate;

import javax.persistence.CascadeType;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="stock")
public class Stock{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Producto producto;
	
	@Column(name="cantidad")
	private int cantidad;
	

	
	@Column(name = "fechaIngreso")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaIngreso;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	// normalmente nullable es igual a false, en este caso se deja como true porque el ejemplo es simple
	@JoinColumn(name="local_id", nullable=true)
	private Local local;
	
	
	
	public Stock() {}

	public Stock(long id, Producto producto, int cantidad, LocalDate fechaIngreso) {
		this.id = id;
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

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
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

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Stock(long id, Producto producto, int cantidad, LocalDate fechaIngreso, Local local) {
		super();
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
		this.fechaIngreso = fechaIngreso;
		this.local = local;
	}
	
	
	public Stock( Producto producto, int cantidad, LocalDate fechaIngreso, Local local) {
		super();
	
		this.producto = producto;
		this.cantidad = cantidad;
		this.fechaIngreso = fechaIngreso;
		this.local = local;
	}
	
	
	
	
	
	
	

}
	