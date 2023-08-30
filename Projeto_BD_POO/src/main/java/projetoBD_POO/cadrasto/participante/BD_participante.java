package projetoBD_POO.cadrasto.participante;

import java.sql.SQLException;

import projetoBD_POO.database.Database;

public class BD_participante extends Database implements ParticipanteCRUD {
    private boolean check = false;

    @Override
    public boolean insertParticipante(Participante participante) {
        connect();
        String sql = "INSERT INTO Participante (id, nome, CPF, Idade,  qtdVitoria, idOrganizador) VALUES (?, ?, ?, ?, ?, ?);";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, participante.getId());
            pst.setString(2, participante.getNome()); 
            pst.setString(3, participante.getCPF());
            pst.setInt(4, participante.getIdade());
            pst.setInt(5, participante.getQtdVitoria());
            pst.setInt(6, participante.getOrganizador_idOrganizador());
            
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
    public boolean updateParticipante(Participante participante, int idOrganizador) {
        connect();
        String sql = "UPDATE Participante SET nome=?, CPF=?, idade=?, qtdVitoria=? WHERE id=? AND idOrganizador=?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, participante.getNome());
            pst.setString(2, participante.getCPF());
            pst.setInt(3, participante.getIdade());
            pst.setInt(4, participante.getQtdVitoria());
            pst.setInt(5, participante.getId());
            pst.setInt(6, idOrganizador);
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
    public boolean deleteParticipante(int id, int idOrganizador) {
        connect();
        String sql = "DELETE FROM Participante WHERE IdParticipante=? AND idOrganizador=?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setInt(2, idOrganizador);
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
    public boolean searchParticipante(int id, int idOrganizador) {
        connect();
        String sql = "SELECT * FROM Participante WHERE IdParticipante=? AND idOrganizador=?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setInt(2, idOrganizador);
            resultSet = pst.executeQuery();
            check = resultSet.next();
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
            if (resultSet != null) {
                resultSet.close();
            }
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
