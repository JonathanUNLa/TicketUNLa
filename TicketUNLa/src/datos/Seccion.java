package datos;

public class Seccion {
	private int idSeccion;
	private String nombreSeccion;
	private int cantFilas;
	private int cantColumnas;
	private double precioSeccion;
	
	public Seccion() {}

	public Seccion(String nombreSeccion, int cantFilas, int cantColumnas, double precioSeccion) {
		this.nombreSeccion = nombreSeccion;
		this.cantFilas = cantFilas;
		this.cantColumnas = cantColumnas;
		this.precioSeccion = precioSeccion;
	}

	public int getIdSeccion() {
		return idSeccion;
	}

	protected void setIdSeccion(int idSeccion) {
		this.idSeccion = idSeccion;
	}

	public String getNombreSeccion() {
		return nombreSeccion;
	}

	public void setNombreSeccion(String nombreSeccion) {
		this.nombreSeccion = nombreSeccion;
	}

	public int getCantFilas() {
		return cantFilas;
	}

	public void setCantFilas(int cantFilas) {
		this.cantFilas = cantFilas;
	}

	public int getCantColumnas() {
		return cantColumnas;
	}

	public void setCantColumnas(int cantColumnas) {
		this.cantColumnas = cantColumnas;
	}

	public double getPrecioSeccion() {
		return precioSeccion;
	}

	public void setPrecioSeccion(double precioSeccion) {
		this.precioSeccion = precioSeccion;
	}

	@Override
	public String toString() {
		return "Seccion [idSeccion=" + idSeccion + ", nombreSeccion=" + nombreSeccion + ", cantFilas=" + cantFilas
				+ ", cantColumnas=" + cantColumnas + ", precioSeccion=" + precioSeccion + "]";
	}
	
}
