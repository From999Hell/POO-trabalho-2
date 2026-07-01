package service;

import domain.Disciplina;
import domain.Professor;
import service.strategy.MatchStrategy;

import java.util.Comparator;
import java.util.List;

public class MatchService {

    private MatchStrategy strategy;

    public MatchService(MatchStrategy strategy) {
        this.strategy = strategy;
    }

    public Professor encontrarMelhorProfessor(
            Disciplina disciplina,
            List<Professor> professores) {

        return professores.stream()

                .filter(p ->
                        strategy.calcularPontuacao(
                                p,
                                disciplina) > 0)

                .max(Comparator.comparingInt(
                        p -> strategy.calcularPontuacao(
                                p,
                                disciplina)))

                .orElse(null);
    }

}
