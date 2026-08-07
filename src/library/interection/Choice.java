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
        int id;



        do{
            int opcao=choice.opcao();
            switch (opcao){
                case 1:
                    biblioteca.criarLivro();
                    break;
                case 2:
                    System.out.println("======== CATÁLOGO ========");
                    biblioteca.listarLivro();
                    break;
                case 3:
                    System.out.println("Informe o ID do livro que deseja pegar emprestado: ");
                    id=scanner.nextInt();
                    biblioteca.emprestarLivro(id);
                    break;
                case 4:
                    System.out.println("Informe o ID do livro que você deseja devolver: ");
                    id=Integer.parseInt(scanner.nextLine());
                    biblioteca.devolverLivro(id);
                    break;
                case 5:
                    System.out.println("Informe o ID do livro que deseja remover: ");
                    id=Integer.parseInt(scanner.nextLine());
                    biblioteca.removerLivro(id);
                    break;
                case 6:
                    parar=true;
                    System.out.println("Obrigado!");
                    System.out.println("Encerrando....");
                    break;
            }
        }while(!parar);
    }

    public int opcao(){
        System.out.println("=======  SEJA-BEM-VINDO  =======");
        System.out.println("Escolha a categoria desejada:");
        System.out.println("[1] Adicionar Livro");
        System.out.println("[2] Listar Livro");
        System.out.println("[3] Empréstimo de Livro");
        System.out.println("[4] Devolver Livro");
        System.out.println("[5] Remover Livro");
        System.out.println("[6] Encerrar atendimento");
        int opcao= scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

}
