package system_of_library.interection;
import system_of_library.service.Library;
import java.util.Scanner;

public class Choice {
    public static Scanner scanner = new Scanner (System.in);
    public static void main(String[] args) {

        Choice choice = new Choice();
        Library library = new Library();
        boolean parar=false;
        int id;



        do{
            int opcao=choice.opcao();
            switch (opcao){
                case 1:
                    library.createBook();
                    break;
                case 2:
                    System.out.println("======== CATÁLOGO ========");
                    library.listBook();
                    break;
                case 3:
                    System.out.println("Informe o ID do livro que deseja pegar emprestado: ");
                    id=scanner.nextInt();
                    library.lendBook(id);
                    break;
                case 4:
                    System.out.println("Informe o ID do livro que você deseja devolver: ");
                    id=Integer.parseInt(scanner.nextLine());
                    library.returnBook(id);
                    break;
                case 5:
                    System.out.println("Informe o ID do livro que deseja remover: ");
                    id=Integer.parseInt(scanner.nextLine());
                    library.removeBook(id);
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
        System.out.println("=======  MENU  =======");
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
