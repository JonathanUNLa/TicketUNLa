package datos;

public class TipoBeneficio {
	private int idTipoBeneficio;
	private String beneficio;
	private double descuento;
	
	public TipoBeneficio() {}
	
	public TipoBeneficio(String beneficio, double descuento) {
		super();
		this.beneficio = beneficio;
		this.descuento = descuento;
	}

	public int getIdTipoBeneficio() {
		return idTipoBeneficio;
	}

	protected void setIdTipoBeneficio(int idTipoBeneficio) {
		this.idTipoBeneficio = idTipoBeneficio;
	}

	public String getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return "TipoBeneficio [idTipoBeneficio=" + idTipoBeneficio + ", beneficio=" + beneficio + ", descuento="
				+ descuento + "]";
	}
	
}
