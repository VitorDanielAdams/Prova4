package Model;

public class Biblioteca {

    private int id_biblioteca;
    private String nome_biblioteca;


    public Biblioteca() {
    }

    public int getId_biblioteca() {
        return id_biblioteca;
    }

    public void setId_biblioteca(int id_biblioteca) {
        this.id_biblioteca = id_biblioteca;
    }

    public String getNome_biblioteca() {
        return nome_biblioteca;
    }

    public void setNome_biblioteca(String nome_biblioteca) {
        this.nome_biblioteca = nome_biblioteca;
    }



    @Override
    public String toString() {
        return "Biblioteca: " + nome_biblioteca;
    }
}
