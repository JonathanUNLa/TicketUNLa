package test;

import java.util.GregorianCalendar;

import negocio.AuditorioABM;
import negocio.ButacaABM;
import negocio.CodigoDescuentoABM;
import negocio.DiaDescuentoABM;
import negocio.EntradaABM;
import negocio.EventoABM;
import negocio.FuncionABM;
import negocio.ReservaABM;
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
		ReservaABM reservaAbm= ReservaABM.getInstancia();
		try {
			
			// agregar 
			
	/*
			tipoAuditorioAbm.agregar("estadio");
			tipoAuditorioAbm.agregar("teatro");
			tipoAuditorioAbm.agregar("cine");
			auditorioAbm.agregar("El Monumental", tipoAuditorioAbm.traerTipoAuditorio(2));
			auditorioAbm.agregar("Colon", tipoAuditorioAbm.traerTipoAuditorio(3));
			seccionAbm.agregar("seccion 1", 0, auditorioAbm.traerAuditorio(2));
			seccionAbm.agregar("seccion 2", 100, auditorioAbm.traerAuditorio(2));
			seccionAbm.agregar("seccion 3", 200, auditorioAbm.traerAuditorio(2));
			butacaAbm.agregar(2, 1, seccionAbm.traerSeccion(2));
			butacaAbm.agregar(2, 2, seccionAbm.traerSeccion(2));
			butacaAbm.agregar(1, 1, seccionAbm.traerSeccion(2));
			butacaAbm.agregar(1, 2, seccionAbm.traerSeccion(2));
			butacaAbm.agregar(2, 1, seccionAbm.traerSeccion(3));
			butacaAbm.agregar(2, 2, seccionAbm.traerSeccion(3));
			butacaAbm.agregar(1, 1, seccionAbm.traerSeccion(3));
			butacaAbm.agregar(1, 2, seccionAbm.traerSeccion(3));
			butacaAbm.agregar(2, 1, seccionAbm.traerSeccion(3));
			eventoAbm.agregar("Evento 1", auditorioAbm.traerAuditorio(2));
			eventoAbm.agregar("Evento 2", auditorioAbm.traerAuditorio(1));
			diaDescuentoAbm.agregar("Lunes", 15.0);
			diaDescuentoAbm.agregar("Martes", 20.0);
			funcionAbm.agregar(500.0, new GregorianCalendar(), eventoAbm.traerEvento(1), diaDescuentoAbm.traerDiaDescuento(1));
			funcionAbm.agregar(550.0, new GregorianCalendar(), eventoAbm.traerEvento(1), diaDescuentoAbm.traerDiaDescuento(1));
			funcionAbm.agregar(600.0, new GregorianCalendar(), eventoAbm.traerEvento(2), diaDescuentoAbm.traerDiaDescuento(2));
			funcionAbm.agregar(650.0, new GregorianCalendar(), eventoAbm.traerEvento(2), diaDescuentoAbm.traerDiaDescuento(2));
			codigoDescuentoAbm.agregar("SDE5697", 100.0, seccionAbm.traerSeccion(2), funcionAbm.traerFuncion(1));
			tipoUsuarioAbm.agregar("Administrador");
			tipoUsuarioAbm.agregar("Cliente");
			tipoUsuarioAbm.agregar("Empleado");
			tipoBeneficioAbm.agregar("Jubilado", 10);
			tipoBeneficioAbm.agregar("Estudiante", 5);
			usuarioAbm.agregar(30, "Jonathan", "Yañez", "43698789", "Jon", "soyputo123", tipoUsuarioAbm.traerTipoUsuario(2), tipoBeneficioAbm.traerTipoBeneficio(2),auditorioAbm.traerAuditorio(1));
			usuarioAbm.agregar(40, "Jose", "Lucero", "40364587", "asd", "123456", tipoUsuarioAbm.traerTipoUsuario(1), tipoBeneficioAbm.traerTipoBeneficio(1),auditorioAbm.traerAuditorio(1));
			usuarioAbm.agregar(50, "Empleado", "Asd", "43698789", "asdasd", "asd123", tipoUsuarioAbm.traerTipoUsuario(3), tipoBeneficioAbm.traerTipoBeneficio(1),auditorioAbm.traerAuditorio(1));
			reservaAbm.agregar(usuarioAbm.traerUsuarioHql(1), false);
			entradaAbm.agregar(butacaAbm.traerButacaHql(1),  funcionAbm.traerFuncionHql(1),"SDE5697",reservaAbm.traerReserva(1));
			*/
			//traer e imprimir
			
			/*System.out.println(butacaAbm.traerButacaHql(1));
			System.out.println(seccionAbm.traerSeccionHql(1));
		//	System.out.println(eventoAbm.traerEventoHql(1));
			System.out.println(funcionAbm.traerFuncionHql(1));
			System.out.println(auditorioAbm.traerAuditorioHql(1));
			System.out.println(codigoDescuentoAbm.traerCodigoDescuentoHql(1));
			System.out.println(usuarioAbm.traerUsuario("Jon"));
			System.out.println(entradaAbm.traerEntradaHql(1));
			System.out.println(funcionAbm.traerFuncionHql(1).damianSeLaCome());
			*/
			//System.out.println(eventoAbm.traerEvento("el monumental"));
			//funcionAbm.agregar(500.0, new GregorianCalendar(), eventoAbm.traerEvento(1), diaDescuentoAbm.traerDiaDescuento(1));
			
			//System.out.println(funcionAbm.traerFuncion("Evento 1"));
			System.out.println(butacaAbm.traerButacaFuncion(1));
			//entradaAbm.agregar(butacaAbm.traerButacaHql(1), funcionAbm.traerFuncionHql(1), "asd", reservaAbm.traerReserva(1));
		//System.out.println(reservaAbm.traerReservaHql(1));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

