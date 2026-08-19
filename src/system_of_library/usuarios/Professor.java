package system_of_library.usuarios;

public class Professor extends Usuario {
    private String disciplina;

    public Professor(String nome, String email, String endereco, String disciplina) {
        super(nome, email, endereco);
        this.disciplina = disciplina;
    }

    @Override
    public int getPrazoEmprestimoDias() {
        return 14; // Professores têm 14 dias de prazo
    }

    public String getDisciplina() { return disciplina; }
}