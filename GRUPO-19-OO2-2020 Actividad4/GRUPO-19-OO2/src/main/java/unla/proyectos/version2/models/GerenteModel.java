package unla.proyectos.version2.models;

import java.time.LocalDate;

public class GerenteModel extends PersonaModel{
	
	private long legajo;
	private float sueldoBasico;
	LocalModel local;

	public long getLegajo() {
		return legajo;
	}

	public void setLegajo(long legajo) {
		this.legajo = legajo;
	}

	public float getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(float sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}

	public GerenteModel( String nombre, String apellido, LocalDate fechaDeNacimiento, long dni,  float sueldoBasico) {
		super(nombre, apellido, fechaDeNacimiento, dni);
		this.legajo = super.getDni();
	
		this.sueldoBasico = sueldoBasico;
	}

	public GerenteModel(long id, String nombre, String apellido, LocalDate fechaDeNacimiento, long dni, 
			float sueldoBasico) {
		super(id, nombre, apellido, fechaDeNacimiento, dni);
		this.legajo = super.getDni();
		this.sueldoBasico = sueldoBasico;
	}

	public GerenteModel() {
		super();
	}

	public GerenteModel(
			float sueldoBasico) {
		super();
		this.legajo = super.getDni();
		this.sueldoBasico = sueldoBasico;
	}

	public LocalModel getLocal() {
		return local;
	}

	public void setLocal(LocalModel local) {
		this.local = local;
	}

	public GerenteModel(long legajo, float sueldoBasico, LocalModel local) {
		super();
		this.legajo = legajo;
		this.sueldoBasico = sueldoBasico;
		this.local = local;
	}

	@Override
	public String toString() {
		return super.getId() +"<-----GerenteModel [legajo=" + legajo + ", sueldoBasico=" + sueldoBasico + ", local=" + local + "]";
	}	
}
