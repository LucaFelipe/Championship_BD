package projetoBD_POO.classificação;

import java.sql.SQLException;

import projetoBD_POO.database.Database;

public class BD_Classificacao extends Database implements ClassificacaoCRUD {
    private boolean check = false;

    public BD_Classificacao() {
        super();
    }

    @Override
    public void insertClassificacao(Classificacao classificacao) {
        connect();
        String sql = "INSERT INTO Classificacao (posicao, idParticipante, idOrganizador) VALUES (?, ?, ?);";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, classificacao.getPosicao());
            pst.setInt(2, classificacao.getParticipante_IdParticipante());
            pst.setInt(3, classificacao.getOrganizador_IdOrganizador());
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
    public boolean searchClassificacao(int id, int idOrganizador) {
        connect();
        String sql = "SELECT * FROM Classificacao WHERE id = ? AND idOrganizador = ?;";
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
    public void updateClassificacao(Classificacao classificacao, int idClassificao, int idOrganizador) {
        connect();
        String sql = "UPDATE Classificacao SET posicao = ?, idParticipante = ?, idOrganizador = ? WHERE id = ? AND idOrganizador = ?;";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, classificacao.getPosicao());
            pst.setInt(2, classificacao.getParticipante_IdParticipante());
            pst.setInt(3, classificacao.getOrganizador_IdOrganizador());
            pst.setInt(4, idClassificao);
            pst.setInt(5, idOrganizador);
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
    public void deleteClassificacao(int id, int idOrganizador) {
        connect();
        String sql = "DELETE FROM Classificacao WHERE id = ? AND idOrganizador = ?;";

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
