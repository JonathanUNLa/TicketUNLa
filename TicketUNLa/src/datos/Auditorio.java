package datos;

import java.util.*;

public class Auditorio {
	private int idAuditorio;
	private String nombre;
	private List<Seccion> lstSecciones= new ArrayList<Seccion>();
	private TipoAuditorio tipoAudiotorio;
	
	public Auditorio(){}

	public Auditorio(String nombre, List<Seccion> lstSecciones, TipoAuditorio tipoAudiotorio) {
		this.nombre = nombre;
		this.lstSecciones = lstSecciones;
		this.tipoAudiotorio = tipoAudiotorio;
	}

	public int getIdAuditorio() {
		return idAuditorio;
	}

	protected void setIdAuditorio(int idAuditorio) {
		this.idAuditorio = idAuditorio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Seccion> getLstSecciones() {
		return lstSecciones;
	}

	public void setLstSecciones(List<Seccion> lstSecciones) {
		this.lstSecciones = lstSecciones;
	}

	public TipoAuditorio getTipoAudiotorio() {
		return tipoAudiotorio;
	}

	public void setTipoAudiotorio(TipoAuditorio tipoAudiotorio) {
		this.tipoAudiotorio = tipoAudiotorio;
	}

	@Override
	public String toString() {
		return "Auditorio [idAuditorio=" + idAuditorio + ", nombre=" + nombre + ", lstSecciones=" + lstSecciones
				+ ", tipoAudiotorio=" + tipoAudiotorio + "]";
	}

}
