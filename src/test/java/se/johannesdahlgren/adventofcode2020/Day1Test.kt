package se.johannesdahlgren.adventofcode2020

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Test {

    @Test
    fun fixExpenseReportPart1Example() {
        val day1 = Day1("day1_example.txt")
        val answer = day1.fixExpenseReport(2020)

        assertEquals(514579, answer)
    }

    @Test
    fun fixExpenseReportPart1() {
        val day1 = Day1("day1.txt")
        val answer = day1.fixExpenseReport(2020)

        assertEquals(259716, answer)
    }

    @Test
    fun fixExpenseReportPart2Example() {
        val day1 = Day1("day1_example.txt")
        val answer = day1.fixExpenseReportThree(2020)

        assertEquals(241861950, answer)
    }

    @Test
    fun fixExpenseReportPart2() {
        val day1 = Day1("day1.txt")
        val answer = day1.fixExpenseReportThree(2020)

        assertEquals(120637440, answer)
    }
}