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
        int ano=Integer.parseInt(scanner.nextLine());
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
            System.out.println("ID: "+livro.getId());
            System.out.println("Livro : "+ livro.getTitulo());
            System.out.println("Autor: "+livro.getAutor());
            System.out.println("Ano de lançamento: "+livro.getAnodelancamento());
            System.out.println("Disponivel: "+status);
            System.out.println();

        }




    }

    public void emprestarLivro(int id){
        for(Book livro: livros){
            if(livro.getId()==id){
                if (livro.isDisponivel()){
                    livro.setDisponivel(false);
                    System.out.println();
                    System.out.println("Livro "+livro.getTitulo()+" emprestado com sucesso!");
                    System.out.println();
                }else{
                    System.out.println();
                    System.out.println(livro.getTitulo()+" já foi emprestado!");
                    System.out.println();
                }
                return;
            }
        }
        System.out.println();
        System.out.println("Livro com ID: "+id+" não encontrado!");
    }

    public void devolverLivro(int id){
        for (Book livro:livros){
            if (livro.getId()==id){
                if (!livro.isDisponivel()){
                    livro.setDisponivel(true);
                    System.out.println();
                    System.out.println(livro.getTitulo()+" devolvido com sucesso!");
                    System.out.println();
                }else{
                    System.out.println();
                    System.out.println("Livro não foi emprestado!");
                    System.out.println();
                }
                return;
            }
        }
        System.out.println();
        System.out.println("O Livro com ID: "+id+" não foi encontrado!");
        System.out.println();

    }


    public void removerLivro(int id){
        for (int i = 0; i < livros.size() ; i++) {
            if(livros.get(i).getId()==id) {
                System.out.println();
                System.out.println("Livro " + livros.get(i).getTitulo() + " removido com sucesso!");
                System.out.println();
                livros.remove(i);
            }return;
        }
        System.out.println("Livro com ID "+id+" não encontrado!");
    }
}
