package projetoBD_POO.cadrasto.participante;

import java.sql.SQLException;

import projetoBD_POO.bancoBD.Database;

public class BD_participante extends Database implements ParticipanteCRUD {
    private boolean check = false;

    @Override
	public boolean insertParticipante(Participante participante){
        connect();
        String sql = "INSERT INTO Participante (IdParticipante, Nome, CPF, Idade, Organizador_idOrganizador, Qtd_Vitoria) VALUES (?, ?, ?, ?, ?, ?);";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, participante.getId());
            pst.setString(2, participante.getNome());
            pst.setString(3, participante.getCPF());
            pst.setInt(4, participante.getIdade());
            pst.setInt(5, participante.getOrganizador_idOrganizador());
            pst.setInt(6, participante.getQtdVitoria());
            pst.executeUpdate();
            check = true;

        } catch (SQLException exception) {
            System.out.println("Erro de operação: " + exception.getMessage());
            check = false;
        } finally {
            closeResources();
        }
        return check;
    }

    @Override
	public boolean updateParticipante(Participante participante, int id){
        connect();
        String sql = "UPDATE Participante SET Nome=?, CPF=?, Idade=? WHERE IdParticipante=?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, participante.getNome());
            pst.setString(2, participante.getCPF());
            pst.setInt(3, participante.getIdade());
            pst.setInt(4, id);

            pst.executeUpdate();
            check = true;
        }catch (SQLException exception){
            System.out.println("Erro de operação: " + exception.getMessage());
            check = false;
        } finally {
            closeResources();
        }
        return check;
    }

    @Override
	public boolean deleteParticipante(Participante participante, int id){
        connect();
        String sql = "DELETE FROM Participante WHERE IdParticipante=?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(id, participante.getId());
            pst.executeUpdate();
            check = true;
        }catch (SQLException exception){
            System.out.println("Erro de operação: " + exception.getMessage());
            check = false;
        } finally {
            closeResources();
        }
        return check;
    }
    
    @Override
	public boolean searchParticipante(Participante participante, int id){
        connect();
        String sql = "SELECT * FROM Participante WHERE IdParticipante=?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            check = true;
        } catch (SQLException exception) {
            System.out.println("Erro de operação: " + exception.getMessage());
            check = false;
        } finally {
            closeResources();
        }
        return check;
    }

    private void closeResources() {
        try {
            if (pst != null) {
                pst.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException exception) {
            System.out.println("Erro ao fechar a conexão: " + exception.getMessage());
        }
    }
}
