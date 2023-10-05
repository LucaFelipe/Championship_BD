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
        organizador.setNomeEvento("Evento A");
        organizador.setNome("Organizador A");
        organizador.setCPF("111.111.111-11");
        organizador.setIdade(50);
        bd_organizador.insertOrganizador(organizador);

        BD_participante bd_participante = new BD_participante();
        Participante participante = new Participante();
        participante.setId(1);
        participante.setNome("Participante B");
        participante.setCPF("111.222.333-11");
        participante.setIdade(12);
        participante.setOrganizador_idOrganizador(1);
        bd_participante.insertParticipante(participante);
    }

    @Test
    void testSearchAndUpdate() {
        // Realize uma inserção para ter dados para pesquisa e atualização
        BD_organizador bd_organizador = new BD_organizador();
        Organizador organizador = new Organizador();
        organizador.setId(2);
        organizador.setNomeEvento("Evento B");
        organizador.setNome("Organizador B");
        organizador.setCPF("222.222.222-22");
        organizador.setIdade(40);
        bd_organizador.insertOrganizador(organizador);

        BD_participante bd_participante = new BD_participante();
        Participante participante = new Participante();
        participante.setId(2);
        participante.setNome("Participante C");
        participante.setCPF("222.333.444-22");
        participante.setIdade(25);
        participante.setOrganizador_idOrganizador(2);
        bd_participante.insertParticipante(participante);

        // Realize uma pesquisa (search) em Organizador
        Organizador org = bd_organizador.searchOrganizadorById(2);
        System.out.println("Organizador encontrado: " + org.getNome());

        // Realize uma atualização (update) em Participante
        participante.setNome("Participante D");
        bd_participante.updateParticipante(participante);

        // Verifique se a atualização foi bem-sucedida
        Participante updatedParticipante = bd_participante.searchParticipanteById(2);
        System.out.println("Participante atualizado: " + updatedParticipante.getNome());
    }

    @Test
    void testDelete() {
        // Realize uma inserção para ter dados para exclusão
        BD_organizador bd_organizador = new BD_organizador();
        Organizador organizador = new Organizador();
        organizador.setId(3);
        organizador.setNomeEvento("Evento C");
        organizador.setNome("Organizador C");
        organizador.setCPF("333.333.333-33");
        organizador.setIdade(35);
        bd_organizador.insertOrganizador(organizador);

        // Realize uma exclusão (delete) em Organizador
        bd_organizador.deleteOrganizador(3);

        // Verifique se a exclusão foi bem-sucedida
        Organizador deletedOrganizador = bd_organizador.searchOrganizadorById(3);
        System.out.println("Organizador excluído: " + (deletedOrganizador == null ? "Não encontrado" : deletedOrganizador.getNome()));
    }
}
