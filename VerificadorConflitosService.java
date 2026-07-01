package service;

import domain.Alocacao;
import domain.Grade;

import java.util.ArrayList;
import java.util.List;

public class VerificadorConflitosService {

    public List<String> verificarConflitos(Grade grade) {

        List<String> conflitos = new ArrayList<>();

        List<Alocacao> alocacoes = grade.getAlocacoes();

        for (int i = 0; i < alocacoes.size(); i++) {

            Alocacao atual = alocacoes.get(i);

            for (int j = i + 1; j < alocacoes.size(); j++) {

                Alocacao outra = alocacoes.get(j);

                if (atual.getHorario().equals(outra.getHorario())) {

                    if (atual.getProfessor().equals(outra.getProfessor())) {

                        conflitos.add(
                                "Professor "
                                        + atual.getProfessor().getNome()
                                        + " possui conflito em "
                                        + atual.getHorario());

                    }

                }

            }

        }

        return conflitos;

    }

}
