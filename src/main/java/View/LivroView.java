package View;


import Controller.LivroController;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import java.util.List;
import java.util.Scanner;

public class LivroView {

    public void cadastrarLivro(Biblioteca biblioteca){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");

        GeneroView generoView = new GeneroView();
        LivroController livroController = new LivroController();
        Livro livro = new Livro();
        System.out.println("--------------------------");
        System.out.println("   CADASTRAR LIVRO S      ");
        System.out.println("--------------------------");
        System.out.println("Informe o nome do livro:");
        livro.setNome_livro(entrada.next());
        System.out.println("Informe o autor do livro:");
        livro.setAutor(entrada.next());
        System.out.println("Selecione o genero do livro:");
        Genero genero = generoView.getGeneroById();
        livro.setGenero(genero);
        livro.setBiblioteca(biblioteca);

        livroController.cadastrarLivro(livro);

    }

    public List<Livro> listarTodosLivros(Biblioteca biblioteca){

        LivroController livroController = new LivroController();

        List<Livro> listaLivros = livroController.listarTodosLivros();

        if(listaLivros.isEmpty()){
            System.out.println("Nenhum livro cadastrado, cadaste um!");
            this.cadastrarLivro(biblioteca);
        }

        for (int i = 0;i < listaLivros.size();i++){
            System.out.println((i+1)+"-"+listaLivros.get(i).toString());
        }

        return listaLivros;

    }

    public Livro getLivroById(Biblioteca biblioteca){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        LivroController livroController = new LivroController();

        List<Livro> listaLivros = this.listarTodosLivros(biblioteca);
        System.out.println("Escolha um Livro: ");

        Livro livro = livroController.getLivroById(listaLivros.get(entrada.nextInt()-1).getId_livro());

        System.out.println("O livro selecionado foi: \n" + livro);

        return livro;
    }

    public void listarLivrosBiblioteca(Biblioteca biblioteca){
        LivroController livroController = new LivroController();

        List<Livro> listaLivros = livroController.listarLivrosBiblioteca(biblioteca);

        for (int i = 0;i < listaLivros.size();i++){
            System.out.println((i+1)+"-"+listaLivros.get(i).toString());
        }

    }

    public void listarLivrosGenero(Genero genero){
        LivroController livroController = new LivroController();

        List<Livro> listaLivros = livroController.listarLivrosGenero(genero);

        for (int i = 0;i < listaLivros.size();i++){
            System.out.println((i+1)+"-"+listaLivros.get(i).toString());
        }

    }
}
