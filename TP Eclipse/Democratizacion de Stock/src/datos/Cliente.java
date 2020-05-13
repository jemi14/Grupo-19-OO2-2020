package datos;

import java.time.LocalDate;

public class Cliente extends Persona{

	private long idCliente;
	private String mail;
	
	public Cliente() {
	}

	public Cliente(int idPersona, int dni, String nombre, String apellido, LocalDate fechaDeNacimiento, long idCliente, String mail
			 ) {
		super(idPersona, dni, nombre, apellido, fechaDeNacimiento);
		
		this.idCliente=idCliente;
		this.mail=mail;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", mail=" + mail + ", idPersona=" + idPersona + ", dni=" + dni
				+ ", nombre=" + nombre + ", apellido=" + apellido + ", fechaDeNacimiento=" + fechaDeNacimiento + "]";
	}

	
	
	

}