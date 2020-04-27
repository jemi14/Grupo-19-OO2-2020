package datos;
import datos.Locales;
import datos.Persona;
import datos.Empleado;

public class Pedido {
	
	private long idPedido;
	private Producto producto;
	private int cantidad;
	private Locales local;
	private Persona persona;
	private Empleado vendedor;
	private float subtotal;
	private boolean aceptado;
	
	public Pedido(long idPedido, Producto producto, int cantidad, Locales local, Persona persona, Empleado vendedor, float subtotal, boolean aceptado) {
		this.idPedido=idPedido;
		this.producto=producto;
		this.cantidad=cantidad;
		this.local=local;
		this.persona=persona;
		this.vendedor=vendedor;
		this.subtotal=subtotal;
		this.aceptado=aceptado;
		
		
	}

	public long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Locales getLocal() {
		return local;
	}

	public void setLocal(Locales local) {
		this.local = local;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Empleado getVendedor() {
		return vendedor;
	}

	public void setVendedor(Empleado vendedor) {
		this.vendedor = vendedor;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", producto=" + producto + ", cantidad=" + cantidad + ", local=" + local
				+ ", persona=" + persona + ", vendedor=" + vendedor + ", subtotal=" + subtotal + ", aceptado="
				+ aceptado + "]";
	}
	
	

}
