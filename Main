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

        // Repositório com dados de exemplo
        DadosExemploRepository repository =
                new DadosExemploRepository();

        // Estratégia de match
        CompetenciaStrategy strategy =
                new CompetenciaStrategy();

        // Serviços
        MatchService matchService =
                new MatchService(strategy);

        VerificadorConflitosService verificador =
                new VerificadorConflitosService();

        GeradorGradeService gerador =
                new GeradorGradeService(
                        matchService,
                        verificador);

        // Inicializa GUI
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
