package projetoBD_POO.cadrasto.participante;

public interface ParticipanteCRUD {
	boolean insertParticipante(Participante participante);
	
	boolean updateParticipante(Participante participante, int idOrganizador);

	boolean searchParticipante(int id, int idOrganizador);

	boolean deleteParticipante(int id, int idOrganizador);
}