package system_of_library.professor;

import system_of_library.usuarios.Usuario;

public class Professor extends Usuario {


    private String disciplina;

    public Professor(String nome, String email, String endereco,String disciplina) {
        super(nome, email, endereco);
        this.disciplina = disciplina;
    }


    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}
