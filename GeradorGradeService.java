package service;

import domain.*;

import java.util.List;

public class GeradorGradeService {

    private MatchService matchService;
    private VerificadorConflitosService verificador;

    public GeradorGradeService(
            MatchService matchService,
            VerificadorConflitosService verificador) {

        this.matchService = matchService;
        this.verificador = verificador;
    }

    public Grade gerarGrade(
            List<Professor> professores,
            List<Disciplina> disciplinas,
            List<Horario> horarios) {

        Grade grade = new Grade();

        int indiceHorario = 0;

        for (Disciplina disciplina : disciplinas) {

            Professor professor =
                    matchService.encontrarMelhorProfessor(
                            disciplina,
                            professores);

            if (professor == null)
                continue;

            while (indiceHorario < horarios.size()) {

                Horario horario = horarios.get(indiceHorario);

                indiceHorario++;

                if (professor.estaDisponivel(horario)) {

                    grade.adicionarAlocacao(

                            new Alocacao(
                                    professor,
                                    disciplina,
                                    horario));

                    break;
                }

            }

        }

        return grade;

    }

}
