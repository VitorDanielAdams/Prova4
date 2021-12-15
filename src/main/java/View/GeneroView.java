package View;

import Controller.GeneroController;
import Model.Genero;

import java.util.List;
import java.util.Scanner;

public class GeneroView {

    public void cadastrarGenero(){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");

        GeneroController generoController = new GeneroController();
        Genero genero = new Genero();
        System.out.println("--------------------------");
        System.out.println("   CADASTRAR GENEROS   ");
        System.out.println("--------------------------");
        System.out.println("Informe o Genero:");
        genero.setNome_genero(entrada.next());

        generoController.cadastrarGenero(genero);

    }

    public List<Genero> listarGeneros(){

        GeneroController generoController = new GeneroController();

        List<Genero> listaGeneros = generoController.listarGeneros();

        if(listaGeneros.isEmpty()){
            System.out.println("Nenhum genero cadastrado, cadaste um!");
            this.cadastrarGenero();
        }

        for (int i = 0;i < listaGeneros.size();i++){
            System.out.println((i+1)+"-"+listaGeneros.get(i).toString());
        }

        return listaGeneros;

    }

    public Genero getGeneroById(){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        GeneroController generoController = new GeneroController();

        List<Genero> listaGeneros = this.listarGeneros();
        System.out.println("Escolha o genero: ");

        Genero genero = generoController.getGeneroById(listaGeneros.get(entrada.nextInt()-1).getId_genero());

        return genero;
    }

    public void editarGenero(Genero genero){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        GeneroController generoController = new GeneroController();

        System.out.println("EDITAR");

        System.out.println("informe o novo nome");
        genero.setNome_genero(entrada.next());

        generoController.editarGenero(genero);

    }
}