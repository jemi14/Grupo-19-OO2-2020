package unla.proyectos.version2.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ClienteModel extends PersonaModel{
	private String mail;
	
    private Set<PedidoModel> pedidos=new HashSet<PedidoModel>();
	
	public ClienteModel(long id, String nombre, String apellido,LocalDate  fechaDeNacimiento, long dni, String mail) {
		super(id, nombre, apellido, fechaDeNacimiento, dni);
		this.mail = mail;
	}
	
	public ClienteModel( String nombre, String apellido, LocalDate fechaDeNacimiento, long dni, String mail) {
		super( nombre, apellido, fechaDeNacimiento, dni);
		this.mail = mail;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	public ClienteModel( String mail) {
		super();
		this.mail = mail;
	}
	
	public ClienteModel( ) {
		super();
		;
	}

	@Override
	public String toString() {
		return "ClienteModel [mail=" + mail + "]";
	}

	public Set<PedidoModel> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<PedidoModel> pedidos) {
		this.pedidos = pedidos;
	}
}
