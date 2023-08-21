package projetoBD_POO.cadrasto.partida;

import java.sql.SQLException;

import projetoBD_POO.bancoBD.Database;

public class BD_Partida extends Database implements PartidaCRUD {
    private boolean check = false;

    @Override
	public boolean insertPartida(Partida partida, int id) {
        connect();
        String sql = "INSERT INTO Enfrentar (Participante_idParticipante1, Participante_idParticipante2) VALUES (?, ?);";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(partida.getIdPartida(), id);
            pst.setInt(partida.getParticipante_IdParticpante1(), id);
            pst.setInt(partida.getParticipante_IdParticpante2(), id);
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
	public boolean searchPartida(Partida partida, int id) {
        connect();
        String sql = "SELECT * FROM Enfrenta WHERE Participante_IdPaticipante = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(id, partida.getIdPartida());
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
	public boolean updatePartida(Partida partida, int id) {
        connect();
        String sql = "UPDATE Partida SET Participante_idParticipante1 = ?, Participante_idParticipante2 = ? WHERE IdPartida = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(id, partida.getParticipante_IdParticpante1());
            pst.setInt(id, partida.getParticipante_IdParticpante2());
            pst.setInt(id, partida.getIdPartida());
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

    @Override
	public boolean deletePartida(Partida partida, int id) {
        connect();
        String sql = "DELETE FROM Enfrentar WHERE IdEnfrentar = ?;";
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
