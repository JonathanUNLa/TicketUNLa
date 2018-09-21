package datos;

public class TipoUsuario {
	private int idTipoUsuario;
	private String nombre;
	private TipoBeneficio tipoBeneficio;
	private Auditorio auditorio;
	
	public TipoUsuario() {}
	
	public TipoUsuario(String nombre, TipoBeneficio tipoBeneficio, Auditorio auditorio) {
		this.nombre = nombre;
		this.tipoBeneficio = tipoBeneficio;
		this.auditorio = auditorio;
	}

	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}

	protected void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoBeneficio getTipoBeneficio() {
		return tipoBeneficio;
	}

	public void setTipoBeneficio(TipoBeneficio tipoBeneficio) {
		this.tipoBeneficio = tipoBeneficio;
	}

	public Auditorio getAuditorio() {
		return auditorio;
	}

	public void setAuditorio(Auditorio auditorio) {
		this.auditorio = auditorio;
	}

	@Override
	public String toString() {
		return "TipoUsuario [idTipoUsuario=" + idTipoUsuario + ", nombre=" + nombre + ", tipoBeneficio=" + tipoBeneficio
				+ ", auditorio=" + auditorio + "]";
	}
	
}
