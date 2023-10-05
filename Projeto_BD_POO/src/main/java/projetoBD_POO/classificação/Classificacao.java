package projetoBD_POO.classificação;

public class Classificacao {
    private int idClassificacao;
    private int posicao;
    private int Participante_IdParticipantes;
    private int Organizador_IdOrganizador;
    
    
    public int getOrganizador_IdOrganizador() {
		return Organizador_IdOrganizador;
	}

	public void setOrganizador_IdOrganizador(int organizador_IdOrganizador) {
		Organizador_IdOrganizador = organizador_IdOrganizador;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

    public Classificacao() {
        super();
    }

    public int getParticipante_IdParticipante() {
        return Participante_IdParticipantes;
    }

    public void setParticipante_IdParticipante(int participante_IdParticipante) {
        Participante_IdParticipantes = participante_IdParticipante;
    }

	public int getIdClassificacao() {
		return idClassificacao;
	}

	public void setIdClassificacao(int idClassificacao) {
		this.idClassificacao = idClassificacao;
	}
}
