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

	

/*	public double calcularPrecioFinal(){
		double precio=0;
		double desCod=0;
		for(CodigoDescuento s:funcion.getLstCodDesc()) {
			if(s.getCodigo().equals(codigo)) {
				desCod=s.getDescuento();
			}
		}
		precio=funcion.getPrecioBase()+butaca.getSeccion().getPrecioSeccion();

		if(usuario.getTipoBeneficio()!=null) {
			desCod+=usuario.getTipoBeneficio().getDescuento();
		}
		if(desCod>100) {
			precio=0;
		}else {
			precio-=precio*(desCod/100);
		}
		return precio;
		
	}*/

	
	@Override
	public String toString() {
		return "Entrada [idEntrada=" + idEntrada + ", seccion=" + seccion.getNombreSeccion() + ", butaca=" + butaca + ", usuario="
				+ usuario.getNombre() + ", funcion=" + funcion.getIdFuncion() + ", precioFinal=" + precioFinal + "]";
	}
	
}
