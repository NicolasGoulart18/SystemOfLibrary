package system_of_library.students;
import system_of_library.usuarios.Usuario;
public class Aluno extends Usuario{

    private int anoEscolar;
    private String turma;

    public Aluno(String nome,String email,String endereco, int anoEscolar, String turma){
        super(nome,email,endereco);
        this.anoEscolar=anoEscolar;
        this.turma=turma;
    }


    public int getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(int anoEscolar) {
        this.anoEscolar = anoEscolar;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}
