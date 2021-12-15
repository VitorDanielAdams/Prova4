package Controller;

import Dao.BibliotecaDao;
import Model.Biblioteca;
import Model.Livro;

import java.util.List;

public class BibliotecaController {

    public void criarTabelaBiblioteca(){
        BibliotecaDao bibliotecaDao = new BibliotecaDao();
        bibliotecaDao.criarTabelaBiblioteca();
    }

    public void cadastrarBiblioteca(Biblioteca biblioteca){
        BibliotecaDao bibliotecaDao = new BibliotecaDao();
        bibliotecaDao.cadastrarBiblioteca(biblioteca);
    }

    public List<Biblioteca> listarTodasBibliotecas(){
        BibliotecaDao bibliotecaDao = new BibliotecaDao();
        return bibliotecaDao.listarTodasBibliotecas();
    }

    public Biblioteca getBibliotecaById(int id){
        BibliotecaDao bibliotecaDao = new BibliotecaDao();
        return bibliotecaDao.getBibliotecaById(id);
    }

}
