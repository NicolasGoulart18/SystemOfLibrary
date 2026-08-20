package system_of_library.usuarios;
import system_of_library.service.Library;
import system_of_library.model.Book;
import system_of_library.emprestimo.ResultRemove;
import java.util.Scanner;
public class Bibliotecario extends Usuario {
    Scanner scanner = new Scanner(System.in);
    private Book book;
    private Library library;
    public Bibliotecario (String name, String email,String endereco ,Library library) {
        super(name,email,endereco);
        this.library = library;
    }


    public Library getLibrary() {
        return library;
    }

    public void cadastrarLivro(String titulo,String autor,int ano){
        Book livro = new Book(titulo,autor,ano);
        library.addBook(livro);
    }

    @Override
    public int getPrazoEmprestimoDias() {
        return 30;
    }

    //testing
}

