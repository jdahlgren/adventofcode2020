package se.johannesdahlgren.adventofcode2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day4Test {

    @Test
    fun part1Example() {
        val day4 = Day4("day4_example.txt")
        val validPassports = day4.getValidPassports()
        assertEquals(2, validPassports)
    }

    @Test
    fun part1() {
        val day4 = Day4("day4.txt")
        val validPassports = day4.getValidPassports()
        assertEquals(170, validPassports)
    }
}