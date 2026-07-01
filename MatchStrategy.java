package service.strategy;

import domain.Disciplina;
import domain.Professor;

public interface MatchStrategy {

    int calcularPontuacao(Professor professor, Disciplina disciplina);

}
