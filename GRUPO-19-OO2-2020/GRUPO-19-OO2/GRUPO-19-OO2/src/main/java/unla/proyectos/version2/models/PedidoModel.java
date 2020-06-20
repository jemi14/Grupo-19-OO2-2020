package unla.proyectos.version2.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class PedidoModel {
	
	private long id;
	private ProductoModel producto;
	private LocalModel local;
	private ClienteModel cliente;
	
	
	
	private int cantidad;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaPedido;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaEntrega;
	private boolean pagado;
	private boolean entregado;
	private boolean tomado;
	
	private String descripcion;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ProductoModel getProducto() {
		return producto;
	}
	public void setProducto(ProductoModel producto) {
		this.producto = producto;
	}
	public LocalModel getLocal() {
		return local;
	}
	public void setLocal(LocalModel local) {
		this.local = local;
	}

	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public LocalDate getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public boolean isPagado() {
		return pagado;
	}
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	public boolean isEntregado() {
		return entregado;
	}
	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}
	public PedidoModel(long id, ProductoModel producto, LocalModel local, int cantidad,
			LocalDate fechaPedido, LocalDate fechaEntrega, boolean pagado, boolean entregado) {
		super();
		this.id = id;
		this.producto = producto;
		this.local = local;
		//this.persona = persona;
		this.cantidad = cantidad;
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
		this.pagado = pagado;
		this.entregado = entregado;
	}
	
	
	public PedidoModel() {
		super();
	
	}
	@Override
	public String toString() {
		return "PedidoModel [id=" + id + ", producto=" + producto + ", local=" + local + ", cliente=" + cliente
				+ ", cantidad=" + cantidad + ", fechaPedido=" + fechaPedido + ", fechaEntrega=" + fechaEntrega
				+ ", pagado=" + pagado + ", entregado=" + entregado + "]";
	}
	
	
	public ClienteModel getCliente() {
		return cliente;
	}
	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}
	public PedidoModel(long id, ProductoModel producto, LocalModel local, ClienteModel cliente, int cantidad,
			LocalDate fechaPedido, LocalDate fechaEntrega, boolean pagado, boolean entregado) {
		super();
		this.id = id;
		this.producto = producto;
		this.local = local;
		this.cliente = cliente;
		this.cantidad = cantidad;
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
		this.pagado = pagado;
		this.entregado = entregado;
		this.tomado = true;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public PedidoModel(long id, ProductoModel producto, LocalModel local, ClienteModel cliente, int cantidad,
			LocalDate fechaPedido, LocalDate fechaEntrega, boolean pagado, boolean entregado, String descripcion) {
		super();
		this.id = id;
		this.producto = producto;
		this.local = local;
		this.cliente = cliente;
		this.cantidad = cantidad;
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
		this.pagado = pagado;
		this.entregado = entregado;
		this.descripcion = descripcion;
		this.tomado = true;
	}
	public boolean isTomado() {
		return tomado;
	}
	public void setTomado(boolean tomado) {
		this.tomado = tomado;
	}

	
	
	
	
	
	

	

	
	
	
	
	
	
	
	
	

}
