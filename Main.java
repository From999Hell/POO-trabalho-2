package app;

import gui.TelaPrincipal;
import repository.DadosExemploRepository;
import service.GeradorGradeService;
import service.MatchService;
import service.VerificadorConflitosService;
import service.strategy.CompetenciaStrategy;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        DadosExemploRepository repository =
                new DadosExemploRepository();

        MatchService matchService =
                new MatchService(
                        new CompetenciaStrategy());

        VerificadorConflitosService verificador =
                new VerificadorConflitosService();

        GeradorGradeService gerador =
                new GeradorGradeService(
                        matchService,
                        verificador);

        SwingUtilities.invokeLater(() -> {

            TelaPrincipal tela =
                    new TelaPrincipal(
                            repository,
                            gerador,
                            verificador);

            tela.setVisible(true);

        });

    }

}
