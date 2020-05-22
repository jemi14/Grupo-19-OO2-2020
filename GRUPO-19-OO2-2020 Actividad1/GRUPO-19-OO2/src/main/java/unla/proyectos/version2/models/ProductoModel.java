package unla.proyectos.version2.models;

public class ProductoModel {

    private long id;
    private String descripcion;
    private float precioUnitario;
    private String nombre;

    public ProductoModel(){}

    public ProductoModel(long id, String descripcion, float precioUnitario, String nombre) {
        this.id = id;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.nombre = nombre;
    }
    
    
    public ProductoModel( String descripcion, float precioUnitario, String nombre) {
     
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

 
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	@Override
	public String toString() {
		return "ProductoModel [id=" + id + ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario
				+ ", nombre=" + nombre + "]";
	}

    
    
    
}
