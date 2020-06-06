package unla.proyectos.version2.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Gerente extends Persona{
	
	@Column(name="legajo")
	private long legajo;
	
	@Column(name = "sueldoBasico", nullable = true)
	private float sueldoBasico;
	
	@OneToOne(mappedBy = "gerente") //si tenes una tabla gerente
	private Local local;
	
	
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

	public Gerente(String nombre, String apellido, LocalDate fechaDeNacimiento, long dni, float sueldoBasico) {
		super(nombre, apellido, fechaDeNacimiento, dni);
		this.legajo = super.getDni();
		this.sueldoBasico = sueldoBasico;
	}
	
	public Gerente(long id, String nombre, String apellido, LocalDate fechaDeNacimiento, long dni, float sueldoBasico) {
		super(id, nombre, apellido, fechaDeNacimiento, dni);
		this.legajo = super.getDni();
		this.sueldoBasico = sueldoBasico;
	}
	
	public Gerente() {
		super();
	}
	
	public Gerente( float sueldoBasico) {
		super();
		this.legajo =super.getDni();
		this.sueldoBasico = sueldoBasico;
	}

	public Gerente( float sueldoBasico, Local local) {
		super();
		this.legajo = super.getDni();
		this.sueldoBasico = sueldoBasico;
		this.local = local;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}	
}
