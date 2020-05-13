package unla.proyectos.version1.models;

import java.time.LocalDate;

public class ProductoModelo {

	
	
		private int idProducto;
		private String descripcion;
		private double precioUnitario;
		
		private String nombre;
		
		
		public int getIdProducto() {
			return idProducto;
		}
		public void setIdProducto(int idProducto) {
			this.idProducto = idProducto;
		}
		
		
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public double getPrecioUnitario() {
			return precioUnitario;
		}
		public void setPrecioUnitario(double precioUnitario) {
			this.precioUnitario = precioUnitario;
		}
	
		
		public ProductoModelo(int idProducto, String descripcion, double precioUnitario) {
			super();
			this.idProducto = idProducto;
			this.descripcion = descripcion;
			this.precioUnitario = precioUnitario;
		
		}
		
		public ProductoModelo( String descripcion, double precioUnitario) {
			super();
			
			this.descripcion = descripcion;
			this.precioUnitario = precioUnitario;

		}
		
		public ProductoModelo() {
			
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public ProductoModelo(int idProducto, String descripcion, double precioUnitario,
				String nombre) {
			super();
			this.idProducto = idProducto;
			this.descripcion = descripcion;
			this.precioUnitario = precioUnitario;
		
			this.nombre = nombre;
		}
		
		
		public ProductoModelo(String descripcion, double precioUnitario,
				String nombre) {
			super();
			
			this.descripcion = descripcion;
			this.precioUnitario = precioUnitario;
		
			this.nombre = nombre;
		}
		@Override
		public String toString() {
			return "ProductoModelo [idProducto=" + idProducto + ", descripcion=" + descripcion + ", precioUnitario="
					+ precioUnitario +  ", nombre=" + nombre + "]";
		}
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
}
