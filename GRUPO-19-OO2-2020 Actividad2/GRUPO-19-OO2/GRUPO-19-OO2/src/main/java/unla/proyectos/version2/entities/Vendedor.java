package unla.proyectos.version2.entities;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Vendedor extends Persona {
	
	@Column(name = "extra", nullable = true)
	private float extra;
	
	@Column(name = "horasPorJornada", nullable = true)
	private LocalTime horasPorJornada;
	
	@Column(name = "sueldoBasico", nullable = true)
	private float sueldoBasico;
	
	@ManyToOne(fetch = FetchType.LAZY)
	// normalmente nullable es igual a false, en este caso se deja como true porque el ejemplo es simple
	@JoinColumn(name="local_id", nullable=true)
	private Local local;
	

	

	public float getExtra() {
		return extra;
	}

	public void setExtra(float extra) {
		this.extra = extra;
	}

	public LocalTime getHorasPorJornada() {
		return horasPorJornada;
	}

	public void setHorasPorJornada(LocalTime horasPorJornada) {
		this.horasPorJornada = horasPorJornada;
	}

	public float getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(float sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}

	public Vendedor(float extra, LocalTime horasPorJornada, float sueldoBasico) {
		super();
		this.extra = extra;
		this.horasPorJornada = horasPorJornada;
		this.sueldoBasico = sueldoBasico;
	}



	public Vendedor(String nombre, String apellido, LocalDate fechaDeNacimiento, long dni, float extra,
			LocalTime horasPorJornada, float sueldoBasico) {
		super(nombre, apellido, fechaDeNacimiento, dni);
		this.extra = extra;
		this.horasPorJornada = horasPorJornada;
		this.sueldoBasico = sueldoBasico;
	}
	
	public Vendedor() {
		super();
	
	}
	
	
	public Vendedor(long id, String nombre, String apellido, LocalDate fechaDeNacimiento, long dni, float extra,
			LocalTime horasPorJornada, float sueldoBasico) {
		super(id,nombre, apellido, fechaDeNacimiento, dni);
		this.extra = extra;
		this.horasPorJornada = horasPorJornada;
		this.sueldoBasico = sueldoBasico;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Vendedor(float extra, LocalTime horasPorJornada, float sueldoBasico, Local local) {
		super();
		this.extra = extra;
		this.horasPorJornada = horasPorJornada;
		this.sueldoBasico = sueldoBasico;
		this.local = local;
	}
	
	
	
	

	
	
	
	
	
	
}
