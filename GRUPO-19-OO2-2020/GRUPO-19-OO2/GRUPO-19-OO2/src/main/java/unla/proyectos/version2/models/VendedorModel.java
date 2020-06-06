package unla.proyectos.version2.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class VendedorModel extends PersonaModel{
	
	private float extra;
	private LocalTime horasPorJornada;
	private float sueldoBasico;
	private LocalModel local;
	
	public VendedorModel(long id, String nombre, String apellido, LocalDate fechaDeNacimiento, long dni, float extra,
			LocalTime horasPorJornada, float sueldoBasico) {
		super(id, nombre, apellido, fechaDeNacimiento, dni);
		this.extra = extra;
		this.horasPorJornada = horasPorJornada;
		this.sueldoBasico = sueldoBasico;
	}
	
	public VendedorModel( String nombre, String apellido, LocalDate fechaDeNacimiento, long dni, float extra,
			LocalTime horasPorJornada, float sueldoBasico) {
		super( nombre, apellido, fechaDeNacimiento, dni);
		this.extra = extra;
		this.horasPorJornada = horasPorJornada;
		this.sueldoBasico = sueldoBasico;
	}
	
	public VendedorModel(  float extra,
			LocalTime horasPorJornada, float sueldoBasico) {
		super( );
		this.extra = extra;
		this.horasPorJornada = horasPorJornada;
		this.sueldoBasico = sueldoBasico;
	}
	
	public VendedorModel(  ) {
		super( );
	
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

	public LocalModel getLocal() {
		return local;
	}

	public void setLocal(LocalModel local) {
		this.local = local;
	}

	public VendedorModel(float extra, LocalTime horasPorJornada, float sueldoBasico, LocalModel local) {
		super();
		this.extra = extra;
		this.horasPorJornada = horasPorJornada;
		this.sueldoBasico = sueldoBasico;
		this.local = local;
	}
}
