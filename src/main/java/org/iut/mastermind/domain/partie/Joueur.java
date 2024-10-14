package org.iut.mastermind.domain.partie;

import java.util.Objects;

public record Joueur (String nom) {
    public Joueur {
        Objects.requireNonNull(nom);
    }
}
