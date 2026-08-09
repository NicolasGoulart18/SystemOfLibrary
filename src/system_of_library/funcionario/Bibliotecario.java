package system_of_library.funcionario;
import system_of_library.service.Library;

public class Bibliotecario {
    private int id;
    private static int count=1;
    private String name;
    private String email;
    private Library library;

    public Bibliotecario(String name, String email, Library library) {
        this.id = count;
        count++;
        this.name = name;
        this.email = email;
        this.library = library;
    }



    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        if(email==null||email.isBlank()){
            System.out.println("Email inválido");
        }else{
            this.email=email;
        }
    }

    public String getEmail() {
        return email;
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
