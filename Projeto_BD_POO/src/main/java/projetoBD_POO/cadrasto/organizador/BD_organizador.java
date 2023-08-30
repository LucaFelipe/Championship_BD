package projetoBD_POO.cadrasto.organizador;

import java.sql.SQLException;

import projetoBD_POO.database.Database;

public class BD_organizador extends Database implements OrganizadorCRUD {
    private boolean check = false;

    @Override
	public boolean insertOrganizador(Organizador organizador) {
        connect();
        String sql = "INSERT INTO Organizador (id, nomeEvento,  nome, CPF, idade) VALUES (?, ?, ?, ?, ?);";
 
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, organizador.getId());
            pst.setString(2, organizador.getNomeEvento());
            pst.setString(3, organizador.getNome());
            pst.setInt(4, organizador.getIdade());
            pst.setString(5, organizador.getCPF());
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
	public boolean searchOrganizador(int id) {
        connect();
        String sql = "SELECT * FROM Organizador WHERE IdOrganizador = ?;";
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
    
    @Override
	public boolean updateOrganizador(Organizador organizador, int id) {
        connect();
        String sql = "UPDATE Organizador SET nomeEvento = ?, nome = ?, CPF = ?, idade = ? WHERE IdOrganizador = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, organizador.getNome());
            pst.setString(2, organizador.getNomeEvento());
            pst.setInt(3, organizador.getIdade());
            pst.setString(4, organizador.getCPF());
            pst.setInt(5, id);
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
	public boolean deleteOrganizador(int id) {
        connect();
        String sql = "DELETE FROM Organizador WHERE IdOrganizador=?;";
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
