package domain;

import exception.DadosInvalidosException;

public class Disciplina {

    private String codigo;
    private String nome;
    private int cargaHoraria;
    private Competencia competenciaNecessaria;

    public Disciplina(String codigo,
                      String nome,
                      int cargaHoraria,
                      Competencia competenciaNecessaria) {

        if (codigo == null || codigo.isBlank())
            throw new DadosInvalidosException("Código inválido.");

        if (nome == null || nome.isBlank())
            throw new DadosInvalidosException("Nome inválido.");

        if (cargaHoraria <= 0)
            throw new DadosInvalidosException("Carga horária inválida.");

        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.competenciaNecessaria = competenciaNecessaria;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public Competencia getCompetenciaNecessaria() {
        return competenciaNecessaria;
    }

    @Override
    public String toString() {
        return nome;
    }

}
