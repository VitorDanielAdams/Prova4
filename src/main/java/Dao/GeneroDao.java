package Dao;

import Factory.ConectionFactory;
import Model.Biblioteca;
import Model.Genero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeneroDao {

    private Connection connection;

    public GeneroDao(){
        this.connection = ConectionFactory.getConection();
    }

    public void criarTabelaGenero(){
        String sql = "CREATE TABLE IF NOT EXISTS generos (" +
                "id_genero INT PRIMARY KEY AUTO_INCREMENT," +
                "nome_genero VARCHAR(50) NOT NULL" +
                ");";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void cadastrarGenero(Genero genero){
        String sql = "INSERT INTO generos " +
                "(nome_genero) " +
                "VALUES (?)";
        try {

            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, genero.getNome_genero());
            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()){
                genero.setId_genero(resultSet.getInt(1));
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public List<Genero> listarGeneros(){
        String sql = "SELECT * FROM generos";

        try {
            List<Genero> listaDeGeneros = new ArrayList<>();

            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Genero genero = new Genero();

                genero.setId_genero(resultSet.getInt("id_genero"));
                genero.setNome_genero(resultSet.getString("nome_genero"));

                listaDeGeneros.add(genero);
            }

            return listaDeGeneros;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public Genero getGeneroById(int id){
        String sql = "SELECT * FROM generos WHERE id_genero = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Genero genero = new Genero();

                genero.setId_genero(resultSet.getInt("id_genero"));
                genero.setNome_genero(resultSet.getString("nome_genero"));

                return genero;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void editarGenero(Genero genero){
        String sql = "UPDATE generos SET nome_genero = ? WHERE id_genero = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, genero.getNome_genero());
            stmt.setInt(2, genero.getId_genero());

            stmt.execute();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
