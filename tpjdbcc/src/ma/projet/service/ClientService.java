package ma.projet.service;
import ma.projet.beans.client;
import ma.projet.dao.IDao;
import ma.projet.connexion.connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService implements IDao<client> {
    public boolean create(client client) {
        String query = "INSERT INTO client (nom, prenom) VALUES (?, ?)";
        try (Connection connection = connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, client.getNom());
            preparedStatement.setString(2, client.getPrenom());
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(client client) {
        String query = "DELETE FROM client WHERE id=?";
        try (Connection connection = connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, client.getId());
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(client client) {
        String query = "UPDATE client SET nom=?, prenom=? WHERE id=?";
        try (Connection connection = connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, client.getNom());
            preparedStatement.setString(2, client.getPrenom());
            preparedStatement.setInt(3, client.getId());
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public client findById(int id) {
        String query = "SELECT * FROM client WHERE id=?";
        try (Connection connection = connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int clientId = resultSet.getInt("id");
                    String nom = resultSet.getString("nom");
                    String prenom = resultSet.getString("prenom");
                    return new client(clientId, nom, prenom);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<client> findAll() {
        List<client> clients = new ArrayList<>();
        String query = "SELECT * FROM client";
        try (Connection connection = connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                clients.add(new client(id, nom, prenom));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
}
