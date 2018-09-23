package datos;

import java.util.*;

public class Seccion {
	private int idSeccion;
	private String nombreSeccion;
	private double precioSeccion;
	private List<Butaca> lstButacas = new ArrayList<Butaca>();
	
	public Seccion() {}

	public Seccion(String nombreSeccion, double precioSeccion, List<Butaca> lstButacas) {
		super();
		this.nombreSeccion = nombreSeccion;
		this.precioSeccion = precioSeccion;
		this.lstButacas = lstButacas;
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

	public List<Butaca> getLstButacas() {
		return lstButacas;
	}

	public void setLstButacas(List<Butaca> lstButacas) {
		this.lstButacas = lstButacas;
	}

	public double getPrecioSeccion() {
		return precioSeccion;
	}

	public void setPrecioSeccion(double precioSeccion) {
		this.precioSeccion = precioSeccion;
	}

	@Override
	public String toString() {
		return "Seccion [idSeccion=" + idSeccion + ", nombreSeccion=" + nombreSeccion + ", precioSeccion="
				+ precioSeccion + ", lstButacas=" + lstButacas + "]";
	}
	
}
