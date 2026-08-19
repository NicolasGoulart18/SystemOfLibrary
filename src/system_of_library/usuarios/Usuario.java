package system_of_library.usuarios;

public abstract class Usuario {
    private int id;
    private String nome;
    private String email;
    private String endereco;
    private static int cont = 1;

    public Usuario(String nome, String email, String endereco) {
        this.id = cont++;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
    }

    // Método abstrato: define um contrato obrigatorio para as filhas
    public abstract int getPrazoEmprestimoDias();

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
}