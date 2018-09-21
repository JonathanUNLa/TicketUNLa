package datos;

public class Entrada {
	private int idEntrada;
	private Seccion seccion;
	private Butaca butaca;
	private Usuario usuario;
	private Funcion funcion;
	private double precioFinal;
	
	public Entrada() {}
	
	public Entrada(Seccion seccion, Butaca butaca, Usuario usuario, Funcion funcion,
			double precioFinal) {
		this.seccion = seccion;
		this.butaca = butaca;
		this.usuario = usuario;
		this.funcion = funcion;
		this.precioFinal = precioFinal;
	}

	public int getIdEntrada() {
		return idEntrada;
	}

	protected void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public Butaca getButaca() {
		return butaca;
	}

	public void setButaca(Butaca butaca) {
		this.butaca = butaca;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	public double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}

	@Override
	public String toString() {
		return "Entrada [idEntrada=" + idEntrada + ", seccion=" + seccion + ", butaca=" + butaca + ", usuario="
				+ usuario + ", funcion=" + funcion + ", precioFinal=" + precioFinal + "]";
	}
	
}
