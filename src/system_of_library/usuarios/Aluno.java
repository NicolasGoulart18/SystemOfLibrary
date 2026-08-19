package system_of_library.usuarios;

public class Aluno extends Usuario {
    private String anoEscolar;
    private String turma;

    public Aluno(String nome, String email, String endereco, String anoEscolar, String turma) {
        super(nome, email, endereco);
        this.anoEscolar = anoEscolar;
        this.turma = turma;
    }

    @Override
    public int getPrazoEmprestimoDias() {
        return 7; // Alunos têm 7 dias de prazo
    }

    public String getAnoEscolar() { return anoEscolar; }
    public String getTurma() { return turma; }
}