package system_of_library.interaction;
import system_of_library.emprestimo.ResultRemove;
import system_of_library.emprestimo.ResultadoDevolucao;
import system_of_library.emprestimo.ResultadoEmpr;
import system_of_library.model.Book;
import system_of_library.service.Library;
import system_of_library.usuarios.Aluno;
import system_of_library.usuarios.Bibliotecario;
import system_of_library.usuarios.Professor;
import system_of_library.usuarios.Usuario;

import java.util.Scanner;

public class Choice {
    private Bibliotecario bibliotecario;
    private Scanner scanner;
    private Library library;
    private Usuario usuarioLogado;
    public Choice(){
        this.scanner = new Scanner(System.in);
        this.library = new Library();
       // this.bibliotecario= new Bibliotecario("Pedro","pedrofunc@email.com","funcionarios-111",this.library);
    }

    public static void main(String[] args) {
        Choice app = new Choice();
        app.iniciarSistema();
    }

    public void iniciarSistema(){
        boolean parar = false;
        int id = 0;
        System.out.println("=== BEM-VINDO À BIBLIOTECA ===");
        System.out.println("Por favor, faça sua identificação inicial:");
        this.usuarioLogado=criarUsuario();
        if(this.usuarioLogado==null){;
            System.out.println("Falha na identificação, Encerrando sistema...");
            return;
        }

        System.out.println("\nSessão iniciada como: " + usuarioLogado.getNome() +
                " (" + usuarioLogado.getClass().getSimpleName() + ")");

        do {
            try {
                int opcao = exibirMenu();

                switch (opcao) {

                    case 1:
                        System.out.println("--- Identificação do Usuário ---");
                        cadLivro(this.usuarioLogado);
                        break;
                    case 2:
                        listarLivro();
                        break;
                    case 3:
                        emprestarLivro();
                        break;
                    case 4:
                        devolverlivro();
                        break;
                    case 5:
                        System.out.println("---Validação de Usuario---");
                        removerLivro(this.usuarioLogado);
                        break;
                    case 6:
                        parar = true;
                        System.out.println("Obrigado! Encerrando....");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            }catch (NumberFormatException e){
                System.out.println("ERRO: Por favor, digite somente números inteiros!");
            }
        } while (!parar);
    }

    private int exibirMenu() {

        System.out.println("=======  MENU  =======");
        System.out.println("Escolha a categoria desejada:");
        System.out.println("[1] Adicionar Livro");
        System.out.println("[2] Listar Livro");
        System.out.println("[3] Empréstimo de Livro");
        System.out.println("[4] Devolver Livro");
        System.out.println("[5] Remover Livro");
        System.out.println("[6] Encerrar atendimento");

        return Integer.parseInt(scanner.nextLine());
    }

    private void listarLivro(){System.out.println("======== CATÁLOGO ========");
        if (library.getLivros().isEmpty()) {
        System.out.println("Nenhum livro cadastrado.");
        return;
    }
        for (Book livro : library.getLivros()) {
        System.out.println("ID: " + livro.getId() + " | Título: " + livro.getTitle() +
                " | Autor: " + livro.getAuthor() +
                " | Disponível: " + (livro.isAvailable() ? "Sim" : "Não"));
    }
}



    private Usuario criarUsuario(){
        System.out.println("[1] Aluno | [2] Professor | [3] Bibliotecario");
        int num = Integer.parseInt(scanner.nextLine());
        if(num <=2){
            System.out.println("0pção Inválida");
            return null;
        }
        System.out.println("Nome: ");
        String nome = scanner.nextLine();

        System.out.println("Email: ");
        String email = scanner.nextLine();

        System.out.println("Endereço: ");
        String endereco = scanner.nextLine();
        if (num == 1) {
            System.out.println("Ano escolar: ");
            String anoEscolar = scanner.nextLine();

            System.out.println("Turma: ");
            String turma = scanner.nextLine();

            return new Aluno(nome, email, endereco, anoEscolar, turma);

        } else if (num == 2) {
            System.out.println("Disciplina:");
            String disciplina = scanner.nextLine();

            return new Professor(nome, email, endereco, disciplina);

        } else {
            return new Bibliotecario(nome,email,endereco,library);
        }
    }

    private void cadLivro(Usuario usuarioAtivo){
        if (!(usuarioAtivo instanceof Bibliotecario bib)){
            System.out.println("Somente Bibiliotecarios podem adicionar livros");
            return;
        }
        System.out.println("Nome do livro: ");
        String titulo = scanner.nextLine();
        System.out.println("Nome do autor: ");
        String autor = scanner.nextLine();
        System.out.println("Ano de lançamento: ");
        int ano = Integer.parseInt(scanner.nextLine());
        bib.cadastrarLivro(titulo, autor, ano);
    }



    private void devolverlivro(){
            System.out.println("Informe o ID do livro que você deseja devolver: ");
            int idDevolver = Integer.parseInt(scanner.nextLine());
            ResultadoDevolucao resultadoDevolucao = library.returnBook(idDevolver);
            if (resultadoDevolucao==ResultadoDevolucao.SUCESSO){
                System.out.println("Livro Devolvido!");
            } else if (resultadoDevolucao==ResultadoDevolucao.LIVRO_JA_DEVOLVIDO) {
                System.out.println("Livro já devolvido!");
            }else{
                System.out.println("Livro não existe!");
            }
    }

    private void emprestarLivro() {
        Usuario usuario = criarUsuario();
        if (usuario != null) {
            System.out.println("Informe o id do livro desejado: ");
            int id=Integer.parseInt(scanner.nextLine());
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

    private void removerLivro(Usuario usuarioAtivo){
        if(!(usuarioAtivo instanceof Bibliotecario)){
            System.out.println("Apenas Bibliotecarios podem remover livros!");
            return;
        }
        System.out.println("Informe o id do livro que deseja remover: ");
        int idRemover=Integer.parseInt(scanner.nextLine());
        ResultRemove resultRemove = library.removeBook(idRemover);
        if (resultRemove==ResultRemove.SUCESSO){
            System.out.println("Livro removido com sucesso!");
        } else if (resultRemove==ResultRemove.LIVRO_EMPRESTADO) {
            System.out.println("O livro está emprestado no momento!");
        }else {
            System.out.println("Livro com ID: "+idRemover+" não foi encontrado!");
        }
    }

}