package Dao;

import Factory.ConectionFactory;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDao {

    private Connection connection;

    public LivroDao(){
        this.connection = ConectionFactory.getConection();
    }

    public void criarTabelaLivro(){
        String sql = "CREATE TABLE IF NOT EXISTS livros (" +
                "id_livro INT PRIMARY KEY AUTO_INCREMENT," +
                "nome_livro VARCHAR(50) NOT NULL," +
                "autor VARCHAR(50) NOT NULL," +
                "id_biblioteca_fk INT," +
                "id_genero_fk INT," +
                "FOREIGN KEY (id_biblioteca_fk) " +
                "REFERENCES bibliotecas(id_biblioteca)," +
                "FOREIGN KEY (id_genero_fk) " +
                "REFERENCES generos(id_genero)" +
                ");";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void cadastrarLivro(Livro livro) {
        String sql = "INSERT INTO livros " +
                "(nome_livro,autor,id_biblioteca_fk,id_genero_fk) " +
                "VALUES (?,?,?,?)";
        try {

            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, livro.getNome_livro());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getBiblioteca().getId_biblioteca());
            stmt.setInt(4, livro.getGenero().getId_genero());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()){
                livro.setId_livro(resultSet.getInt(1));
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Livro> listarTodosLivros(){
        String sql = "SELECT * FROM livros";

        try {

            List<Livro> listaDeLivros = new ArrayList<>();

            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Livro livro = new Livro();

                livro.setId_livro(resultSet.getInt("id_livro"));
                livro.setNome_livro(resultSet.getString("nome_livro"));
                livro.setAutor(resultSet.getString("autor"));
                BibliotecaDao bibliotecaDao = new BibliotecaDao();
                Biblioteca biblioteca = bibliotecaDao.getBibliotecaById(resultSet.getInt("id_biblioteca_fk"));
                livro.setBiblioteca(biblioteca);

                GeneroDao generoDao = new GeneroDao();
                Genero genero = generoDao.getGeneroById(resultSet.getInt("id_genero_fk"));
                livro.setGenero(genero);

                listaDeLivros.add(livro);
            }

            return listaDeLivros;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Livro getLivroById(int id){
        String sql = "SELECT * FROM livros WHERE id_livro = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Livro livro = new Livro();

                livro.setId_livro(resultSet.getInt("id_livro"));
                livro.setNome_livro(resultSet.getString("nome_livro"));
                livro.setAutor(resultSet.getString("autor"));
                BibliotecaDao bibliotecaDao = new BibliotecaDao();
                Biblioteca biblioteca = bibliotecaDao.getBibliotecaById(resultSet.getInt("id_biblioteca_fk"));
                livro.setBiblioteca(biblioteca);

                GeneroDao generoDao = new GeneroDao();
                Genero genero = generoDao.getGeneroById(resultSet.getInt("id_genero_fk"));
                livro.setGenero(genero);

                return livro;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Livro> listarLivrosBiblioteca(Biblioteca bibliotecaSelect) {
        String sql = "SELECT * FROM livros WHERE id_biblioteca_fk = ?";

        try {

            List<Livro> listaDeLivros = new ArrayList<>();

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, bibliotecaSelect.getId_biblioteca());
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Livro livro = new Livro();

                livro.setId_livro(resultSet.getInt("id_livro"));
                livro.setNome_livro(resultSet.getString("nome_livro"));
                livro.setAutor(resultSet.getString("autor"));
                BibliotecaDao bibliotecaDao = new BibliotecaDao();
                Biblioteca biblioteca = bibliotecaDao.getBibliotecaById(resultSet.getInt("id_biblioteca_fk"));
                livro.setBiblioteca(biblioteca);

                GeneroDao generoDao = new GeneroDao();
                Genero genero = generoDao.getGeneroById(resultSet.getInt("id_genero_fk"));
                livro.setGenero(genero);

                listaDeLivros.add(livro);
            }

            return listaDeLivros;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

        public List<Livro> listarLivrosGenero(Genero generoSelect) {
        String sql = "SELECT * FROM livros WHERE id_genero_fk = ?";

        try {

            List<Livro> listaDeLivros = new ArrayList<>();

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, generoSelect.getId_genero());
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Livro livro = new Livro();

                livro.setId_livro(resultSet.getInt("id_livro"));
                livro.setNome_livro(resultSet.getString("nome_livro"));
                livro.setAutor(resultSet.getString("autor"));
                BibliotecaDao bibliotecaDao = new BibliotecaDao();
                Biblioteca biblioteca = bibliotecaDao.getBibliotecaById(resultSet.getInt("id_biblioteca_fk"));
                livro.setBiblioteca(biblioteca);

                GeneroDao generoDao = new GeneroDao();
                Genero genero = generoDao.getGeneroById(resultSet.getInt("id_genero_fk"));
                livro.setGenero(genero);

                listaDeLivros.add(livro);
            }

            return listaDeLivros;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
