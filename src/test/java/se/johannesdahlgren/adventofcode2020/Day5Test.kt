package se.johannesdahlgren.adventofcode2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day5Test {
    @Test
    fun part1Example1() {
        val day5 = Day5()
        val seatId = day5.findSeatId("BFFFBBFRRR")
        assertEquals(567, seatId)
    }

    @Test
    fun part1Example2() {
        val day5 = Day5()
        val seatId = day5.findSeatId("FFFBBBFRRR")
        assertEquals(119, seatId)
    }

    @Test
    fun part1Example3() {
        val day5 = Day5()
        val seatId = day5.findSeatId("BBFFBBFRLL")
        assertEquals(820, seatId)
    }

    @Test
    fun part1Example4() {
        val day5 = Day5()
        val maxSeatId = day5.highestSeatId(listOf("BFFFBBFRRR", "BFFFBBFRRR", "BBFFBBFRLL"))
        assertEquals(820, maxSeatId)
    }

    @Test
    fun part1() {
        val day5 = Day5()
        val highestSeatId = day5.highestSeatId(readFileToStringList("day5"))
        assertEquals(888, highestSeatId)
    }

    @Test
    fun part2() {
        val day5 = Day5()
        val mySeat = day5.findMySeat(readFileToStringList("day5"))
        assertEquals(522, mySeat)
    }
}