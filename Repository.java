package repository;

import domain.Competencia;
import domain.DiaSemana;
import domain.Disciplina;
import domain.Horario;
import domain.Periodo;
import domain.Professor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class DadosExemploRepository {

    private final List<Professor> professores;
    private final List<Disciplina> disciplinas;
    private final List<Horario> horarios;

    public DadosExemploRepository() {

        professores = new ArrayList<>();
        disciplinas = new ArrayList<>();
        horarios = new ArrayList<>();

        carregarProfessores();
        carregarDisciplinas();
        carregarHorarios();
    }

    private void carregarProfessores() {

        professores.add(
                new Professor(
                        "João",
                        Set.of(
                                Competencia.POO,
                                Competencia.ESTRUTURA_DADOS
                        ),
                        Set.of(
                                new Horario(DiaSemana.SEGUNDA, Periodo.P1),
                                new Horario(DiaSemana.TERCA, Periodo.P2),
                                new Horario(DiaSemana.QUARTA, Periodo.P1)
                        )
                )
        );

        professores.add(
                new Professor(
                        "Maria",
                        Set.of(
                                Competencia.BANCO_DADOS,
                                Competencia.REDES
                        ),
                        Set.of(
                                new Horario(DiaSemana.SEGUNDA, Periodo.P2),
                                new Horario(DiaSemana.QUINTA, Periodo.P1),
                                new Horario(DiaSemana.SEXTA, Periodo.P3)
                        )
                )
        );

        professores.add(
                new Professor(
                        "Carlos",
                        Set.of(
                                Competencia.POO,
                                Competencia.REDES
                        ),
                        Set.of(
                                new Horario(DiaSemana.TERCA, Periodo.P1),
                                new Horario(DiaSemana.QUARTA, Periodo.P2),
                                new Horario(DiaSemana.SEXTA, Periodo.P2)
                        )
                )
        );
    }

    private void carregarDisciplinas() {

        disciplinas.add(
                new Disciplina(
                        "POO001",
                        "Programação Orientada a Objetos",
                        80,
                        Competencia.POO
                )
        );

        disciplinas.add(
                new Disciplina(
                        "ED001",
                        "Estrutura de Dados",
                        80,
                        Competencia.ESTRUTURA_DADOS
                )
        );

        disciplinas.add(
                new Disciplina(
                        "BD001",
                        "Banco de Dados",
                        80,
                        Competencia.BANCO_DADOS
                )
        );

        disciplinas.add(
                new Disciplina(
                        "RED001",
                        "Redes de Computadores",
                        80,
                        Competencia.REDES
                )
        );
    }

    private void carregarHorarios() {

        for (DiaSemana dia : DiaSemana.values()) {

            for (Periodo periodo : Periodo.values()) {

                horarios.add(new Horario(dia, periodo));

            }

        }

    }

    public List<Professor> getProfessores() {
        return Collections.unmodifiableList(professores);
    }

    public List<Disciplina> getDisciplinas() {
        return Collections.unmodifiableList(disciplinas);
    }

    public List<Horario> getHorarios() {
        return Collections.unmodifiableList(horarios);
    }

}
