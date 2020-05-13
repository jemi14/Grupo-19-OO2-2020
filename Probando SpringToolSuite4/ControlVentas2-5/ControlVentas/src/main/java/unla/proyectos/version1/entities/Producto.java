package unla.proyectos.version1.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="producto")
public class Producto {

	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idProducto;
		
		@Column(name="descripcion")
		private String descripcion;
		
		@Column(name="precioUnitario")
		private double precioUnitario;
	
		
		@Column(name="nombre")
		private String nombre;
		
		@Column(name="createdat")
		@CreationTimestamp
		private LocalDateTime createdAt;
		
		@Column(name="fechaAlta")
		@UpdateTimestamp
		private LocalDateTime updatedAt;
		
		
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
	
		
		public Producto(int idProducto, String descripcion, double precioUnitario) {
			super();
			this.idProducto = idProducto;
			this.descripcion = descripcion;
			this.precioUnitario = precioUnitario;
		
		}
		
		public Producto( String descripcion, double precioUnitario) {
			super();
			
			this.descripcion = descripcion;
			this.precioUnitario = precioUnitario;
	
		}
		
		public Producto() {
			
		}
	
		public LocalDateTime getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}
		public LocalDateTime getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(LocalDateTime updatedAt) {
			this.updatedAt = updatedAt;
		}
		public Producto(int idProducto, String descripcion, double precioUnitario, 
				LocalDateTime createdAt, LocalDateTime updatedAt) {
			super();
			this.idProducto = idProducto;
			this.descripcion = descripcion;
			this.precioUnitario = precioUnitario;
		
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
		}
		
		
		public Producto(String descripcion, double precioUnitario,
				LocalDateTime createdAt, LocalDateTime updatedAt) {
			super();
			
			this.descripcion = descripcion;
			this.precioUnitario = precioUnitario;
			
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public Producto(int idProducto, String descripcion, double precioUnitario, String nombre) {
			super();
			this.idProducto = idProducto;
			this.descripcion = descripcion;
			this.precioUnitario = precioUnitario;
	
			this.nombre = nombre;
			
		}
		
		
		public Producto( String descripcion, double precioUnitario, String nombre) {
			super();
			
			this.descripcion = descripcion;
			this.precioUnitario = precioUnitario;

			this.nombre = nombre;
			
		}
		
		
		
		
		
		
		
		
		
		
		
}