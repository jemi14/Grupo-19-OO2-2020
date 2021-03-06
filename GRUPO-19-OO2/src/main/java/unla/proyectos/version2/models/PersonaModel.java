package unla.proyectos.version2.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

public class PersonaModel {
	
	private long id;
	private String nombre;
	private String apellido;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaDeNacimiento;
	
	
	private Set<PedidoModel> pedidos=new HashSet<PedidoModel>();
	
	private long dni;
	
	public PersonaModel () {
		
	}
	
	public PersonaModel(long id, String nombre, String apellido, LocalDate fechaDeNacimiento, long dni) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.dni = dni;
	}
	
	
	public PersonaModel( String nombre, String apellido,LocalDate fechaDeNacimiento, long dni) {
		super();
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.dni = dni;
	}
	


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "PersonaModel [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaDeNacimiento="
				+ fechaDeNacimiento + ", dni=" + dni + "]";
	}

	public Set<PedidoModel> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<PedidoModel> pedidos) {
		this.pedidos = pedidos;
	}

	public PersonaModel(long id, String nombre, String apellido, LocalDate fechaDeNacimiento, Set<PedidoModel> pedidos,
			long dni) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.pedidos = pedidos;
		this.dni = dni;
	}
	
	
	
	
	
	
	
}
