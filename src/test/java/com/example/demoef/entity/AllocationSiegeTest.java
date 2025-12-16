package com.example.demoef.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllocationSiegeTest {
    @Test
    void testAllocationPremierSiegeDisponible() {
        int nombreTotalSiegesSection = 3;
        List<Integer> numerosSiegesOccupes = new ArrayList<>();
        numerosSiegesOccupes.add(1);
        numerosSiegesOccupes.add(2);

        int numeroSiegeAttribue = -1;
        for (int numeroCandidat = 1; numeroCandidat <= nombreTotalSiegesSection; numeroCandidat++) {
            boolean siegeLibre = true;
            for (int indice = 0; indice < numerosSiegesOccupes.size(); indice++) {
                if (numerosSiegesOccupes.get(indice) == numeroCandidat) {
                    siegeLibre = false;
                    break;
                }
            }
            if (siegeLibre) {
                numeroSiegeAttribue = numeroCandidat;
                break;
            }
        }
        assertEquals(3, numeroSiegeAttribue);
    }
}
