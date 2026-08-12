package system_of_library.usuarios;

public class Aluno extends Usuario{

    private String anoEscolar;
    private String turma;

    public Aluno(String nome,String email,String endereco, String anoEscolar, String turma){
        super(nome,email,endereco);
        this.anoEscolar=anoEscolar;
        this.turma=turma;
    }


    public String getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(String anoEscolar) {
        this.anoEscolar = anoEscolar;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}
