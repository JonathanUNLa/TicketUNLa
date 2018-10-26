package datos;

public class Usuario {
	private int idUsuario;
	private int dni;
	private String nombre;
	private String apellido;
	private String telefono;
	private String nombreUsuario;
	private String contraseña;
	private TipoUsuario tipoUsuario;
	private TipoBeneficio tipoBeneficio;
	private Auditorio auditorio;
	public Usuario() {}
	
	
	
	public Usuario( int dni, String nombre, String apellido, String telefono, String nombreUsuario,
			String contraseña, TipoUsuario tipoUsuario, TipoBeneficio tipoBeneficio, Auditorio auditorio) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.tipoUsuario = tipoUsuario;
		this.tipoBeneficio = tipoBeneficio;
		this.auditorio = auditorio;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	protected void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
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
	/*	String retorno=null;
		
		if(auditorio==null) {
			retorno= "Usuario [idUsuario=" + idUsuario + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido
					+ ", telefono=" + telefono + ", nombreUsuario=" + nombreUsuario + ", contraseÃ±a=" + contraseÃ±a
					+ ", tipoUsuario=" + tipoUsuario.getNombreTipo() + ", tipoBeneficio=" + tipoBeneficio.getBeneficio() +"]";
		}else {

			retorno= "Usuario [idUsuario=" + idUsuario + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido
					+ ", telefono=" + telefono + ", nombreUsuario=" + nombreUsuario + ", contraseÃ±a=" + contraseÃ±a
					+ ", tipoUsuario=" + tipoUsuario.getNombreTipo() + ", tipoBeneficio=" + tipoBeneficio.getBeneficio() +auditorio+"]";
		}
				return retorno;
	*/
		return "Usuario [idUsuario=" + idUsuario + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", telefono=" + telefono + ", nombreUsuario=" + nombreUsuario + ", contraseÃ±a=" + contraseña
				+ ", tipoUsuario=" + tipoUsuario + ", tipoBeneficio=" + tipoBeneficio + ", auditorio=" + auditorio
				+ "]";
	}
	
}
