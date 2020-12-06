package se.johannesdahlgren.adventofcode2020

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day6Test {

    @Test
    fun part1Example() {
        val day6 = Day6()
        val sumYeses = day6.sumYes("day6_example")
        assertEquals(11, sumYeses)
    }

    @Test
    fun part1() {
        val day6 = Day6()
        val sumYeses = day6.sumYes("day6")
        assertEquals(7128, sumYeses)
    }
}