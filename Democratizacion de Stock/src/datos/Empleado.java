package datos;
import java.time.LocalDate;
import java.util.List;

import datos.Factura;

import java.util.ArrayList;



public class Empleado extends Persona {

	private long idEmpleado;
	private String tipo;
	private LocalDate horarioDeTrabajo;
	private double sueldoBasico;
	private Locales local;	
	private List<Factura> lstFactura;

public Empleado(int idPersona, int dni, String nombre, String apellido, LocalDate fechaDeNacimiento, long idEmpleado, String tipo, LocalDate horarioDeTrabajo, double sueldoBasico, Locales local)
{
	
	super(idPersona, dni, nombre, apellido, fechaDeNacimiento);
	
	this.idEmpleado=idEmpleado;
	this.tipo=tipo;
	this.horarioDeTrabajo=horarioDeTrabajo;
	this.sueldoBasico=sueldoBasico;
	this.local=local;
	this.lstFactura = new ArrayList<Factura>();
}
	






public long getIdEmpleado() {
	return idEmpleado;
}

public void setIdEmpleado(long idEmpleado) {
	this.idEmpleado = idEmpleado;
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}

public LocalDate getHorarioDeTrabajo() {
	return horarioDeTrabajo;
}

public void setHorarioDeTrabajo(LocalDate horarioDeTrabajo) {
	this.horarioDeTrabajo = horarioDeTrabajo;
}

public double getSueldoBasico() {
	return sueldoBasico;
}

public void setSueldoBasico(double sueldoBasico) {
	this.sueldoBasico = sueldoBasico;
}

public Locales getLocal() {
	return local;
}

public void setLocal(Locales local) {
	this.local = local;
}

public List<Factura> getLstFactura() {
	return lstFactura;
}

public void setLstFactura(List<Factura> lstFactura) {
	this.lstFactura = lstFactura;
}







@Override
public String toString() {
	return "Empleado [idEmpleado=" + idEmpleado + ", tipo=" + tipo + ", horarioDeTrabajo=" + horarioDeTrabajo
			+ ", sueldoBasico=" + sueldoBasico + ", local=" + local + ", lstFactura=" + lstFactura + ", idPersona="
			+ idPersona + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaDeNacimiento="
			+ fechaDeNacimiento + "]";
}


}