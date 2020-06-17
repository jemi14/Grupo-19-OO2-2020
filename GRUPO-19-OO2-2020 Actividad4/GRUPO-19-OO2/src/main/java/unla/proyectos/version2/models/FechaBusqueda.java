package unla.proyectos.version2.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class FechaBusqueda {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaDesde;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaHasta;
	
	private LocalModel local;
	private VendedorModel vendedor;
	
	public LocalDate getFechaDesde() {
		return fechaDesde;
	}
	
	public void setFechaDesde(LocalDate fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	
	public LocalDate getFechaHasta() {
		return fechaHasta;
	}
	
	public void setFechaHasta(LocalDate fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	
	public FechaBusqueda(LocalDate fechaDesde, LocalDate fechaHasta, LocalModel local) {
		super();
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
	}
	
	public FechaBusqueda(LocalDate fechaDesde, LocalDate fechaHasta, LocalModel local, VendedorModel vendedor) {
		super();
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
	}
	
	public FechaBusqueda(LocalDate fechaDesde, LocalDate fechaHasta, VendedorModel vendedor) {
		super();
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
	}
	
	public FechaBusqueda() {
		super();
	}
	
	public LocalModel getLocal() {
		return local;
	}
	
	public void setLocal(LocalModel local) {
		this.local = local;
	}
	
	public VendedorModel getVendedor() {
		return vendedor;
	}
	
	public void setVendedor(VendedorModel vendedor) {
		this.vendedor = vendedor;
	}
}
