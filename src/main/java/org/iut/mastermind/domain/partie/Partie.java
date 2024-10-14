package org.iut.mastermind.domain.partie;

import org.iut.mastermind.domain.proposition.MotSecret;
import org.iut.mastermind.domain.proposition.Reponse;

public class Partie {
    private static final int NB_ESSAIS_MAX = 5;
    private final Joueur joueur;
    private final MotSecret motSecret;
    private int nbEssais;
    private boolean partieTerminee;

    public Partie(Joueur joueur, MotSecret motSecret, int nbEssais, boolean partieTerminee) {
        this.joueur = joueur;
        this.motSecret = motSecret;
        this.nbEssais = nbEssais;
        this.partieTerminee = partieTerminee;
    }

    public static Partie create(Joueur joueur, String motADeviner) {
        return new Partie(joueur, new MotSecret(motADeviner), 0, false);
    }

    public static Partie create(Joueur joueur, String motADeviner, int nbEssais) {
        return new Partie(joueur, new MotSecret(motADeviner), nbEssais, false);
    }

    public Reponse tourDeJeu(String motPropose) {
        if(isTerminee()) return Reponse.ERROR;

        Reponse reponse = motSecret.compareProposition(motPropose);
        if(reponse.isBonneReponse()) terminerPartie();

        nbEssais++;

        return reponse;
    }

    // ----------------------------- Getter

    public boolean isTerminee() {
        if(nbEssais >= NB_ESSAIS_MAX) terminerPartie();
        return partieTerminee;
    }

    public void terminerPartie() {
        partieTerminee = true;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public int getNbEssais() {
        return nbEssais;
    }

    public String getMotSecret() {
        return motSecret.motSecret();
    }
}
