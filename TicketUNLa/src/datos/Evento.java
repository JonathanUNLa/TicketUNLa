package datos;

public class Evento {
	private int idEvento;
	private String nombre;
	private Auditorio auditorio;
	
	public Evento() {}
	
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

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", nombre=" + nombre + ", auditorio=" + auditorio + "]";
	}
	
}
