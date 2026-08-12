package system_of_library.professor;

import system_of_library.usuarios.Usuario;

public class Professor extends Usuario {

    private String anoEscolar;
    private String materia;

    public Professor(String nome, String email, String endereco,String anoEscolar,String materia) {
        super(nome, email, endereco);
        this.anoEscolar=anoEscolar;
        this.materia=materia;
    }

    public String getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(String anoEscolar) {
        this.anoEscolar = anoEscolar;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
