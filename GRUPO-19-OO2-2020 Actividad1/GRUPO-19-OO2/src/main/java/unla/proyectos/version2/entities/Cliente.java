package unla.proyectos.version2.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cliente extends Persona{
	
	@Column(name = "mail", length = 30, nullable = true)
	private String mail;
	
	

	public Cliente(String nombre, String apellido,LocalDate fechaDeNacimiento, long dni, String mail) {
		super(nombre, apellido, fechaDeNacimiento, dni);
		this.mail = mail;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public Cliente() {
		super();
		
	}
	
	
	public Cliente( String mail) {
		super();
		this.mail = mail;
	}
	
	
	
}
