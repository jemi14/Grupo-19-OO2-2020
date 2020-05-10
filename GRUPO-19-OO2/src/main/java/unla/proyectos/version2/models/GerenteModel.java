package unla.proyectos.version2.models;

import java.time.LocalTime;
import java.util.Date;

public class GerenteModel extends PersonaModel{
	
	
	private long legajo;

	private float sueldoBasico;
	
	public GerenteModel() {
		
		
		
	}

	

	






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










	public GerenteModel( String nombre, String apellido, Date fechaDeNacimiento, long dni, long legajo, float sueldoBasico) {
		super(nombre, apellido, fechaDeNacimiento, dni);
		this.legajo = legajo;
	
		this.sueldoBasico = sueldoBasico;
	}










	public GerenteModel(long id, String nombre, String apellido, Date fechaDeNacimiento, long dni, long legajo,
			float sueldoBasico) {
		super(id, nombre, apellido, fechaDeNacimiento, dni);
		this.legajo = legajo;
		this.sueldoBasico = sueldoBasico;
	}
	
	
	
	
	
	
	
	
	
	
	
}
