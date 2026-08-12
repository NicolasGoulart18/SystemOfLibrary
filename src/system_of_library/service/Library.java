package system_of_library.service;
import system_of_library.model.Book;
import java.util.ArrayList;
import system_of_library.usuarios.Usuario;
import system_of_library.emprestimo.ResultadoEmpr;
import system_of_library.emprestimo.Emprestimo;
public class Library {

    private ArrayList<Book>livros;
    private ArrayList<Emprestimo> emprestimo= new ArrayList<>();
    public Library(){
        livros = new ArrayList<>();
    }


    public void addBook(Book livro){
        livros.add(livro);
    }

    public void listBook(){
        for(Book livro:livros){
            String status;
            if(livro.isAvailable()){
                status="Sim";
            }else{
                status="Não";
            }
            System.out.println("ID: "+livro.getId());
            System.out.println("Livro : "+ livro.getTitle());
            System.out.println("Autor: "+livro.getAuthor());
            System.out.println("Ano de lançamento: "+livro.getReleaseyear());
            System.out.println("Disponivel: "+status);
            System.out.println();

        }
    }


    public ResultadoEmpr.ResultadoEmprestimo lendBook(int idLivro, Usuario usuario){
        boolean existe = false;
        for (Book livro:livros){
            if (livro.getId()==idLivro){
                existe=true;
                if(livro.emprestarLivro()) {
                    Emprestimo emprestimo0 = new Emprestimo(livro, usuario);
                    emprestimo.add(emprestimo0);
                    return ResultadoEmpr.ResultadoEmprestimo.SUCESSO;
                }else {

                }
            }
        }
        if(!existe){
            System.out.println("Livro não existe!");
        }
        return false;
    }


    public void returnBook(int id){
        for (Book livro:livros){
            if (livro.getId()==id){
                if (livro.devolverLivro()){
                    System.out.println("Livro devolvido com sucesso!");
                }else{
                    System.out.println("Livro já foi devolvido");
                }
                return;
            }
        }
        System.out.println();
        System.out.println("O Livro com ID: "+id+" não foi encontrado!");
        System.out.println();

    }


    public void removeBook(int id){
        for (int i = 0; i < livros.size() ; i++) {
            if(livros.get(i).getId()==id) {
                System.out.println();
                System.out.println("Livro " + livros.get(i).getTitle() + " removido com sucesso!");
                System.out.println();
                livros.remove(i);
                return;
            }
        }
        System.out.println("Livro com ID "+id+" não encontrado!");
    }
}
