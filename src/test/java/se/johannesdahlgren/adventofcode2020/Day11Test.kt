package se.johannesdahlgren.adventofcode2020

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day11Test {

    @Test
    fun part1Example() {
        val day11 = Day11()
        val occupiedSeats = day11.getOccupiedSeatsWhenStable(readFileTo2DArray("day11Example"))
        assertEquals(37, occupiedSeats)
    }

    @Test
    fun part1() {
        val day11 = Day11()
        val occupiedSeats = day11.getOccupiedSeatsWhenStable(readFileTo2DArray("day11"))
        assertEquals(2263, occupiedSeats)
    }

    @Test
    fun part2Example() {
        val day11 = Day11()
        val occupiedSeats = day11.getOccupiedVisibleSeatsWhenStable(readFileTo2DArray("day11Example"))
        assertEquals(26, occupiedSeats)
    }

    @Test
    fun part2() {
        val day11 = Day11()
        val occupiedSeats = day11.getOccupiedVisibleSeatsWhenStable(readFileTo2DArray("day11"))
        assertEquals(2002, occupiedSeats)
    }
}