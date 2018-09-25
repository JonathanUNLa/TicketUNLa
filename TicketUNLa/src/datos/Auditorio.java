package datos;

import java.util.*;

public class Auditorio {
	private int idAuditorio;
	private String nombre;
	private List<Seccion> lstSecciones= new ArrayList<Seccion>();
	private TipoAuditorio tipoAuditorio;
	
	public Auditorio(){}

	public Auditorio(String nombre, List<Seccion> lstSecciones, TipoAuditorio tipoAuditorio) {
		super();
		this.nombre = nombre;
		this.lstSecciones = lstSecciones;
		this.tipoAuditorio = tipoAuditorio;
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

	public TipoAuditorio getTipoAuditorio() {
		return tipoAuditorio;
	}

	public void setTipoAuditorio(TipoAuditorio tipoAuditorio) {
		this.tipoAuditorio = tipoAuditorio;
	}

	
	
}
