package projetoBD_POO;

import org.junit.jupiter.api.Test;

import projetoBD_POO.bancoBD.Database;
import projetoBD_POO.cadrasto.organizador.BD_organizador;
import projetoBD_POO.cadrasto.participante.BD_participante;
import projetoBD_POO.cadrasto.partida.BD_Partida;
import projetoBD_POO.classificação.BD_Classificacao;

class TesteConnetion {

	@Test
	void connectionBD() {
		Database data = new Database();
		data.connect();
	}
	@Test
	void connectionPartida() {
		BD_Partida bd_Partida = new BD_Partida();
		bd_Partida.connect();
	}
	
	@Test
	void connectionClassificacao() {
		BD_Classificacao bd_Classificacao = new BD_Classificacao();
		bd_Classificacao.connect();
	}
	
	@Test
	void connectionParticipante() {
		BD_participante bd_participante = new BD_participante();
		bd_participante.connect();
	}
	
	@Test
	void testOrganizador() {
		BD_organizador bd_organizador = new BD_organizador();
		bd_organizador.connect();
		
	}
	
}
