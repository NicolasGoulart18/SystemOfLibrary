package library.service;
import library.model.Book;
import library.interection.Choice;
import java.util.Scanner;
import java.util.ArrayList;

public class Biblioteca {
    Choice choice= new Choice();
    static  Scanner scanner = new Scanner(System.in);
    private ArrayList<Book>livros;


    public  Biblioteca(){
        livros = new ArrayList<>();
    }
    public void criarLivro(){
        System.out.println("Nome do livro: ");
        String nomeL=scanner.nextLine();
        System.out.println("Nome do autor: ");
        String nomeA=scanner.nextLine();
        System.out.println("Ano de lançamento: ");
        int ano=scanner.nextInt();
        Book book = new Book(nomeL,nomeA,ano);
        adicionarLivro(book);

    }

    public void adicionarLivro(Book livro){
        livros.add(livro);
    }

    public void listarLivro(){
        for(Book livro:livros){
            String status;
            if(livro.isDisponivel()){
                status="Sim";
            }else{
                status="Não";
            }
            System.out.println("=========== LIVROS ===========");
            System.out.println("ID: "+livro.getId());
            System.out.println("Livro : "+ livro.getTitulo());
            System.out.println("Autor: "+livro.getAutor());
            System.out.println("Ano de lançamento: "+livro.getAnodelancamento());
            System.out.println("Disponivel: "+status);

        }




    }

    public void emprestarLivro(int id){
        for(Book livro: livros){
            if(id== livro.getId()){
                if (livro.isDisponivel()){
                    livro.setDisponivel(false);
                    System.out.println();
                    System.out.println("Livro "+livro.getTitulo()+" emprestado com sucesso!");
                }else{
                    System.out.println("Livro indisponivel!");
                    break;
                }
            }else{
                System.out.println("Livro não encontrado");
                break;
            }
        }

    }

}
