package library;
import java.util.ArrayList;
import library.model.Book;
import library.service.Biblioteca;
public class Main {
    public static void main(String[] args) {



        Biblioteca biblioteca = new Biblioteca();

        Book book1 = new Book("Memorias do subsolo ", "Dostoievski", 1864);

        Book book2 = new Book("Noites Brancas","Dostoievski",1848);

        biblioteca.adicionarLivro(book1);
        biblioteca.adicionarLivro(book2);

        biblioteca.listarLivro();

    }

}
