package library.service;
import library.model.Book;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Book>livros;

    public  Biblioteca(){
        livros = new ArrayList<>();
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

}
