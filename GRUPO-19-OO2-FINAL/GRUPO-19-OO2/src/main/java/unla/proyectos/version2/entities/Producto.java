package unla.proyectos.version2.entities;

import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	
	@Column(name="descripcion", length=100)
	private String descripcion;
	
	@Column(name="precioUnitario")
	private float precioUnitario;

	
	@Column(name="nombre", length=45)
	private String nombre;
	
	

	
	public Producto() {}

	public Producto(String descripcion, float precioUnitario, String nombre) {
		super();
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.nombre = nombre;
	}

	public Producto(Long id, String descripcion, float precioUnitario, String nombre) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}



	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	

	public Producto(long id, String descripcion, float precioUnitario, String nombre) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
	
		this.nombre = nombre;
	
	}


	
	
	
	

}
