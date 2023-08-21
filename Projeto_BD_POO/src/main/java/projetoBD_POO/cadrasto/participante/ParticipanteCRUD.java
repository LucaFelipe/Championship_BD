package projetoBD_POO.cadrasto.participante;

public interface ParticipanteCRUD {
	boolean insertParticipante(Participante participante);
	
	boolean updateParticipante(Participante participante, int id);

	boolean searchParticipante(Participante participante, int id);

	boolean deleteParticipante(Participante participante, int id);
}