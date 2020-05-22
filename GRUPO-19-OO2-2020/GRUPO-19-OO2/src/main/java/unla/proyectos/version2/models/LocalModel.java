package unla.proyectos.version2.models;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

public class LocalModel {

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
    private Set<PedidoModel> pedidos=new HashSet<PedidoModel>();

    public LocalModel(){}

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

	public LocalModel(long id, String localidad, String calle, int numero, long telefono, float latitud,
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
	
	public LocalModel(long id, String localidad, String calle, int numero, long telefono, float latitud,
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

	
	
	public LocalModel( String localidad, String calle, int numero, long telefono, float latitud,
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
	
	
	public LocalModel( long id, String localidad, String calle, int numero, long telefono, float latitud,
			float longitud) {
		super();
		this.id = id;
		this.localidad = localidad;
		this.calle = calle;
		this.numero = numero;
		this.telefono = telefono;
		this.latitud = latitud;
		this.longitud = longitud;
	
	
	}


	
	
   public double calcularDistancia(float lat, float lon) {
		
		float latitud1 = this.latitud;
		float longitud1= this.longitud;
		
		double radioTierra= 6371; //en kilometros
		double dlat=Math.toRadians(lat-latitud1);
		double dlng=Math.toRadians(lon-longitud1);
		double sindLat=Math.sin(dlat/2);
		double sindLng=Math.sin(dlng/2);
		double va1= Math.pow(sindLat, 2)+Math.pow(sindLng, 2)*Math.cos(Math.toRadians(latitud1))*Math.cos(Math.toRadians(lat));
		double va2=2*Math.atan2(Math.sqrt(va1), Math.sqrt(1-va1));
		
		double r = (radioTierra*va2);
		
		
		return Math.round(r*100.0/100.0);

	}

public Set<PedidoModel> getPedidos() {
	return pedidos;
}

public void setPedidos(Set<PedidoModel> pedidos) {
	this.pedidos = pedidos;
}

public LocalModel(long id, String localidad, String calle, int numero, long telefono, float latitud, float longitud,
		GerenteModel gerente, Set<VendedorModel> vendedores, Set<StockModel> stocks, Set<PedidoModel> pedidos) {
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
	this.pedidos = pedidos;
}

@Override
public String toString() {
	return "LocalModel [id=" + id + ", localidad=" + localidad + ", calle=" + calle + ", numero=" + numero
			+ ", telefono=" + telefono + ", latitud=" + latitud + ", longitud=" + longitud + ", gerente=" + gerente
			+ ", vendedores=" + vendedores + ", stocks=" + stocks + ", pedidos=" + pedidos + "]";
}
   
   
   

	
	
   
}
