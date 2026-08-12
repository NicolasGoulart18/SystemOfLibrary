package system_of_library.interaction;
import system_of_library.usuarios.Professor;
import system_of_library.service.Library;
import system_of_library.usuarios.Bibliotecario;
import java.util.Scanner;
public class Choice {
    static Scanner scanner = new Scanner (System.in);
    public static void main(String[] args) {
        Choice choice = new Choice();

        Library library = new Library();

        Bibliotecario bibliotecario = new Bibliotecario(
                "Jõao","joao1232@email.com","rua dos cuiudo 80",library);
        boolean parar=false;
        int id;

        Professor professor = new Professor("João", "joao@email.com", "Rua X", "Matemática");{
            System.out.println(professor.getNome());
            System.out.println(professor.getDisciplina());
        }




       /* Aluno aluno = new Aluno("Nicolas", "nicolas@email.com", "Rua X, 123",6,"601A");
        aluno.getAnoEscolar();
        aluno.getTurma();

        System.out.println(aluno.getNome());
        System.out.println(aluno.getAnoEscolar());
        System.out.println(aluno.getTurma());

        */

        do{
            int opcao=choice.opcao();
            switch (opcao){
                case 1:
                    System.out.println("Nome do livro: ");
                    String titulo= scanner.nextLine();
                    System.out.println("Nome do autor: ");
                    String autor= scanner.nextLine();
                    System.out.println("Ano de lançamento: ");
                    int ano = Integer.parseInt(scanner.nextLine());
                    bibliotecario.cadastrarLivro(titulo,autor,ano);
                    break;
                case 2:
                    System.out.println("======== CATÁLOGO ========");
                    library.listBook();
                    break;
                case 3:
                    System.out.println("Informe o ID do livro que deseja pegar emprestado: ");
                    id=Integer.parseInt(scanner.nextLine());
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
        int opcao=Integer.parseInt(scanner.nextLine());
        return opcao;
    }

}
