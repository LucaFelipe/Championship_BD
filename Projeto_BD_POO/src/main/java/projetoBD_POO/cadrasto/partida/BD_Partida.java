package projetoBD_POO.cadrasto.partida;

import java.sql.SQLException;

import projetoBD_POO.database.Database;

public class BD_Partida extends Database implements PartidaCRUD {
    private boolean check = false;

    @Override
    public boolean insertPartida(Partida partida) {
        connect();
        String sql = "INSERT INTO Enfrentar (id, idOrganizador, idParticipante1, idParticipante2) VALUES (?, ?, ?, ?);";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, partida.getIdPartida());
            pst.setInt(2, partida.getParticipante_IdParticpante1());
            pst.setInt(3, partida.getParticipante_IdParticpante2());
            pst.setInt(4, partida.getOrganizador_IdOrganizador());
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
    public boolean searchPartida(int id, int idOrganizador) {
        connect();
        String sql = "SELECT * FROM Enfrentar WHERE IdPartida = ? AND idOrganizador = ?;";
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

    @Override
    public boolean updatePartida(Partida partida, int id, int idOrganizador) {
        connect();
        String sql = "UPDATE Enfrentar SET Participante_idParticipante1 = ?, Participante_idParticipante2 = ? WHERE IdPartida = ? AND idOrganizador = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, partida.getParticipante_IdParticpante1());
            pst.setInt(2, partida.getParticipante_IdParticpante2());
            pst.setInt(3, id);
            pst.setInt(4, idOrganizador);
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
    public boolean deletePartida(int id, int idOrganizador) {
        connect();
        String sql = "DELETE FROM Enfrentar WHERE IdPartida = ? AND idOrganizador = ?;";
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
