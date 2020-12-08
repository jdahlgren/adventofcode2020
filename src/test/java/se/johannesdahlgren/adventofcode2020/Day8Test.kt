package se.johannesdahlgren.adventofcode2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day8Test {
    @Test
    fun part1Example() {
        val day8 = Day8(readFileToStringList("day8Example"))
        val accumulatorValue = day8.getValueInAccumulator(0)
        assertEquals(5, accumulatorValue)
    }

    @Test
    fun part1() {
        val day8 = Day8(readFileToStringList("day8"))
        val accumulatorValue = day8.getValueInAccumulator(0)
        assertEquals(1446, accumulatorValue)
    }

    @Test
    fun part2Example() {
        val day8 = Day8(readFileToStringList("day8Example"))
        val accumulatorValue = day8.fixAndGetValueInAccumulator()
        assertEquals(8, accumulatorValue)
    }

    @Test
    fun part2() {
        val day8 = Day8(readFileToStringList("day8"))
        val accumulatorValue = day8.fixAndGetValueInAccumulator()
        assertEquals(1403, accumulatorValue)
    }
}