package unla.proyectos.version2.entities;


import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;



@Entity
public class Vendedor extends Persona {
	
	@Column(name = "extra", nullable = true)
	private float extra;
	
	@Column(name = "horasPorJornada", nullable = true)
	private LocalTime horasPorJornada;
	
	@Column(name = "sueldoBasico", nullable = true)
	private float sueldoBasico;
	
	public Vendedor() {
		
	}

	

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



	public Vendedor(String nombre, String apellido, Date fechaDeNacimiento, long dni, float extra,
			LocalTime horasPorJornada, float sueldoBasico) {
		super(nombre, apellido, fechaDeNacimiento, dni);
		this.extra = extra;
		this.horasPorJornada = horasPorJornada;
		this.sueldoBasico = sueldoBasico;
	}
	
	
	
	
	
	
	
	
	
}
