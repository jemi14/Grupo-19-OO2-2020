package unla.proyectos.version2.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Producto producto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Local local;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//private Persona persona;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//private Cliente persona;
	
	//@OneToMany(fetch=FetchType.LAZY, mappedBy="persona")
	//private Set<Degree> degrees = new HashSet<Degree>();
	
	@Column(name="cantidad")
	
	private int cantidad;
	private LocalDate fechaPedido;
	private LocalDate fechaEntrega;
	private boolean pagado;
	private boolean entregado;
	private boolean tomado;
	
	@Column(name="descripcion", length=300)
	private String descripcion;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
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
	
	public Pedido(long id, Producto producto, Local local, int cantidad,
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
	
	public Pedido() {
		super();
	
	}
	
	@Override
	public String toString() {
		return "PedidoModel [id=" + id + ", producto=" + producto + ", local=" + local + ", cliente=" + cliente
				+ ", cantidad=" + cantidad + ", fechaPedido=" + fechaPedido + ", fechaEntrega=" + fechaEntrega
				+ ", pagado=" + pagado + ", entregado=" + entregado + "]";
	}
	
	public Pedido( Producto producto, Local local,  int cantidad, LocalDate fechaPedido,
			LocalDate fechaEntrega, boolean pagado, boolean entregado) {
		super();
		this.producto = producto;
		this.local = local;
		//this.persona = persona;
		this.cantidad = cantidad;
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
		this.pagado = pagado;
		this.entregado = entregado;
		this.tomado = true;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Pedido(long id, Producto producto, Local local, Cliente cliente, int cantidad, LocalDate fechaPedido,
			LocalDate fechaEntrega, boolean pagado, boolean entregado) {
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
	
	public Pedido(long id, Producto producto, Local local, Cliente cliente, int cantidad, LocalDate fechaPedido,
			LocalDate fechaEntrega, boolean pagado, boolean entregado, String descripcion) {
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
