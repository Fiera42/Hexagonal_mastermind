package org.iut.mastermind.domain.proposition;

import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.unmodifiableList;

public class Reponse {
    private final String motSecret;
    private final List<Lettre> resultat = new ArrayList<>();
    private int position;

    public Reponse(String mot) {
        this.motSecret = mot;
    }

    // on récupère la lettre à la position dans le résultat
    public Lettre lettre(int position) {
        if(position < 0 || position > resultat.size()) throw new IllegalArgumentException("Invalid position");

        return this.resultat.get(position);
    }

    // on construit le résultat en analysant chaque lettre
    // du mot proposé
    public void compare(String essai) {
        resultat.clear();
        for(position = 0; position < motSecret.length(); position++) {
            resultat.add(evaluationCaractere(essai.charAt(position)));
        }
    }

    // si toutes les lettres sont placées
    public boolean lettresToutesPlacees() {
        if(resultat.size() != motSecret.length()) return false;
        return resultat.stream().allMatch(e -> e == Lettre.PLACEE);
    }

    public List<Lettre> lettresResultat() {
        return unmodifiableList(resultat);
    }

    // renvoie le statut du caractère
    private Lettre evaluationCaractere(char carCourant) {
        if(estPlace(carCourant)) return Lettre.PLACEE;
        return (estPresent(carCourant)) ? Lettre.NON_PLACEE : Lettre.INCORRECTE;
    }

    // le caractère est présent dans le mot secret
    private boolean estPresent(char carCourant) {
        return motSecret.indexOf(carCourant) != -1;
    }

    // le caractère est placé dans le mot secret
    private boolean estPlace(char carCourant) {
        return motSecret.charAt(position) == carCourant;
    }
}
