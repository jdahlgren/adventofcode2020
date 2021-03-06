package se.johannesdahlgren.adventofcode2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.abs

internal class Day12Test {
    @Test
    fun part1Example() {
        val day12 = Day12()
        val position = day12.getPositionFromStart(readFileToStringList("day12Example"))
        assertEquals(25, abs(position.first) + abs(position.second))
    }

    @Test
    fun part1() {
        val day12 = Day12()
        val position = day12.getPositionFromStart(readFileToStringList("day12"))
        assertEquals(820, abs(position.first) + abs(position.second))
    }

    @Test
    fun part2Example() {
        val day12 = Day12()
        val position = day12.getPositionFromStartWithWaypoint(readFileToStringList("day12Example"), Pair(10, 1))
        assertEquals(286, abs(position.first) + abs(position.second))
    }

    @Test
    fun part2() {
        val day12 = Day12()
        val position = day12.getPositionFromStartWithWaypoint(readFileToStringList("day12"), Pair(10, 1))
        assertEquals(66614, abs(position.first) + abs(position.second))
    }
}
