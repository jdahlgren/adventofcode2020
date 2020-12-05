package se.johannesdahlgren.adventofcode2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day4Test {

    @Test
    fun part1Example() {
        val day4 = Day4("day4_example.txt")
        val validPassports = day4.getPassportsWithRequiredFields()
        assertEquals(2, validPassports)
    }

    @Test
    fun part1() {
        val day4 = Day4("day4.txt")
        val validPassports = day4.getPassportsWithRequiredFields()
        assertEquals(170, validPassports)
    }

    @Test
    fun part2InvalidExample() {
        val day4 = Day4("day4_part2_invalid_example.txt")
        val validPassports = day4.getValidPassports()
        assertEquals(0, validPassports)
    }

    @Test
    fun part2ValidExample() {
        val day4 = Day4("day4_part2_valid_example.txt")
        val validPassports = day4.getValidPassports()
        assertEquals(4, validPassports)
    }

    @Test
    fun part2() {
        val day4 = Day4("day4.txt")
        val validPassports = day4.getValidPassports()
        assertEquals(103, validPassports)
    }
}