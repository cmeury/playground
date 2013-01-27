package ch.wurmlo.week5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Question1Test {

    @Test
    public void shouldSolveSimpleCases() throws Exception {
        assertEquals(6, TspCalculator.calculateTsp(new TspReader("tsp_simple.txt").getCities()), 0.001);
        assertEquals(8387, TspCalculator.calculateTsp(new TspReader("tsp_firstfive.txt").getCities()), 0.001);
        assertEquals(8607, TspCalculator.calculateTsp(new TspReader("tsp_firstsix.txt").getCities()), 0.001);
    }

}
