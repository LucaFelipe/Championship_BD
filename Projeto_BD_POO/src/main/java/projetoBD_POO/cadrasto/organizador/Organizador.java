package projetoBD_POO.cadrasto.organizador;

import projetoBD_POO.cadrasto.Cadrasto;

public class Organizador extends Cadrasto {
    private int id;
    public Organizador(int id, String Nome, int Idade, String CPF) {
        super(Nome, Idade, CPF);
    }

    public Organizador(String nome) {
        super(nome);
    }

    public Organizador() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome(){return Nome;}
    public void setNome(String Nome){this.Nome = Nome;}

    public int getIdade(){return Idade;}
    public void setIdade(int Idade){this.Idade = Idade;}

    public String getCPF(){return CPF;}
    public void setCPF(String CPF){this.CPF = CPF;}

    public void mostrarInfo(){
        System.out.println("Mostrando informações do Organizador: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getId());
        System.out.println("CPF: " + getCPF());
    }
}
