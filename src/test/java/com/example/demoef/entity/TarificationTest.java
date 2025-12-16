package com.example.demoef.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarificationTest {
    @Test
    void testCalculPrixParSection() {
        double prixBaseOffre = 100.0;
        double coefficientEconomique = 0.75;
        double coefficientAffaires = 1.25;

        double prixClasseEconomique = prixBaseOffre * coefficientEconomique;
        double prixClasseAffaires = prixBaseOffre * coefficientAffaires;

        assertEquals(75.0, prixClasseEconomique);
        assertEquals(125.0, prixClasseAffaires);
    }
}

