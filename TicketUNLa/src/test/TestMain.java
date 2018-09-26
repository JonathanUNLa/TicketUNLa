package test;

import java.util.*;
import negocio.AuditorioABM;
import negocio.ButacaABM;
import negocio.CodigoDescuentoABM;
import negocio.DiaDescuentoABM;
import negocio.EntradaABM;
import negocio.EventoABM;
import negocio.FuncionABM;
import negocio.SeccionABM;
import negocio.TipoAuditorioABM;
import negocio.TipoBeneficioABM;
import negocio.TipoUsuarioABM;
import negocio.UsuarioABM;

public class TestMain {

	public static void main(String[] args) {
		TipoAuditorioABM tipoAuditorioAbm = TipoAuditorioABM.getInstancia();
		AuditorioABM auditorioAbm = AuditorioABM.getInstancia();
		SeccionABM seccionAbm = SeccionABM.getInstancia();
		ButacaABM butacaAbm = ButacaABM.getInstancia();
		EventoABM eventoAbm = EventoABM.getInstancia();
		FuncionABM funcionAbm = FuncionABM.getInstancia();
		CodigoDescuentoABM codigoDescuentoAbm = CodigoDescuentoABM.getInstancia();
		DiaDescuentoABM diaDescuentoAbm = DiaDescuentoABM.getInstancia();
		TipoUsuarioABM tipoUsuarioAbm = TipoUsuarioABM.getInstancia();
		TipoBeneficioABM tipoBeneficioAbm = TipoBeneficioABM.getInstancia();
		UsuarioABM usuarioAbm = UsuarioABM.getInstancia();
		EntradaABM entradaAbm = EntradaABM.getInstancia();
		
		try {
			tipoAuditorioAbm.agregar("estadio");
			tipoAuditorioAbm.agregar("teatro");
			tipoAuditorioAbm.agregar("cine");
			seccionAbm.agregar("seccion 1", 12.5, auditorioAbm.traerAuditorio(1));
			seccionAbm.agregar("seccion 2", 12.5, auditorioAbm.traerAuditorio(1));
			seccionAbm.agregar("seccion 3", 12.5, auditorioAbm.traerAuditorio(1));
			butacaAbm.agregar(2, 1, seccionAbm.traerSeccion(1));
			butacaAbm.agregar(2, 2, seccionAbm.traerSeccion(1));
			butacaAbm.agregar(1, 1, seccionAbm.traerSeccion(1));
			butacaAbm.agregar(1, 2, seccionAbm.traerSeccion(1));
			butacaAbm.agregar(2, 1, seccionAbm.traerSeccion(2));
			butacaAbm.agregar(2, 2, seccionAbm.traerSeccion(2));
			butacaAbm.agregar(1, 1, seccionAbm.traerSeccion(2));
			butacaAbm.agregar(1, 2, seccionAbm.traerSeccion(2));
			butacaAbm.agregar(2, 1, seccionAbm.traerSeccion(3));
			/*Seccion s= new seccion(seccionAbm.traerSeccion(1).getNombreSeccion(),seccionAbm.traerSeccion(1).)
			seccionAbm.modificar(Seccion);
			auditorioAbm.agregar("El Monumental", seccionAbm.traerSeccion(), tipoAuditorioAbm.traerTipoAuditorio(1));
			auditorioAbm.agregar("hoyts", seccionAbm.traerSeccion(), tipoAuditorioAbm.traerTipoAuditorio(3));*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

