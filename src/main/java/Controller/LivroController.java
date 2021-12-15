package Controller;

import Dao.BibliotecaDao;
import Dao.LivroDao;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import java.util.List;

public class LivroController {

    public void criarTabelaLivro(){
        LivroDao livroDao = new LivroDao();
        livroDao.criarTabelaLivro();
    }

    public void cadastrarLivro(Livro livro){
        LivroDao livroDao = new LivroDao();
        livroDao.cadastrarLivro(livro);
    }

    public List<Livro> listarTodosLivros(){
        LivroDao livroDao = new LivroDao();
        return livroDao.listarTodosLivros();
    }

    public Livro getLivroById(int id){
        LivroDao livroDao = new LivroDao();
        return livroDao.getLivroById(id);
    }

    public List<Livro> listarLivrosBiblioteca(Biblioteca biblioteca){
        LivroDao livroDao = new LivroDao();
        return livroDao.listarLivrosBiblioteca(biblioteca);
    }

    public List<Livro> listarLivrosGenero(Genero genero){
        LivroDao livroDao = new LivroDao();
        return livroDao.listarLivrosGenero(genero);
    }
}
