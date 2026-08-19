package system_of_library.usuarios;
public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String endereco;
    private static int cont=1;

    public Usuario(String nome, String email, String endereco) {
        this.id = cont;
        cont++;
        this.nome = nome;
        setEmail(email);
        this.endereco = endereco;

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email == null|| email.isBlank()){
            System.out.println("Email Inválido");
        }else{
            this.email=email;
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
