package projetoBD_POO.cadrasto.partida;

public interface PartidaCRUD {

	boolean insertPartida(Partida partida, int id);

	boolean searchPartida(Partida enfrenta, int id);

	boolean updatePartida(Partida enfrenta, int id);

	boolean deletePartida(Partida partida, int id);
	
}