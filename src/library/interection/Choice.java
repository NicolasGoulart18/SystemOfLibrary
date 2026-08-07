package library.interection;
import library.service.Biblioteca;
import library.model.Book;
import java.util.Scanner;

public class Choice {
    public static Scanner scanner = new Scanner (System.in);
    public static void main(String[] args) {

        Choice choice = new Choice();

        Biblioteca biblioteca = new Biblioteca();

        boolean parar=false;
        do{
            int opcao=choice.opcao();
            switch (opcao){
                case 1:
                    biblioteca.criarLivro();
                    break;
                case 2:
                    biblioteca.listarLivro();
                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    parar=true;
                    break;
            }
        }while(!parar);
    }

    public int opcao(){
        System.out.println("Escolha sua opção");
        System.out.println("[1] Adicionar Livro");
        System.out.println("[2] Listar Livro");
        System.out.println("[3] Emprestar Livro");
        System.out.println("[4] Devolver Livro");
        System.out.println("[5] Remover Livro");
        System.out.println("[6] Encerrar atendimento");
        int opcao= scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

}
