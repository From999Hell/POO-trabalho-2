package service;

import domain.Grade;

import java.util.List;

public class ResultadoGeracao {

    private final Grade grade;
    private final List<String> conflitos;

    public ResultadoGeracao(Grade grade,
                            List<String> conflitos) {

        this.grade = grade;
        this.conflitos = conflitos;
    }

    public Grade getGrade() {
        return grade;
    }

    public List<String> getConflitos() {
        return conflitos;
    }

}
