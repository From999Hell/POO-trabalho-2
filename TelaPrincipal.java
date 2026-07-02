package gui;

import domain.Alocacao;
import repository.DadosExemploRepository;
import service.GeradorGradeService;
import service.ResultadoGeracao;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {

    private final DadosExemploRepository repository;
    private final GeradorGradeService gerador;

    private JList<String> listaProfessores;
    private JList<String> listaDisciplinas;

    private JTextArea areaGrade;
    private JTextArea areaConflitos;

    private JButton botaoGerar;

    public TelaPrincipal(
            DadosExemploRepository repository,
            GeradorGradeService gerador) {

        this.repository = repository;
        this.gerador = gerador;

        inicializarComponentes();
        carregarDados();
        configurarEventos();

        setTitle("Gerador de Grade");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void inicializarComponentes() {

        setLayout(new BorderLayout());

        JPanel painelSuperior = new JPanel(new GridLayout(1, 2));

        listaProfessores = new JList<>();
        listaDisciplinas = new JList<>();

        painelSuperior.add(new JScrollPane(listaProfessores));
        painelSuperior.add(new JScrollPane(listaDisciplinas));

        add(painelSuperior, BorderLayout.NORTH);

        areaGrade = new JTextArea();
        areaGrade.setEditable(false);

        areaConflitos = new JTextArea();
        areaConflitos.setEditable(false);

        JPanel painelCentro = new JPanel(new GridLayout(2,1));

        painelCentro.add(new JScrollPane(areaGrade));
        painelCentro.add(new JScrollPane(areaConflitos));

        add(painelCentro, BorderLayout.CENTER);

        botaoGerar = new JButton("Gerar Grade");

        add(botaoGerar, BorderLayout.SOUTH);

    }

    private void carregarDados() {

        DefaultListModel<String> professores =
                new DefaultListModel<>();

        repository.getProfessores()
                .forEach(p -> professores.addElement(p.getNome()));

        listaProfessores.setModel(professores);

        DefaultListModel<String> disciplinas =
                new DefaultListModel<>();

        repository.getDisciplinas()
                .forEach(d -> disciplinas.addElement(d.getNome()));

        listaDisciplinas.setModel(disciplinas);

    }

    private void configurarEventos() {

        botaoGerar.addActionListener(e -> gerarGrade());

    }

    private void gerarGrade() {

        ResultadoGeracao resultado = gerador.gerarGrade(

                repository.getProfessores(),

                repository.getDisciplinas(),

                repository.getHorarios()

        );

        StringBuilder grade = new StringBuilder();

        for (Alocacao alocacao : resultado.getGrade().getAlocacoes()) {

            grade.append(alocacao.getHorario())
                    .append(" - ")
                    .append(alocacao.getDisciplina().getNome())
                    .append(" - ")
                    .append(alocacao.getProfessor().getNome())
                    .append("\n");

        }

        areaGrade.setText(grade.toString());

        if (resultado.getConflitos().isEmpty()) {

            areaConflitos.setText("Nenhum conflito encontrado.");

        } else {

            StringBuilder conflitos = new StringBuilder();

            resultado.getConflitos()
                    .forEach(c -> conflitos.append(c).append("\n"));

            areaConflitos.setText(conflitos.toString());

        }

    }

}
