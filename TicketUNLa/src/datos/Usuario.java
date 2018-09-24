package datos;

public class Usuario {
	private int idUsuario;
	private long dni;
	private String nombre;
	private String apellido;
	private String telefono;
	private String nombreUsuario;
	private String contrasenia;
	private TipoUsuario tipoUsuario;
	private TipoBeneficio tipoBeneficio;
	
	public Usuario() {}
	
	public Usuario(long dni, String nombre, String apellido, String telefono, String nombreUsuario,
			String contrasenia, TipoUsuario tipoUsuario, TipoBeneficio tipoBeneficio) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.tipoUsuario = tipoUsuario;
		this.tipoBeneficio = tipoBeneficio;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	protected void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
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

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
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

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", telefono=" + telefono + ", nombreUsuario=" + nombreUsuario + ", contrasenia=" + contrasenia
				+ ", tipoUsuario=" + tipoUsuario + ", tipoBeneficio=" + tipoBeneficio + "]";
	}
	
}
