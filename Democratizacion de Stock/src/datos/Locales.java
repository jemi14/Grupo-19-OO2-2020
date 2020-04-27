package datos;
import datos.Empleado;
import java.util.List;
import java.util.ArrayList;

public class Locales {

	private long idLocales;
	private String direccion;
	private float latitud;
	private float longitud;
	private int nroTelefono;
	private Stock stock;
	private List<Empleado>lstEmpleados;
	private Cliente cliente;
	private List<Lote>lstLotes;
	private List<Factura>lstFacturas;
	private List<Pedido>lstPedidos;
	
	public Locales(long idLocales, String direccion, float latitud, float longitud, int nroTelefono, Stock stock, Cliente cliente) {
		
		this.idLocales=idLocales;
		this.direccion=direccion;
		this.latitud=latitud;
		this.longitud=longitud;
		this.nroTelefono=nroTelefono;
		this.stock=stock;
		this.cliente=cliente;
	}

	public long getIdLocales() {
		return idLocales;
	}

	public void setIdLocales(long idLocales) {
		this.idLocales = idLocales;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public int getNroTelefono() {
		return nroTelefono;
	}

	public void setNroTelefono(int nroTelefono) {
		this.nroTelefono = nroTelefono;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public List<Empleado> getLstEmpleados() {
		return lstEmpleados;
	}

	public void setLstEmpleados(List<Empleado> lstEmpleados) {
		this.lstEmpleados = lstEmpleados;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Lote> getLstLotes() {
		return lstLotes;
	}

	public void setLstLotes(List<Lote> lstLotes) {
		this.lstLotes = lstLotes;
	}

	public List<Factura> getLstFacturas() {
		return lstFacturas;
	}

	public void setLstFacturas(List<Factura> lstFacturas) {
		this.lstFacturas = lstFacturas;
	}

	public List<Pedido> getLstPedidos() {
		return lstPedidos;
	}

	public void setLstPedidos(List<Pedido> lstPedidos) {
		this.lstPedidos = lstPedidos;
	}

	@Override
	public String toString() {
		return "Locales [idLocales=" + idLocales + ", direccion=" + direccion + ", latitud=" + latitud + ", longitud="
				+ longitud + ", nroTelefono=" + nroTelefono + ", stock=" + stock + ", lstEmpleados=" + lstEmpleados
				+ ", cliente=" + cliente + ", lstLotes=" + lstLotes + ", lstFacturas=" + lstFacturas + ", lstPedidos="
				+ lstPedidos + "]";
	}
	
	
}
