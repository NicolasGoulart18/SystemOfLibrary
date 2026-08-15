package system_of_library.emprestimo;
import system_of_library.model.Book;
import system_of_library.usuarios.Aluno;
import system_of_library.usuarios.Professor;
import system_of_library.usuarios.Usuario;
import java.time.LocalDate;
import java.util.Scanner;
import system_of_library.service.Library;
public class Emprestimo {
    Scanner scanner = new Scanner(System.in);
    private Book livro;
    private Usuario usuario;
    private LocalDate emprestimo;

    private int id;
    public Emprestimo(Book livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.emprestimo=LocalDate.now();
    }

    public void emprestarLivroMetodo(){
        System.out.println("[1] Aluno | [2] Professor ");
        int num=Integer.parseInt(scanner.nextLine());
        Usuario usuario = null;

        if(num==1){
            System.out.println("Nome: ");
            String nome=scanner.nextLine();
            System.out.println("Email: ");
            String email = scanner.nextLine();
            System.out.println("Endereço: ");
            String endereco = scanner.nextLine();
            System.out.println("Ano escolar: ");
            String anoEscolar=scanner.nextLine();
            System.out.println("Turma: ");
            String turma = scanner.nextLine();
            System.out.println("ID do livro desejado: ");
            id=Integer.parseInt(scanner.nextLine());
            usuario = new Aluno(nome,email,endereco,anoEscolar,turma);

        }else if(num==2){
            System.out.println("Nome: ");
            String nome=scanner.nextLine();
            System.out.println("Email: ");
            String email = scanner.nextLine();
            System.out.println("Endereço: ");
            String endereco = scanner.nextLine();
            System.out.println("Disciplina:");
            String disciplina = scanner.nextLine();
            System.out.println("ID do livro desejado: ");
            id=Integer.parseInt(scanner.nextLine());
            usuario = new Professor(nome,email,endereco,disciplina);
        }else {
            System.out.println("Opção Inválida!");
        }
        if(usuario !=null && id !=0){
            ResultadoEmpr resultadoEmpr = library.lendBook(id,usuario);
            if (resultadoEmpr == ResultadoEmpr.SUCESSO){
                System.out.println("Livro emprestado com sucesso!");
            }else if (resultadoEmpr == ResultadoEmpr.LIVRO_INDISPONIVEL){
                System.out.println("Livro indisponivel");
            } else if (resultadoEmpr == ResultadoEmpr.LIVRO_NAO_EXISTE){
                System.out.println("Livro não existe!");
            }
        }
        break;
    }

    public Book getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }


    public LocalDate getEmprestimo() {
        return emprestimo;
    }

}
