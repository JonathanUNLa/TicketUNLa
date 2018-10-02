package datos;

public class TipoBeneficio {
	private int idBeneficio;
	private String beneficio;
	private double descuento;
	
	public TipoBeneficio() {}
	
	public TipoBeneficio(String beneficio, double descuento) {
		super();
		this.beneficio = beneficio;
		this.descuento = descuento;
	}

	public int getidBeneficio() {
		return idBeneficio;
	}

	protected void setidBeneficio(int idBeneficio) {
		this.idBeneficio = idBeneficio;
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
		return "TipoBeneficio [idBeneficio=" + idBeneficio + ", beneficio=" + beneficio + ", descuento="
				+ descuento + "]";
	}
	
}
