package datos;

import java.util.Set;

public class Evento {
	private int idEvento;
	private String nombre;
	private Auditorio auditorio;
	private Set<Funcion> lstFunciones;
	
	public Evento() {}
	
	public Evento(String nombre, Auditorio auditorio, Set<Funcion> lstFunciones) {
		this.nombre = nombre;
		this.auditorio = auditorio;
		this.lstFunciones = lstFunciones;
	}	
	
	public Evento(String nombre, Auditorio auditorio) {
		this.nombre = nombre;
		this.auditorio = auditorio;
	}	

	public int getIdEvento() {
		return idEvento;
	}

	protected void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Auditorio getAuditorio() {
		return auditorio;
	}

	public void setAuditorio(Auditorio auditorio) {
		this.auditorio = auditorio;
	}

	public Set<Funcion> getLstFunciones() {
		return lstFunciones;
	}

	public void setLstFunciones(Set<Funcion> lstFunciones) {
		this.lstFunciones = lstFunciones;
	}

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", nombre=" + nombre + ", auditorio=" + auditorio.getNombre()  + ", lstFunciones=" + lstFunciones +"]";
	}


	
}
