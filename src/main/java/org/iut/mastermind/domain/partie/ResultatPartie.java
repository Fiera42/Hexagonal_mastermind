package org.iut.mastermind.domain.partie;

import org.iut.mastermind.domain.proposition.Reponse;

import java.util.Objects;

public record ResultatPartie(Reponse resultat, boolean isTermine, boolean isError) {
    public static final ResultatPartie ERROR = new ResultatPartie(null, true, true);

    public static ResultatPartie create(Reponse resultat, boolean isTermine) {
        if(resultat.equals(Reponse.ERROR)) return ERROR;

        return new ResultatPartie(resultat, isTermine, false);
    }

    public ResultatPartie {
        Objects.requireNonNull(resultat);
    }
}
