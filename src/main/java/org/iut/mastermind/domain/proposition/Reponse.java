package org.iut.mastermind.domain.proposition;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.Collections.unmodifiableList;

public record Reponse(String proposition, List<Lettre> resultat, boolean isBonneReponse, boolean isError) {

    public static Reponse ERROR = new Reponse("/!\\ ERROR /!\\", List.of(), false, true);

    public static Reponse create(String motSecret, String proposition) {
        List<Lettre> resultat = compare(motSecret, proposition);

        return new Reponse(proposition, resultat, lettresToutesPlacees(motSecret, resultat), false);
    }

    private static List<Lettre> compare(String motSecret, String essai) {
        return IntStream.range(0, essai.length())
                .mapToObj(i -> evalLettre(motSecret, essai.charAt(i), i))
                .toList();
    }

    private static Lettre evalLettre(String motSecret, char lettre, int index) {
        if(estPlace(motSecret, lettre, index)) return Lettre.PLACEE;
        if(estPresent(motSecret, lettre)) return Lettre.NON_PLACEE;
        return Lettre.INCORRECTE;
    }

    private static boolean estPresent(String motSecret, char carCourant) {
        return motSecret.indexOf(carCourant) != -1;
    }

    private static boolean estPlace(String motSecret, char carCourant, int index) {
        if(index < 0 || index >= motSecret.length()) return false;
        return motSecret.charAt(index) == carCourant;
    }

    private static boolean lettresToutesPlacees(String motSecret, List<Lettre> resultat) {
        if(resultat.size() != motSecret.length()) return false;
        return resultat.stream().allMatch(e -> e == Lettre.PLACEE);
    }
}