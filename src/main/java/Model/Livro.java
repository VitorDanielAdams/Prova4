package Model;

public class Livro {

    private int id_livro;
    private String nome_livro;
    private String autor;
    private Genero genero;
    private Biblioteca biblioteca;

    public Livro() {
    }

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public String getNome_livro() {
        return nome_livro;
    }

    public void setNome_livro(String nome_livro) {
        this.nome_livro = nome_livro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public String toString() {
        return "Livro: \n" +
                "nome= " + nome_livro + "\n" +
                "autor= " + autor + "\n" +
                "genero= " + genero + "\n" +
                "biblioteca= " + biblioteca;
    }
}
