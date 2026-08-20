package system_of_library.service;

import system_of_library.emprestimo.ResultRemove;
import system_of_library.model.Book;
import system_of_library.usuarios.Usuario;
import system_of_library.emprestimo.ResultadoEmpr;
import system_of_library.emprestimo.Emprestimo;
import system_of_library.emprestimo.ResultadoDevolucao;
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

    public ResultadoDevolucao returnBook(int id) {
        for (Book livro : livros) {
            if (livro.getId() == id) {
                if(livro.devolverLivro()){
                    return ResultadoDevolucao.SUCESSO;
                } else  {
                    return ResultadoDevolucao.LIVRO_JA_DEVOLVIDO;
                }
            }
        }
        return ResultadoDevolucao.LIVRO_NAO_EXISTE;
    }

    public ResultRemove removeBook(int id) {
        for (Book livro : livros) {
            if (livro.getId() == id) {
                if (!livro.isAvailable()) {
                    return ResultRemove.LIVRO_EMPRESTADO;
                }
                livros.remove(livro);
                return ResultRemove.SUCESSO;
            }
        }
        return ResultRemove.LIVRO_NAO_EXISTE;
    }
}