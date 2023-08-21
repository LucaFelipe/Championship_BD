package projetoBD_POO.classificação;

import java.sql.SQLException;

import projetoBD_POO.bancoBD.Database;

public class BD_Classificacao extends Database implements ClassificacaoCRUD {
    private boolean check = false;

    public BD_Classificacao() {
        super();
    }

    @Override
	public void insertClassificacao(Classificacao classificacao) {
        connect();
        String sql = "INSERT INTO Classificacao (idClassificacao, Posicao, Participante_IdParticipante) VALUES (?, ?, ?);";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, classificacao.getIdClassificacao());
            pst.setInt(2, classificacao.getPosicao());
            pst.setInt(3, classificacao.getParticipante_IdParticipante());
            pst.executeUpdate();
            check = true;
        } catch (SQLException exception) {
            System.out.println("Erro de operação: " + exception.getMessage());
            check = false;
        } finally {
            closeResources();
        }
    }

    @Override
	public boolean searchClassificacao(Classificacao classificacao, int id) {
        connect();
        String sql = "SELECT * FROM Classificacao WHERE idClassificacao = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(id, classificacao.getIdClassificacao());
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
	public void updateClassificacao(Classificacao classificacao, int id) {
        connect();
        String sql = "UPDATE Classificacao SET Posicao = ?, Participante_IdParticipante = ? WHERE idPremiacao = ?;";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(id, classificacao.getIdClassificacao());
            pst.setInt(id, classificacao.getParticipante_IdParticipante());
            pst.setInt(id, classificacao.getPosicao());
            pst.executeUpdate();
            check = true;
        } catch (SQLException exception) {
            System.out.println("Erro de operação: " + exception.getMessage());
            check = false;
        } finally {
            closeResources();
        }
    }

    @Override
	public void deleteClassificacao(Classificacao classificacao, int id) {
        connect();
        String sql = "DELETE FROM Classificação WHERE idClassificacao = ?;";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(id, classificacao.getIdClassificacao());
            pst.executeUpdate();
            check = true;
        } catch (SQLException exception) {
            System.out.println("Erro de operação: " + exception.getMessage());
            check = false;
        } finally {
            closeResources();
        }
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
