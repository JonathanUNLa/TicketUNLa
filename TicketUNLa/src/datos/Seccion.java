package datos;

import java.util.*;

public class Seccion {
	private int idSeccion;
	private String nombreSeccion;
	private double precioSeccion;
	private Set<Butaca> lstButacas;
	private Auditorio auditorio;
	
	public Seccion() {}

	public Seccion(String nombreSeccion, double precioSeccion, Set<Butaca> lstButacas, Auditorio auditorio) {
		super();
		this.nombreSeccion = nombreSeccion;
		this.precioSeccion = precioSeccion;
		this.lstButacas = lstButacas;
		this.auditorio = auditorio;
	}



	public Seccion(String nombreSeccion, double precioSeccion, Auditorio auditorio) {
		super();
		this.nombreSeccion = nombreSeccion;
		this.precioSeccion = precioSeccion;
		this.auditorio = auditorio;
	}

	public Auditorio getAuditorio() {
		return auditorio;
	}



	protected void setAuditorio(Auditorio auditorio) {
		this.auditorio = auditorio;
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

	public Set<Butaca> getLstButacas() {
		return lstButacas;
	}

	public void setLstButacas(Set<Butaca> lstButacas) {
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
