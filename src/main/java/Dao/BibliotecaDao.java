package Dao;

import Factory.ConectionFactory;
import Model.Biblioteca;
import Model.Genero;
import com.mysql.cj.jdbc.ClientPreparedStatement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaDao {

    private Connection connection;

    public BibliotecaDao(){
        this.connection = ConectionFactory.getConection();
    }

    public void criarTabelaBiblioteca(){
        String sql = "CREATE TABLE IF NOT EXISTS bibliotecas (" +
                "id_biblioteca INT PRIMARY KEY AUTO_INCREMENT," +
                "nome_biblioteca VARCHAR(50) NOT NULL" +
                ");";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.execute();
            stmt.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void cadastrarBiblioteca(Biblioteca biblioteca){
        String sql = "INSERT INTO bibliotecas " +
                "(nome_biblioteca) " +
                "VALUES (?)";
        try {

            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, biblioteca.getNome_biblioteca());
            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()){
                biblioteca.setId_biblioteca(resultSet.getInt(1));
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public List<Biblioteca> listarTodasBibliotecas(){
        String sql = "SELECT * FROM bibliotecas";

        try {
            List<Biblioteca> listaDeBibliotecas = new ArrayList<>();

            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){

                Biblioteca biblioteca = new Biblioteca();

                biblioteca.setId_biblioteca(resultSet.getInt("id_biblioteca"));
                biblioteca.setNome_biblioteca(resultSet.getString("nome_biblioteca"));

                listaDeBibliotecas.add(biblioteca);
            }

            return listaDeBibliotecas;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public Biblioteca getBibliotecaById(int id){
        String sql = "SELECT * FROM bibliotecas WHERE id_biblioteca = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Biblioteca biblioteca = new Biblioteca();

                biblioteca.setId_biblioteca(resultSet.getInt("id_biblioteca"));
                biblioteca.setNome_biblioteca(resultSet.getString("nome_biblioteca"));

                return biblioteca;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
