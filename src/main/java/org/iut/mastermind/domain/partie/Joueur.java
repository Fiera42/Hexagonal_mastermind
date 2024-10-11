package org.iut.mastermind.domain.partie;

import java.util.Objects;

public class Joueur {

    private final String nom;

    // constructeur
    public Joueur(String nom) {
        this.nom = nom;
    }

    // getter nom joueur
    public String getNom() {
        return nom;
    }

    // equals
    @Override
    public boolean equals(Object o) {
       if(o == null) return false;
       if(o instanceof Joueur other) {
           return nom.equals(other.nom);
       }
       return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
}
