package projetoBD_POO.cadrasto.participante;

import projetoBD_POO.cadrasto.Cadrasto;

public class Participante extends Cadrasto{
    private int qtdVitoria = 0;
    private int idParticipante;
    private int organizadorIdOrganizador;


    public int getOrganizador_idOrganizador() {
        return organizadorIdOrganizador;
    }

    public void setOrganizador_idOrganizador(int organizador_idOrganizador) {
        organizadorIdOrganizador = organizador_idOrganizador;
    }

    public Participante(String Nome, int Idade, String CPF, int qtdVitoria, int idParticipante, int organizadorIdOrganizador) {
		super(Nome, Idade, CPF);
		this.qtdVitoria = qtdVitoria;
		this.idParticipante = idParticipante;
		this.organizadorIdOrganizador = organizadorIdOrganizador;
	}

	public Participante() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
        return idParticipante;
    }
    public void setId(int id) {
    	this.idParticipante = id;
    }

    public String getNome(){
    	return Nome;
    }
    public void setNome(String Nome){
    	Cadrasto.Nome = Nome;
    }

    public int getIdade(){
    	return Idade;
    }
    public void setIdade(int Idade){
    	Cadrasto.Idade = Idade;
    }

    public String getCPF(){
    	return CPF;
    }
    public void setCPF(String CPF){
    	Cadrasto.CPF = CPF;
    }

    public int getQtdVitoria() {
        return qtdVitoria;
    }
    public void setQtdVitoria(int qtdVitoria) {
        this.qtdVitoria = qtdVitoria;
    }

    public void mostraInfo(){
        System.out.println("Mostrando informações do participante: ");
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getId());
        System.out.println("CPF: " + getCPF());
        System.out.println("Quantidade de vitótia: " + getQtdVitoria());
    }

}
