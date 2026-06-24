package domain;

import exception.DadosInvalidosException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Professor {

    private String nome;
    private Set<Competencia> competencias;
    private Set<Horario> disponibilidade;

    public Professor(String nome,
                     Set<Competencia> competencias,
                     Set<Horario> disponibilidade) {

        if (nome == null || nome.isBlank()) {
            throw new DadosInvalidosException(
                    "Nome do professor não pode ser vazio.");
        }

        if (competencias == null || competencias.isEmpty()) {
            throw new DadosInvalidosException(
                    "Professor deve possuir ao menos uma competência.");
        }

        if (disponibilidade == null || disponibilidade.isEmpty()) {
            throw new DadosInvalidosException(
                    "Professor deve possuir ao menos um horário disponível.");
        }

        this.nome = nome;
        this.competencias = new HashSet<>(competencias);
        this.disponibilidade = new HashSet<>(disponibilidade);
    }

    public String getNome() {
        return nome;
    }

    public Set<Competencia> getCompetencias() {
        return Collections.unmodifiableSet(competencias);
    }

    public Set<Horario> getDisponibilidade() {
        return Collections.unmodifiableSet(disponibilidade);
    }

    public boolean possuiCompetencia(Competencia competencia) {
        return competencias.contains(competencia);
    }

    public boolean estaDisponivel(Horario horario) {
        return disponibilidade.contains(horario);
    }

    public void adicionarCompetencia(Competencia competencia) {

        if (competencia == null) {
            throw new DadosInvalidosException(
                    "Competência inválida.");
        }

        competencias.add(competencia);
    }

    public void adicionarDisponibilidade(Horario horario) {

        if (horario == null) {
            throw new DadosInvalidosException(
                    "Horário inválido.");
        }

        disponibilidade.add(horario);
    }

    @Override
    public String toString() {
        return nome;
    }
}