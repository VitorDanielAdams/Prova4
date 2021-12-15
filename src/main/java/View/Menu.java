package View;

import Controller.BibliotecaController;
import Controller.GeneroController;
import Controller.LivroController;
import Model.Biblioteca;

import java.util.Scanner;

public class Menu {

    public void criarTabelas(){
        LivroController lc = new LivroController();
        GeneroController gc = new GeneroController();
        BibliotecaController bc = new BibliotecaController();

        lc.criarTabelaLivro();
        gc.criarTabelaGenero();
        bc.criarTabelaBiblioteca();
    }

    public void menuInicial(){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        BibliotecaView bibliotecaView = new BibliotecaView();

        System.out.println("------------------------------");
        System.out.println("  1 - Cadastrar Biblioteca    ");
        System.out.println("  2 - Listar Bibliotecas      ");
        System.out.println("  3 - Acessar Biblioteca      ");
        System.out.println("------------------------------");

        switch (entrada.nextInt()){
            case 1:
                bibliotecaView.cadastrarBiblioteca();
                this.menuInicial();
                break;
            case 2:
                bibliotecaView.listarTodasBibliotecas();
                this.menuInicial();
                break;
            case 3:
                Biblioteca biblioteca = bibliotecaView.getBibliotecaById();
                this.menu(biblioteca);
                break;
            case 0:
                break;
            default:
                System.out.println("Opcao invalida");
                this.menuInicial();
        }
    }

    public void menu(Biblioteca biblioteca){
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");

        System.out.println("------------------------------");
        System.out.println("  1 - Generos                 ");
        System.out.println("  2 - Livros                  ");
        System.out.println("  0 - Voltar                  ");
        System.out.println("------------------------------");

        switch (entrada.nextInt()){
            case 0:
                this.menuInicial();
                break;
            case 1:
                this.menuGenero(biblioteca);
                break;
            case 2:
                this.menuLivro(biblioteca);
                break;
            default:
                System.out.println("Opcao invalida");
                menu(biblioteca);
        }
    }

    public void menuGenero(Biblioteca biblioteca){
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        GeneroView generoView = new GeneroView();
        System.out.println("------------------------------");
        System.out.println("  1 - Cadastrar Genero        ");
        System.out.println("  2 - Mostrar Genero           ");
        System.out.println("  3 - Editar Genero           ");
        System.out.println("  0 - Voltar                  ");
        System.out.println("------------------------------");

        switch (entrada.nextInt()){
            case 0:
                this.menuInicial();
                break;
            case 1:
                generoView.cadastrarGenero();
                this.menuGenero(biblioteca);
                break;
            case 2:
                generoView.listarGeneros();
                this.menuGenero(biblioteca);
            case 3:
                generoView.editarGenero(generoView.getGeneroById());
                this.menuGenero(biblioteca);
                break;
            default:
                System.out.println("Opcao invalida");
                menu(biblioteca);
        }
    }

    public void menuLivro(Biblioteca biblioteca){
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        LivroView livroView = new LivroView();
        GeneroView generoView = new GeneroView();
        System.out.println("------------------------------");
        System.out.println("  1 - Cadastrar Livro        ");
        System.out.println("  2 - Mostrar livros desta biblioteca           ");
        System.out.println("  3 - Encontrar livro pelo ID           ");
        System.out.println("  4 - Mostrar livros pelo genero           ");
        System.out.println("  0 - Voltar                  ");
        System.out.println("------------------------------");

        switch (entrada.nextInt()){
            case 0:
                this.menuInicial();
                break;
            case 1:
                livroView.cadastrarLivro(biblioteca);
                this.menuLivro(biblioteca);
                break;
            case 2:
                livroView.listarLivrosBiblioteca(biblioteca);
                this.menuLivro(biblioteca);
            case 3:
                livroView.getLivroById(biblioteca);
                this.menuLivro(biblioteca);
                break;
            case 4:
                livroView.listarLivrosGenero(generoView.getGeneroById());
                this.menuLivro(biblioteca);
                break;
            default:
                System.out.println("Opcao invalida");
                menu(biblioteca);
        }
    }
}
