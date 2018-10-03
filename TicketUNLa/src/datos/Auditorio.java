package datos;

import java.util.*;

public class Auditorio {
	private int idAuditorio;
	private String nombre;
	private Set<Seccion> lstSecciones;
	private TipoAuditorio tipoAuditorio;
	private Set<Evento> lstEventos;
	
	public Auditorio(){}

	public Auditorio(String nombre, Set<Seccion> lstSecciones, TipoAuditorio tipoAuditorio, Set<Evento> lstEventos) {
		super();
		this.nombre = nombre;
		this.lstSecciones = lstSecciones;
		this.tipoAuditorio = tipoAuditorio;
		this.lstEventos = lstEventos;
	}



	
	public Auditorio(String nombre, TipoAuditorio tipoAuditorio) {
		super();
		this.nombre = nombre;
		this.tipoAuditorio = tipoAuditorio;
	}



	public Set<Evento> getLstEventos() {
		return lstEventos;
	}

	public void setLstEventos(Set<Evento> lstEventos) {
		this.lstEventos = lstEventos;
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

	public Set<Seccion> getLstSecciones() {
		return lstSecciones;
	}

	public void setLstSecciones(Set<Seccion> lstSecciones) {
		this.lstSecciones = lstSecciones;
	}

	public TipoAuditorio getTipoAuditorio() {
		return tipoAuditorio;
	}

	public void setTipoAuditorio(TipoAuditorio tipoAuditorio) {
		this.tipoAuditorio = tipoAuditorio;
	}

	@Override
	public String toString() {
		return "Auditorio [idAuditorio=" + idAuditorio + ", nombre=" + nombre + ", lstSecciones=" + lstSecciones
				+ ", tipoAuditorio=" + tipoAuditorio + ", lstEvento=" + lstEventos + "]";
	}




}
