package domain;

import exception.DadosInvalidosException;

public class Alocacao {

    private Professor professor;
    private Disciplina disciplina;
    private Horario horario;

    public Alocacao(Professor professor,
                    Disciplina disciplina,
                    Horario horario) {

        if (professor == null)
            throw new DadosInvalidosException("Professor inválido.");

        if (disciplina == null)
            throw new DadosInvalidosException("Disciplina inválida.");

        if (horario == null)
            throw new DadosInvalidosException("Horário inválido.");

        this.professor = professor;
        this.disciplina = disciplina;
        this.horario = horario;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Horario getHorario() {
        return horario;
    }

}
