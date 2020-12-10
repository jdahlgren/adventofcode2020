package se.johannesdahlgren.adventofcode2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day10Test {
    @Test
    fun part1Example1() {
        val day10 = Day10()
        val input = listOf(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4)
        val joltDiff = day10.getJoltDiff(input)
        assertEquals(7 * 5, joltDiff)
    }

    @Test
    fun part1Example2() {
        val day10 = Day10()
        val input = listOf(
            28, 33, 18, 42, 31, 14, 46, 20, 48, 47, 24, 23, 49,
            45, 19, 38, 39, 11, 1, 32, 25, 35, 8, 17, 7, 9, 4, 2, 34, 10, 3
        )
        val joltDiff = day10.getJoltDiff(input)
        assertEquals(22 * 10, joltDiff)
    }

    @Test
    fun part1() {
        val day10 = Day10()
        val input = readFileToIntList("day10")
        val joltDiff = day10.getJoltDiff(input)
        assertEquals(3000, joltDiff)
    }
}