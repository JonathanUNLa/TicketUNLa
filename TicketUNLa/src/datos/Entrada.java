package datos;

public class Entrada {
	private int idEntrada;
	private Butaca butaca;
	private Funcion funcion;
	private String codigo;
	private double precioFinal;
	private Reserva reserva;
	
	public Entrada() {}
	
	
	


	public Entrada(Butaca butaca, Funcion funcion, String codigo, Reserva reserva) {
		super();
		this.butaca = butaca;
		this.funcion = funcion;
		this.codigo = codigo;
		this.precioFinal=500;
		this.reserva = reserva;
	}





	public int getIdEntrada() {
		return idEntrada;
	}

	protected void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
	}
	
	
	
	public Reserva getReserva() {
		return reserva;
	}



	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}



	public Butaca getButaca() {
		return butaca;
	}

	public void setButaca(Butaca butaca) {
		this.butaca = butaca;
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
	
	

	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	/*public double esValido() {
		double desc=0;
		for (CodigoDescuento c : funcion.getLstCodDesc()) {
			if(codigo.equals(c.getCodigo())) {
				desc=c.getDescuento();
			}
		}
		return desc;
	}

	public double calcularPrecioFinal(){
		double precio=0;
		double desCod=0;
		if(esValido()!=0) {
			desCod=esValido();
		}
		precio=funcion.getPrecioBase()+butaca.getSeccion().getPrecioSeccion();

				if(desCod==100) {
			precio=0;
		}else {
			precio-=precio*(desCod/100);
		}
		return precio;
		
	}


*/
	@Override
	public String toString() {
		return "Entrada [idEntrada=" + idEntrada + ", butaca=" + butaca +  ", funcion="
				+ funcion + ", codigo=" + codigo + ", precioFinal=" + precioFinal + ", reserva=" +  "]";
	}

	
	
}
