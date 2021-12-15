package View;

import Controller.BibliotecaController;
import Controller.LivroController;
import Model.Biblioteca;
import Model.Livro;

import java.util.List;
import java.util.Scanner;

public class BibliotecaView {

    public void cadastrarBiblioteca(){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");

        BibliotecaController bibliotecaController = new BibliotecaController();
        Biblioteca biblioteca = new Biblioteca();
        System.out.println("--------------------------");
        System.out.println("   CADASTRAR BIBLIOTECA   ");
        System.out.println("--------------------------");
        System.out.println("Informe o nome da biblioteca:");
        biblioteca.setNome_biblioteca(entrada.next());

        bibliotecaController.cadastrarBiblioteca(biblioteca);
    }

    public List<Biblioteca> listarTodasBibliotecas(){

        BibliotecaController bibliotecaController = new BibliotecaController();

        List<Biblioteca> listaDeBibliotecas = bibliotecaController.listarTodasBibliotecas();

        if(listaDeBibliotecas.isEmpty()){
            System.out.println("Nenhuma biblioteca cadastrada, cadaste uma!");
            this.cadastrarBiblioteca();
        }

        for (int i = 0;i < listaDeBibliotecas.size();i++){
            System.out.println((i+1)+"-"+listaDeBibliotecas.get(i).toString());
        }

        return listaDeBibliotecas;
    }

    public Biblioteca getBibliotecaById(){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        BibliotecaController bibliotecaController = new BibliotecaController();

        List<Biblioteca> listaBibliotecas = this.listarTodasBibliotecas();

        System.out.println("Escolha uma biblioteca: ");

        Biblioteca biblioteca = bibliotecaController.getBibliotecaById(listaBibliotecas.get(entrada.nextInt()-1).getId_biblioteca());

        return biblioteca;
    }

}
