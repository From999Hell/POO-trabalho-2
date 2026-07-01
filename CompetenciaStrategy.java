package service.strategy;

import domain.Disciplina;
import domain.Professor;

public class CompetenciaStrategy implements MatchStrategy {

    @Override
    public int calcularPontuacao(Professor professor,
                                 Disciplina disciplina) {

        if (professor.possuiCompetencia(
                disciplina.getCompetenciaNecessaria())) {

            return 100;
        }

        return 0;
    }
}
