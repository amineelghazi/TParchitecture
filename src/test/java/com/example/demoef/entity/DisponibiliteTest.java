package com.example.demoef.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisponibiliteTest {
    @Test
    void testDisponibiliteSieges() {
        int nombreTotalSiegesSection = 3;
        List<Integer> numerosSiegesOccupes = new ArrayList<>();
        numerosSiegesOccupes.add(1);
        numerosSiegesOccupes.add(2);

        int nombreSiegesDisponibles = nombreTotalSiegesSection - numerosSiegesOccupes.size();

        assertTrue(nombreSiegesDisponibles > 0);
    }
}
