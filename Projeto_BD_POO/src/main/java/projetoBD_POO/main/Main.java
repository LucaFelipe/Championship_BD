package projetoBD_POO.main;

import java.util.Scanner;

import projetoBD_POO.cadrasto.organizador.BD_organizador;
import projetoBD_POO.cadrasto.organizador.Organizador;
import projetoBD_POO.cadrasto.participante.BD_participante;
import projetoBD_POO.cadrasto.participante.Participante;
import projetoBD_POO.cadrasto.partida.BD_Partida;
import projetoBD_POO.cadrasto.partida.Partida;
import projetoBD_POO.classificação.BD_Classificacao;
import projetoBD_POO.classificação.Classificacao;

public class Main {
	
	static BD_organizador bd_organizador = new BD_organizador();
    static Organizador organizador = new Organizador();
    
    static BD_participante bd_participante= new BD_participante();
    static Participante participante = new Participante();
    
    static BD_Partida bd_Partida = new BD_Partida();
    static Partida partida = new Partida();
    
    static BD_Classificacao bd_Classificacao = new BD_Classificacao();
    static Classificacao classificacao = new Classificacao();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int choice;
        
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Inserir");
            System.out.println("2. Procurar");
            System.out.println("3. Atualizar");
            System.out.println("4. Excluir");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    insertOptions();
                    break;
                case 2:
                    searchOptions();
                    break;
                case 3:
                    updateOptions();
                    break;
                case 4:
                    deleteOptions();
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            
            System.out.println();
        } while (choice != 0);
        
        scanner.close();
    }
    
    private static void insertOptions() {
        Scanner scanner = new Scanner(System.in);
        
        
        int choice;
        
        do {
            System.out.println("Escolha o que deseja inserir:");
            System.out.println("1. Organizador");
            System.out.println("2. Participante");
            System.out.println("3. Partida");
            System.out.println("4. Classificação");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Inserindo um organizador...");
                    System.out.println("ID do organizador:");
                    organizador.setId(scanner.nextInt());
                    System.out.println("Insira o nome do evento:");
                    scanner.nextLine();
                    organizador.setNomeEvento(scanner.nextLine());
                    System.out.println("Nome do organizador:");
                    organizador.setNome(scanner.nextLine());
                    System.out.println("CPF do organizador:");
                    organizador.setCPF(scanner.nextLine());
                    System.out.println("Idade do organizador:");
                    organizador.setIdade(scanner.nextInt());
                    bd_organizador.insertOrganizador(organizador);
                    break;
                case 2:
                    System.out.println("Inserindo um participante...");
                    System.out.println("Insira o ID do participante...");
                    participante.setId(scanner.nextInt());
                    System.out.println("Insira o nome do participante...");
                    participante.setNome(scanner.nextLine());
                    System.out.println("Insira o CPF do participante...");
                    participante.setCPF(scanner.nextLine());
                    System.out.println("Insira a idade do participante...");
                    participante.setIdade(scanner.nextInt());
                    System.out.println("Insira a quantidade de vitoria do participante...");
                    participante.setQtdVitoria(scanner.nextInt());
                    System.out.println("Insira o ID do organizador");
                    participante.setOrganizador_idOrganizador(scanner.nextInt()); 
                    bd_participante.insertParticipante(participante);
                    break; 
                case 3:
                    System.out.println("Inserindo uma partida...");
                    System.out.println("Insira o ID do organizador");
                    partida.setOrganizador_IdOrganizador(scanner.nextInt());
                    System.out.println("Insira o ID do participante 1...");
                    partida.setParticipante_IdParticpant1(scanner.nextInt());
                    System.out.println("Insira o ID do participante 2...");
                    partida.setParticipante_IdParticpante2(scanner.nextInt());
                    System.out.println("Insira um ID para a partida...");
                    partida.setIdPartida(scanner.nextInt());
                    bd_Partida.insertPartida(partida);
                    break;
                case 4:
                	System.out.println("Inserindo classificação...");
                	System.out.println("Insira o ID da tabela de classificação...");
                	classificacao.setIdClassificacao(scanner.nextInt());
                	System.out.println("Insira ID do participante...");
                	classificacao.setParticipante_IdParticipante(scanner.nextInt());
                	System.out.println("Insira a posição do participante no torneio...");
                	classificacao.setPosicao(scanner.nextInt());
                	System.out.println("Insira o ID de seu organizador:");
                	classificacao.setOrganizador_IdOrganizador(scanner.nextInt());
                	bd_Classificacao.insertClassificacao(classificacao);
                	break;
                case 0:
                    System.out.println("Voltando ao menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            
            System.out.println();
        } while (choice != 0);
        
        scanner.close();
    }
    
    private static void searchOptions() {
        Scanner scanner = new Scanner(System.in);
        
        int choice;
        
        do {
            System.out.println("Escolha o que deseja buscar:");
            System.out.println("1. Organizador");
            System.out.println("2. Participante");
            System.out.println("3. Partida");
            System.out.println("4. Classificação");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Buscando um organizador...");
                    System.out.println("Insira o ID do organizador...");
                    bd_organizador.searchOrganizador(scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Buscando um participante...");
                    System.out.println("Insira o ID do participante e o ID do Organizador:");
                    bd_participante.searchParticipante(scanner.nextInt(), scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Buscando uma partida...");
                    System.out.println("Insira o ID da partida e o ID do Organizador");
                    bd_Partida.searchPartida(scanner.nextInt(), scanner.nextInt());
                    break;
                case 4:
                	System.out.println("Buscando a classificação...");
                	System.out.println("Insira o ID da classificação");
                	bd_Classificacao.searchClassificacao(scanner.nextInt(), scanner.nextInt());
                	break;
                case 0:
                    System.out.println("Voltando ao menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            
            System.out.println();
        } while (choice != 0);
        
        scanner.close();
    }
    
    private static void updateOptions() {
        Scanner scanner = new Scanner(System.in);
        
        int choice;
        
        do {
            System.out.println("Escolha o que deseja atualizar:");
            System.out.println("1. Organizador");
            System.out.println("2. Participante"); 
            System.out.println("3. Partida");
            System.out.println("4. Classificação");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Atualizando um organizador...");
                    System.out.println("Inserindo novas informações do organizador...");
                    System.out.println("Insira o nome do organizador:");
                    organizador.setNome(scanner.nextLine());
                    System.out.println("Insira a nova idade do organizador:");
                    organizador.setIdade(scanner.nextInt());
                    System.out.println("Insira o CPF do organizador");
                    organizador.setCPF(scanner.nextLine());
                    System.out.println("Insira o ID do organizador a ser atualizado:");
                    bd_organizador.updateOrganizador(organizador, scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Atualizando um participante...");
                    System.out.println("Inserindo novas informações do participante...");
                    System.out.println("Insira o nome do participante:");
                    participante.setNome(scanner.nextLine());
                    System.out.println("Insira a nova idade do participante:");
                    participante.setIdade(scanner.nextInt());
                    System.out.println("Insira o CPF do participante");
                    participante.setCPF(scanner.nextLine());
                    System.out.println("Insira o ID do participante a ser atualizado:");
                    participante.setId(scanner.nextInt());
                    bd_participante.updateParticipante(participante, scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Atualizando uma partida...");
                    System.out.println("Inserindo novas informações da partida...");
                    System.out.println("Insira o ID do participante 1:");
                    partida.setParticipante_IdParticpant1(scanner.nextInt());
                    System.out.println("Insira o ID do participante 2:");
                    partida.setParticipante_IdParticpante2(scanner.nextInt());
                    System.out.println("Insira o ID da partida a ser atualizado...");
                    bd_Partida.updatePartida(partida, scanner.nextInt(), scanner.nextInt());
                    break;
                case 4:
                	System.out.println("Atualizando classificação...");
                	System.out.println("Insira a posição do participante a ser atualizado:");
                	classificacao.setPosicao(scanner.nextInt());
                	System.out.println("Insira o ID do participante a ser atualizado");
                	classificacao.setParticipante_IdParticipante(scanner.nextInt());
                    System.out.println("Insira o ID da classificação a ser atualizada e o ID de seu organizador:");
                    bd_Classificacao.updateClassificacao(classificacao, scanner.nextInt(), scanner.nextInt());
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            
            System.out.println();
        } while (choice != 0);
        
        scanner.close();
    }
    
    private static void deleteOptions() {
        Scanner scanner = new Scanner(System.in);
        
        int choice;
        
        do {
            System.out.println("Escolha o que deseja excluir:");
            System.out.println("1. Organizador");
            System.out.println("2. Participante");
            System.out.println("3. Partida");
            System.out.println("4. Classificação");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Excluindo um organizador...");
                    System.out.println("Insira o ID do organizador a ser excluído...");
                    bd_organizador.deleteOrganizador(scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Excluindo um participante...");
                    System.out.println("Insira o ID do participante a ser excluído e o ID do Organizador");
                    bd_participante.deleteParticipante(scanner.nextInt(), scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Excluindo uma partida...");
                    System.out.println("Insira o ID da partida a ser excluída...");
                    bd_Partida.deletePartida(scanner.nextInt(), scanner.nextInt());
                    break;
                case 4:
                	System.out.println("Excluindo classificação...");
                	System.out.println("Insira o ID da Tabela de classificação e o ID de seu Organizador");
                	bd_Classificacao.deleteClassificacao(scanner.nextInt(), scanner.nextInt());
                	break;
                case 0:
                    System.out.println("Voltando ao menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            
            System.out.println();
        } while (choice != 0);
        
        scanner.close();
    }
}
