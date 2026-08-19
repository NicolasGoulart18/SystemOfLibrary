package system_of_library.interaction;
import system_of_library.emprestimo.ResultadoEmpr;
import system_of_library.service.Library;
import system_of_library.usuarios.Aluno;
import system_of_library.usuarios.Bibliotecario;
import system_of_library.usuarios.Professor;
import system_of_library.usuarios.Usuario;

import java.util.Scanner;

public class Choice {
    int id=0;
    static Scanner scanner = new Scanner(System.in);
    static Library library = new Library();
    public static void main(String[] args) {
        Choice choice = new Choice();
        Bibliotecario bibliotecario = new Bibliotecario("Jõao", "joao1232@email.com", "rua dos cuiudo 80", library
        );

        boolean parar = false;
        int id = 0;

        do {

            int opcao = choice.opcao();

            switch (opcao) {

                case 1:
                    System.out.println("Nome do livro: ");
                    String titulo = scanner.nextLine();

                    System.out.println("Nome do autor: ");
                    String autor = scanner.nextLine();

                    System.out.println("Ano de lançamento: ");
                    int ano = Integer.parseInt(scanner.nextLine());

                    bibliotecario.cadastrarLivro(titulo, autor, ano);
                    break;

                case 2:
                    System.out.println("======== CATÁLOGO ========");
                    library.listBook();
                    break;

                case 3:
                    choice.emprestarLivro();
                    break;

                case 4:
                    System.out.println("Informe o ID do livro que você deseja devolver: ");
                    id = Integer.parseInt(scanner.nextLine());

                    library.returnBook(id);
                    break;

                case 5:
                    System.out.println("Informe o ID do livro que deseja remover: ");
                    id = Integer.parseInt(scanner.nextLine());

                    library.removeBook(id);
                    break;

                case 6:
                    parar = true;
                    System.out.println("Obrigado!");
                    System.out.println("Encerrando....");
                    break;
            }

        } while (!parar);
    }

    public int opcao() {

        System.out.println("=======  MENU  =======");
        System.out.println("Escolha a categoria desejada:");
        System.out.println("[1] Adicionar Livro");
        System.out.println("[2] Listar Livro");
        System.out.println("[3] Empréstimo de Livro");
        System.out.println("[4] Devolver Livro");
        System.out.println("[5] Remover Livro");
        System.out.println("[6] Encerrar atendimento");

        int opcao = Integer.parseInt(scanner.nextLine());

        return opcao;
    }

    private Usuario criarUsuario(){
        System.out.println("[1] Aluno | [2] Professor ");
        int num = Integer.parseInt(scanner.nextLine());
        if (num == 1) {
            System.out.println("Nome: ");
            String nome = scanner.nextLine();

            System.out.println("Email: ");
            String email = scanner.nextLine();

            System.out.println("Endereço: ");
            String endereco = scanner.nextLine();

            System.out.println("Ano escolar: ");
            String anoEscolar = scanner.nextLine();

            System.out.println("Turma: ");
            String turma = scanner.nextLine();

            return new Aluno(nome, email, endereco, anoEscolar, turma);

        } else if (num == 2) {
            System.out.println("Nome: ");
            String nome = scanner.nextLine();

            System.out.println("Email: ");
            String email = scanner.nextLine();

            System.out.println("Endereço: ");
            String endereco = scanner.nextLine();

            System.out.println("Disciplina:");
            String disciplina = scanner.nextLine();

            return new Professor(nome, email, endereco, disciplina);

        } else {
            System.out.println("Opção inválida");
            return null;
        }
    }



    private void emprestarLivro() {
        Usuario usuario = criarUsuario();
        if (usuario != null) {
            System.out.println("Informe o id do livro desejado: ");
            id=Integer.parseInt(scanner.nextLine());
            if (id!=0){
                ResultadoEmpr resultadoEmpr = library.lendBook(id, usuario);
                if (resultadoEmpr==ResultadoEmpr.SUCESSO){
                    System.out.println("Livro emprestado com sucesso!");
                } else if (resultadoEmpr==ResultadoEmpr.LIVRO_INDISPONIVEL) {
                    System.out.println("Livro indisponivel!");
                }else{
                    System.out.println("Livro não existe!");
                }
            }
        }
    }
}