package system_of_library.funcionario;
import system_of_library.service.Library;
import system_of_library.usuarios.Usuario;
public class Bibliotecario extends Usuario {

    private Library library;

    public Bibliotecario (String name, String email,String endereco ,Library library) {
        super(name,email,endereco);

        this.library = library;
    }


    public Library getLibrary() {
        return library;
    }

    public void cadastrarLivro(){
        library.createBook();
    }

    public void removerLivro(int id){
        library.removeBook(id);
    }

}
