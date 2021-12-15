package Controller;

import Dao.GeneroDao;
import Model.Genero;

import java.util.List;

public class GeneroController {

    public void criarTabelaGenero(){
        GeneroDao generoDao = new GeneroDao();
        generoDao.criarTabelaGenero();
    }

    public void cadastrarGenero(Genero genero){
        GeneroDao generoDao = new GeneroDao();
        generoDao.cadastrarGenero(genero);
    }

    public List<Genero> listarGeneros(){
        GeneroDao generoDao = new GeneroDao();
        return generoDao.listarGeneros();
    }

    public Genero getGeneroById(int id){
        GeneroDao generoDao = new GeneroDao();
        return generoDao.getGeneroById(id);
    }

    public void editarGenero(Genero genero){
        GeneroDao generoDao = new GeneroDao();
        generoDao.editarGenero(genero);
    }
}
