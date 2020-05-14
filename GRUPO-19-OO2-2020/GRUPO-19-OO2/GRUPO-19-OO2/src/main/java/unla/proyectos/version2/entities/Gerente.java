package unla.proyectos.version2.entities;


import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Gerente extends Persona{
	
	@Column(name="legajo")
	private long legajo;
	
	
	@Column(name = "sueldoBasico", nullable = true)
	private float sueldoBasico;
	
	
	
	
	public Gerente() {
		
	}


	public long getLegajo() {
		return legajo;
	}

	public void setLegajo(long legajo) {
		this.legajo = legajo;
	}

	public Gerente(long legajo) {
		super();
		this.legajo = legajo;
	}


	public float getSueldoBasico() {
		return sueldoBasico;
	}


	public void setSueldoBasico(float sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}


	public Gerente(String nombre, String apellido, Date fechaDeNacimiento, long dni, long legajo, float sueldoBasico) {
		super(nombre, apellido, fechaDeNacimiento, dni);
		this.legajo = legajo;
		this.sueldoBasico = sueldoBasico;
	}
	
	
	
	
	
	
	
	
}
