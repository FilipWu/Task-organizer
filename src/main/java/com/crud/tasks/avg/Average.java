package com.crud.tasks.avg;

import java.util.List;

public class Average {
    public double average (List<Integer> oceny, List <Integer> wagi) {
        for (int ocena : oceny) {
            if (ocena < 1 || ocena > 6) {
                throw new IllegalArgumentException("Nieprawidłowa ocena: " + ocena + ". Dozwolony zakres to 1-6.");
            }
        }

        for (int waga : wagi) {
            if (waga < 1 || waga > 10) {
                throw new IllegalArgumentException("Nieprawidłowa waga: " + waga + ". Dozwolony zakres to 1 - 10.");
            }
        }

        if (oceny.size() != wagi.size()){
            throw new IllegalArgumentException("Lista ocen i wag musi mieć tą samą długość");
        }

        if (oceny.isEmpty() || wagi.isEmpty()) {
            throw new IllegalArgumentException("Listy nie mogą być puste");
        }

        int sumaWazona = 0;
        int sumaWag = 0;;

        for (int i = 0; i< oceny.size(); i++) {
            sumaWazona += oceny.get(i) * wagi.get(i);
            sumaWag += wagi.get(i);
        }
        return (double) sumaWazona / sumaWag;

    }
}
