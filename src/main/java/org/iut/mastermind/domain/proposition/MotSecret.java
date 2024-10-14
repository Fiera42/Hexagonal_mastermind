package org.iut.mastermind.domain.proposition;

import java.util.Objects;

public record MotSecret (String motSecret) {
    public MotSecret {
        Objects.requireNonNull(motSecret);
    }

    public Reponse compareProposition(String essai) {
        return Reponse.create(motSecret, essai);
    }
}
