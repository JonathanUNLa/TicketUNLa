package datos;

public class TipoUsuario {
	private int idTipoUsuario;
	private String nombreTipo;
	private TipoBeneficio tipoBeneficio;
	private Auditorio auditorio;
	
	public TipoUsuario() {}
	
	public TipoUsuario(String nombreTipo, TipoBeneficio tipoBeneficio, Auditorio auditorio) {
		this.nombreTipo = nombreTipo;
		this.tipoBeneficio = tipoBeneficio;
		this.auditorio = auditorio;
	}


	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}

	protected void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
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
		return "TipoUsuario [idTipoUsuario=" + idTipoUsuario + ", nombreTipo=" + nombreTipo + ", tipoBeneficio=" + tipoBeneficio
				+ ", auditorio=" + auditorio + "]";
	}
	
}
