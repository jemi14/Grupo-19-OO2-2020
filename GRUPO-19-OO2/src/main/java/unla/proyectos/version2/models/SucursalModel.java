package unla.proyectos.version2.models;

import unla.proyectos.version2.entities.Gerente;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

public class SucursalModel {

    private long id;
	private String localidad;
	private String calle;
	private int numero;
	private long telefono;
	private float latitud;
	private float longitud;
    private GerenteModel gerente;
    private Set<VendedorModel> vendedores=new HashSet<VendedorModel>();
    private Set<StockModel> stocks=new HashSet<StockModel>();

    public SucursalModel(){}

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

	public GerenteModel getGerente() {
		return gerente;
	}

	public void setGerente(GerenteModel gerente) {
		this.gerente = gerente;
	}

	public Set<VendedorModel> getVendedores() {
		return vendedores;
	}

	public void setVendedores(Set<VendedorModel> vendedores) {
		this.vendedores = vendedores;
	}

	public Set<StockModel> getStocks() {
		return stocks;
	}

	public void setStocks(Set<StockModel> stocks) {
		this.stocks = stocks;
	}

	public SucursalModel(long id, String localidad, String calle, int numero, long telefono, float latitud,
			float longitud, GerenteModel gerente, Set<VendedorModel> vendedores, Set<StockModel> stocks) {
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
	
	public SucursalModel(long id, String localidad, String calle, int numero, long telefono, float latitud,
			float longitud, GerenteModel gerente) {
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

	
	
	public SucursalModel( String localidad, String calle, int numero, long telefono, float latitud,
			float longitud, GerenteModel gerente) {
		super();
		
		this.localidad = localidad;
		this.calle = calle;
		this.numero = numero;
		this.telefono = telefono;
		this.latitud = latitud;
		this.longitud = longitud;
		this.gerente = gerente;
	
	}

	
	
   
}
