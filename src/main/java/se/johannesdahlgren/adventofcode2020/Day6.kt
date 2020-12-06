package se.johannesdahlgren.adventofcode2020

class Day6 {
    fun sumYes(fileName: String): Int {
        val answersFromGroups = readFileToStringListSplitEmptyLine(fileName)
        return answersFromGroups.stream()
            .map { it.replace("\r\n", "") }
            .map { it.toCharArray() }
            .map { it.distinct() }
            .map { it.count() }
            .reduce { a, b -> a + b }
            .orElse(-1)
    }
}