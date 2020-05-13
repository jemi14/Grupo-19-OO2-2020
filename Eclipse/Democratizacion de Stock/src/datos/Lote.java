package datos;
import java.time.LocalDate;
import datos.Locales;
public class Lote {

	private long idLote;
	private int cantidadInicial;
	private int cantidadActual;
	private LocalDate fechaIngreso;
	private Locales local;
	
	
	public Lote(long idLote, int cantidadInicial, int cantidadActual, LocalDate fechaIngreso, Locales local){
		
		this.idLote=idLote;
		this.cantidadInicial=cantidadInicial;
		this.cantidadActual=cantidadActual;
		this.fechaIngreso=fechaIngreso;
		this.local=local;
		
		
	}


	public long getIdLote() {
		return idLote;
	}


	public void setIdLote(long idLote) {
		this.idLote = idLote;
	}


	public int getCantidadInicial() {
		return cantidadInicial;
	}


	public void setCantidadInicial(int cantidadInicial) {
		this.cantidadInicial = cantidadInicial;
	}


	public int getCantidadActual() {
		return cantidadActual;
	}


	public void setCantidadActual(int cantidadActual) {
		this.cantidadActual = cantidadActual;
	}


	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


	public Locales getLocal() {
		return local;
	}


	public void setLocal(Locales local) {
		this.local = local;
	}


	@Override
	public String toString() {
		return "Lote [idLote=" + idLote + ", cantidadInicial=" + cantidadInicial + ", cantidadActual=" + cantidadActual
				+ ", fechaIngreso=" + fechaIngreso + ", local=" + local + "]";
	}	
	
	
}
