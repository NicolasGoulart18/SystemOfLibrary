package system_of_library.emprestimo;
import system_of_library.model.Book;
import system_of_library.usuarios.Usuario;
import java.time.LocalDate;
public class Emprestimo {

    private Book livro;
    private Usuario usuario;
    private LocalDate emprestimo;

    public Emprestimo(Book livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.emprestimo=LocalDate.now();
    }

    public Book getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }


    public LocalDate getEmprestimo() {
        return emprestimo;
    }

}
