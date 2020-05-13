package unla.proyectos.version2.models;

import java.time.LocalTime;
import java.util.Date;

public class VendedorModel extends PersonaModel{
	
	
	public VendedorModel(long id, String nombre, String apellido, Date fechaDeNacimiento, long dni, float extra,
			LocalTime horasPorJornada, float sueldoBasico) {
		super(id, nombre, apellido, fechaDeNacimiento, dni);
		this.extra = extra;
		this.horasPorJornada = horasPorJornada;
		this.sueldoBasico = sueldoBasico;
	}
	

	public VendedorModel( String nombre, String apellido, Date fechaDeNacimiento, long dni, float extra,
			LocalTime horasPorJornada, float sueldoBasico) {
		super( nombre, apellido, fechaDeNacimiento, dni);
		this.extra = extra;
		this.horasPorJornada = horasPorJornada;
		this.sueldoBasico = sueldoBasico;
	}



	private float extra;
	private LocalTime horasPorJornada;
	private float sueldoBasico;
	
	
	public VendedorModel() {
		
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



	public VendedorModel(float extra, LocalTime horasPorJornada, float sueldoBasico) {
		super();
		this.extra = extra;
		this.horasPorJornada = horasPorJornada;
		this.sueldoBasico = sueldoBasico;
	}



	
	
	
	
	
}
