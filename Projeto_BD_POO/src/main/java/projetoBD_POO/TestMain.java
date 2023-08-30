package projetoBD_POO;

import org.junit.jupiter.api.Test;

import projetoBD_POO.cadrasto.organizador.BD_organizador;
import projetoBD_POO.cadrasto.organizador.Organizador;
import projetoBD_POO.cadrasto.participante.BD_participante;
import projetoBD_POO.cadrasto.participante.Participante;

class TestMain {

	@Test
	void testInsert() {
		BD_organizador bd_organizador = new BD_organizador();
		Organizador organizador = new Organizador();
		organizador.setId(1);
		organizador.setNomeEvento("ab");
		organizador.setNome("A");
		organizador.setCPF("111.111.111-11");
		organizador.setIdade(50);
		bd_organizador.insertOrganizador(organizador);
		
		BD_participante bd_participante = new BD_participante();
		Participante participante = new Participante();
		participante.setId(1);
		participante.setNome("B");
		participante.setCPF("111.222.333-11");
		participante.setIdade(12);
		participante.setOrganizador_idOrganizador(1);
		bd_participante.insertParticipante(participante);
	}

}
