package se.johannesdahlgren.adventofcode2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day13Test {
    @Test
    fun part1Example() {
        val day13 = Day13()
        val result: Pair<Int, Int> = day13.getBusIdAndTimeToNextDeparture(readFileToStringList("day13Example"))
        assertEquals(295, result.first * result.second)
    }

    @Test
    fun part1() {
        val day13 = Day13()
        val result: Pair<Int, Int> = day13.getBusIdAndTimeToNextDeparture(readFileToStringList("day13"))
        assertEquals(2298, result.first * result.second)
    }
}