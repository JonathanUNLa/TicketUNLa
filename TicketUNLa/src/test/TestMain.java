package test;

import java.util.*;

import datos.Butaca;
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
			/*tipoAuditorioAbm.agregar("estadio");
			tipoAuditorioAbm.agregar("teatro");
			tipoAuditorioAbm.agregar("cine");
			auditorioAbm.agregar("El Monumental", tipoAuditorioAbm.traerTipoAuditorio(1));
			auditorioAbm.agregar("Colon", tipoAuditorioAbm.traerTipoAuditorio(2));
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
			eventoAbm.agregar("Evento 1", auditorioAbm.traerAuditorio(1));
			eventoAbm.agregar("Evento 2", auditorioAbm.traerAuditorio(2));
			diaDescuentoAbm.agregar("Lunes", 15.0);
			diaDescuentoAbm.agregar("Martes", 20.0);
			funcionAbm.agregar(500.0, new GregorianCalendar(), eventoAbm.traerEvento(1), diaDescuentoAbm.traerDiaDescuento(1));
			funcionAbm.agregar(550.0, new GregorianCalendar(), eventoAbm.traerEvento(1), diaDescuentoAbm.traerDiaDescuento(1));
			funcionAbm.agregar(600.0, new GregorianCalendar(), eventoAbm.traerEvento(2), diaDescuentoAbm.traerDiaDescuento(2));
			funcionAbm.agregar(650.0, new GregorianCalendar(), eventoAbm.traerEvento(2), diaDescuentoAbm.traerDiaDescuento(2));
			codigoDescuentoAbm.agregar("SDE5697", 20.0, seccionAbm.traerSeccion(1), funcionAbm.traerFuncion(1));
			tipoUsuarioAbm.agregar("Administrador");
			tipoUsuarioAbm.agregar("Cliente");
			tipoUsuarioAbm.agregar("Empleado");
			tipoBeneficioAbm.agregar("Jubilado", 10);
			tipoBeneficioAbm.agregar("Estudiante", 5);
			usuarioAbm.agregar(30, "Jonathan", "Yañez", "43698789", "Jon", "soyputo123", tipoUsuarioAbm.traerTipoUsuario(2), tipoBeneficioAbm.traerTipoBeneficio(1),null);
			usuarioAbm.agregar(40, "Jose", "Lucero", "40364587", "asd", "123456", tipoUsuarioAbm.traerTipoUsuario(1), null,null);
			usuarioAbm.agregar(50, "Empleado", "Asd", "43698789", "asdasd", "asd123", tipoUsuarioAbm.traerTipoUsuario(3), null,null);*/
			/*System.out.println(butacaAbm.traerButacaHql(1));
			System.out.println(seccionAbm.traerSeccionHql(1));
			System.out.println(eventoAbm.traerEventoHql(1));
			System.out.println(funcionAbm.traerFuncionHql(1));
			System.out.println(auditorioAbm.traerAuditorioHql(1));
			System.out.println(codigoDescuentoAbm.traerCodigoDescuentoHql(1));*/
			System.out.println(usuarioAbm.traerUsuarioHql(4));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

