package datos;

public class TipoUsuario {
	private int idTipoUsuario;
	private String nombreTipo;
	
	public TipoUsuario() {}
	
	public TipoUsuario(String nombreTipo  ) {
		this.nombreTipo = nombreTipo;
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


	@Override
	public String toString() {
		return "TipoUsuario [idTipoUsuario=" + idTipoUsuario + ", nombreTipo=" + nombreTipo  + "]";
	}
	
}
