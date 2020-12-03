package se.johannesdahlgren.adventofcode2020

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day3Test {

    @Test
    fun part1Example() {
        val day3 = Day3("day3_example.txt")
        val trees = day3.countTrees()
        assertEquals(7, trees)
    }

    @Test
    fun part1() {
        val day3 = Day3("day3.txt")
        val trees = day3.countTrees()
        assertEquals(207, trees)
    }
}