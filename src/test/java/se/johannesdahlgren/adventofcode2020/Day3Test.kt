package se.johannesdahlgren.adventofcode2020

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day3Test {

    @Test
    fun part1Example() {
        val day3 = Day3("day3_example.txt")
        val trees = day3.countTrees(3, 1)
        assertEquals(7, trees)
    }

    @Test
    fun part1() {
        val day3 = Day3("day3.txt")
        val trees = day3.countTrees(3, 1)
        assertEquals(207, trees)
    }

    @Test
    fun part2Example() {
        val day3 = Day3("day3_example.txt")
        val trees = day3.countTreesInAllSlopes()
        assertEquals(336, trees)
    }

    @Test
    fun part2() {
        val day3 = Day3("day3.txt")
        val trees = day3.countTreesInAllSlopes()
        assertEquals(2655892800, trees)
    }
}