package domain;

import java.util.Objects;

public final class Horario {

    private final DiaSemana dia;
    private final Periodo periodo;

    public Horario(DiaSemana dia, Periodo periodo) {

        this.dia = Objects.requireNonNull(dia);
        this.periodo = Objects.requireNonNull(periodo);
    }

    public DiaSemana getDia() {
        return dia;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Horario))
            return false;

        Horario outro = (Horario) obj;

        return dia == outro.dia &&
               periodo == outro.periodo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dia, periodo);
    }

    @Override
    public String toString() {
        return dia + " - " + periodo;
    }

}
