package system_of_library.emprestimo;

import system_of_library.model.Book;
import system_of_library.usuarios.Usuario;
import java.time.LocalDate;

public class Emprestimo {
    private Book livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;

    public Emprestimo(Book livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        // Polimorfismo sendo usado no cálculo da data limite:
        this.dataDevolucaoPrevista = dataEmprestimo.plusDays(usuario.getPrazoEmprestimoDias());
    }

    public Book getLivro() { return livro; }
    public Usuario getUsuario() { return usuario; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataDevolucaoPrevista() { return dataDevolucaoPrevista; }
}