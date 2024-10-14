package org.iut.mastermind.domain.proposition;

public record MotSecret (String motSecret) {

    public Reponse compareProposition(String essai) {
        return Reponse.create(motSecret, essai);
    }
}
