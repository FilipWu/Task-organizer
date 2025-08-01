package com.crud.tasks.avg;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AverageTest {

    @Test
    void average() {
        List<Integer> oceny = List.of(3, 1, 1, 5, 6, 4);
		List<Integer> wagi = List.of(4, 6, 8, 4, 4, 10);

		Average average = new Average();

		double wynik = average.average(oceny,wagi);

		System.out.println(wynik);

        assertEquals(3.055,wynik,0.001);
    }
}