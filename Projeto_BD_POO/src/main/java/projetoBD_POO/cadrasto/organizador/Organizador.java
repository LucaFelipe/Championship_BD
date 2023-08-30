package projetoBD_POO.cadrasto.organizador;

import projetoBD_POO.cadrasto.Cadrasto;

public class Organizador extends Cadrasto {
    private int id;
    private String nomeEvento;
 

	public Organizador(int id, String nomeEvento) {
        super(Nome, Idade, CPF);
        this.id = id;
        this.nomeEvento = nomeEvento;
    }
    
    public Organizador() {}

	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
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

    public void mostrarInfo(){
        System.out.println("Mostrando informações do Organizador: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getId());
        System.out.println("CPF: " + getCPF());
    }
}
