package unla.proyectos.version2.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



@Entity
@Inheritance(strategy = InheritanceType.JOINED) //See more in https://www.baeldung.com/hibernate-inheritance
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPersona;
	
	@Column(name="nombre", nullable=false, length=30)
	private String nombre;
	
	@Column(name="apellido", nullable=false, length=30)
	private String apellido;
	
	
	private LocalDate fechaDeNacimiento;
	
	@Column(name="dni")
	private long dni;
	
	

	

	
			
	public Persona() {}

	public Persona(String nombre, String apellido, LocalDate fechaDeNacimiento, long dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.dni = dni;
	}

	public long getId() {
		return idPersona;
	}

	protected void setId(long id) {
		this.idPersona = id;
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

	public Persona(long id, String nombre, String apellido, LocalDate fechaDeNacimiento, long dni) {
		super();
		this.idPersona = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.dni = dni;
	}

	public long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}


	
	

	
	
	
	
	
	
	
	
	

}
