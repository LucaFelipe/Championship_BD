package projetoBD_POO.cadrasto.participante;

import projetoBD_POO.cadrasto.Cadrasto;

public class Participante extends Cadrasto{
    private static int contador = 0;
    private int qtdVitoria = 0;
    private int IdParticipante;
    private int organizadorIdOrganizador;


    public int getOrganizador_idOrganizador() {
        return organizadorIdOrganizador;
    }

    public void setOrganizador_idOrganizador(int organizador_idOrganizador) {
        organizadorIdOrganizador = organizador_idOrganizador;
    }

    public Participante(String nome) {
        super(nome);
    }

    public Participante() {
        contador++;
        IdParticipante=contador;
    }

    public int getId() {
        return IdParticipante;
    }
    public void setId(int id) {
    }

    public String getNome(){return Nome;}
    public void setNome(String Nome){this.Nome = Nome;}

    public int getIdade(){return Idade;}
    public void setIdade(int Idade){this.Idade = Idade;}

    public String getCPF(){return CPF;}
    public void setCPF(String CPF){this.CPF = CPF;}

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
