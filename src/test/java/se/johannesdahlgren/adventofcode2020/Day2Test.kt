package se.johannesdahlgren.adventofcode2020

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day2Test {

    @Test
    fun part1Example() {
        val day2 = Day2("day2_example.txt")

        val numberOfCorrectPasswords = day2.getCorrectPasswordsSledRental()
        assertEquals(2, numberOfCorrectPasswords)
    }

    @Test
    fun part1() {
        val day2 = Day2("day2.txt")

        val numberOfCorrectPasswords = day2.getCorrectPasswordsSledRental()
        assertEquals(640, numberOfCorrectPasswords)
    }

    @Test
    fun part2Example() {
        val day2 = Day2("day2_example.txt")

        val numberOfCorrectPasswords = day2.getCorrectPasswordsTobogganCorp()
        assertEquals(1, numberOfCorrectPasswords)
    }

    @Test
    fun part2() {
        val day2 = Day2("day2.txt")

        val numberOfCorrectPasswords = day2.getCorrectPasswordsTobogganCorp()
        assertEquals(472, numberOfCorrectPasswords)
    }
}