package se.johannesdahlgren.adventofcode2020

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Test {

    @Test
    fun findSumPart1Example() {
        val day1 = Day1("day1_example.txt")
        val answer = day1.fixExpenseReport(2020)

        assertEquals(514579, answer)
    }

    @Test
    fun findSumPart2Example() {
        val day1 = Day1("day1_example.txt")
        val answer = day1.fixExpenseReport(2020)

        assertEquals(241861950, answer)
    }

}