import Controller.BibliotecaController;
import Controller.GeneroController;
import Controller.LivroController;
import Model.Genero;
import View.BibliotecaView;
import View.GeneroView;
import View.LivroView;
import View.Menu;

public class Main {

    public static void main(String[] args){

        Menu menu = new Menu();
        menu.criarTabelas();
        menu.menuInicial();

    }

}
