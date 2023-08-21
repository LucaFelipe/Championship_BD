package projetoBD_POO.classificação;

public interface ClassificacaoCRUD {

	void insertClassificacao(Classificacao classificacao);

	boolean searchClassificacao(Classificacao classificacao, int id);
	
	void updateClassificacao(Classificacao classificacao, int id);
	
	void deleteClassificacao(Classificacao classificacao, int id);

}