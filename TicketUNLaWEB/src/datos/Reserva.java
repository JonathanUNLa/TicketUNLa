package datos;

import java.util.Set;

public class Reserva {

		private int idReserva;
		private Usuario usuario;
		private Set<Entrada> lstEntradas;
		private double precioTotal;
		private boolean entregado;
		
		public Reserva() {
			super();
		}

		public Reserva(Usuario usuario, boolean entregado) {
			super();
			this.usuario = usuario;
			this.precioTotal = 500.0;
			this.entregado = entregado;
		}

		

		public Reserva(Usuario usuario, Set<Entrada> lstEntradas, double precioTotal, boolean entregado) {
			super();
			this.usuario = usuario;
			this.lstEntradas = lstEntradas;
			this.precioTotal = calcularTotal();
			this.entregado = entregado;
		}


	
		public int getIdReserva() {
			return idReserva;
		}

		protected void setIdReserva(int idReserva) {
			this.idReserva = idReserva;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public double getPrecioTotal() {
			return precioTotal;
		}

		public void setPrecioTotal(double precioTotal) {
			this.precioTotal = precioTotal;
		}

		public boolean isEntregado() {
			return entregado;
		}

		public void setEntregado(boolean entregado) {
			this.entregado = entregado;
		}
		
		
		
		public Set<Entrada> getLstEntradas() {
			return lstEntradas;
		}

		public void setLstEntradas(Set<Entrada> lstEntradas) {
			this.lstEntradas = lstEntradas;
		}

		public double calcularTotal() {
			double precio=0;
			
			for(Entrada e: lstEntradas) {
				precio=precio+e.getPrecioFinal();
			}
			
			if(usuario.getTipoBeneficio()!=null) {
				precio-=precio*((usuario.getTipoBeneficio().getDescuento())/100);
			}
			
			return precio;
		}
		
		
		@Override
		public String toString() {
			return "Reserva [IdReserva=" + idReserva + ", usuario=" + usuario + ", lstEntradas=" + lstEntradas
					+ ", precioTotal=" + precioTotal + ", entregado=" + entregado + "]";
		}
		

		
		
}
