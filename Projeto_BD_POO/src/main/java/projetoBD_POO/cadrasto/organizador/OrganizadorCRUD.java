package projetoBD_POO.cadrasto.organizador;

public interface OrganizadorCRUD {

	boolean insertOrganizador(Organizador organizador);

	boolean searchOrganizador(Organizador organizador, int id);

	boolean updateOrganizador(Organizador organizador, int id);

	boolean deleteOrganizador(Organizador organizador, int id);
}