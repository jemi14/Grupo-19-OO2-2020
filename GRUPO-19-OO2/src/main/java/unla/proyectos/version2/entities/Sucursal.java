package unla.proyectos.version2.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="sucursal")
public class Sucursal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="localidad", nullable=false, length=30)
	private String localidad;
	
	@Column(name="calle", nullable=false, length=30)
	private String calle;
	
	@Column(name="numero")
	private int numero;
	
	@Column(name="telefono")
	private long telefono;
	
	@Column(name="latitud")
	private float latitud;
	
	@Column(name="longitud")
	private float  longitud;

	/*
	asd@OneToOne(cascade = CascadeType.ALL)
	dasdas@JoinColumn(name = "gerenteId", referencedColumnName = "id")
	*/
	
	
	//@OneToOne(fetch = FetchType.LAZY)
	//@OneToOne(cascade = CascadeType.MERGE)
	
	//@OneToOne(cascade = CascadeType.ALL)
	//@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	//@JoinColumn(name = "gerente_id") 
	
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Gerente gerente;

	@OneToMany(fetch = FetchType.LAZY)
	private Set<Vendedor> vendedores = new HashSet<Vendedor>();

	
	@OneToMany(fetch = FetchType.LAZY)
	private Set<Stock> stocks = new HashSet<Stock>();;
	
	public Sucursal() {}

	@Override
	public String toString() {
		return "Sucursal [id=" + id + ", localidad=" + localidad + ", calle=" + calle + ", numero=" + numero
				+ ", telefono=" + telefono + ", latitud=" + latitud + ", longitud=" + longitud + ", gerente=" + gerente
				+ ", vendedores=" + vendedores + ", stocks=" + stocks + "]";
	}

	public Sucursal(long id, String localidad, String calle, int numero, long telefono, float latitud, float longitud,
			Gerente gerente, Set<Vendedor> vendedores, Set<Stock> stocks) {
		super();
		this.id = id;
		this.localidad = localidad;
		this.calle = calle;
		this.numero = numero;
		this.telefono = telefono;
		this.latitud = latitud;
		this.longitud = longitud;
		this.gerente = gerente;
		this.vendedores = vendedores;
		this.stocks = stocks;
	}
	
	public Sucursal(long id, String localidad, String calle, int numero, long telefono, float latitud, float longitud,
			Gerente gerente) {
		super();
		this.id = id;
		this.localidad = localidad;
		this.calle = calle;
		this.numero = numero;
		this.telefono = telefono;
		this.latitud = latitud;
		this.longitud = longitud;
		this.gerente = gerente;
	
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public Set<Vendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(Set<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}

	public Set<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}

	
}