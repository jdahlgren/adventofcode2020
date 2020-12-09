package se.johannesdahlgren.adventofcode2020

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day9Test {

    @Test
    fun part1Example() {
        val input = listOf(35, 20, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576)
        val day9 = Day9(input)
        val invalidNumber = day9.findFirstInvalidNumber(5)
        assertEquals(127, invalidNumber)
    }

    @Test
    fun part1() {
        val input = readFileToLongList("day9").map { it.toInt() }
        val day9 = Day9(input)
        val invalidNumber = day9.findFirstInvalidNumber(25)
        assertEquals(70639851, invalidNumber)
    }
}