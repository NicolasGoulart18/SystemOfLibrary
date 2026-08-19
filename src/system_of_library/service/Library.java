package system_of_library.service;

import system_of_library.model.Book;
import system_of_library.usuarios.Usuario;
import system_of_library.emprestimo.ResultadoEmpr;
import system_of_library.emprestimo.Emprestimo;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> livros;
    private List<Emprestimo> emprestimos;

    public Library() {
        this.livros = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void addBook(Book livro) {
        livros.add(livro);
    }

    public List<Book> getLivros() {
        return livros;
    }

    public ResultadoEmpr lendBook(int idLivro, Usuario usuario) {
        for (Book livro : livros) {
            if (livro.getId() == idLivro) {
                if (livro.emprestarLivro()) {
                    Emprestimo emp = new Emprestimo(livro, usuario);
                    emprestimos.add(emp);
                    return ResultadoEmpr.SUCESSO;
                }
                return ResultadoEmpr.LIVRO_INDISPONIVEL;
            }
        }
        return ResultadoEmpr.LIVRO_NAO_EXISTE;
    }

    public boolean returnBook(int id) {
        for (Book livro : livros) {
            if (livro.getId() == id) {
                return livro.devolverLivro();
            }
        }
        return false;
    }

    public boolean removeBook(int id) {
        return livros.removeIf(livro -> livro.getId() == id);
    }
}