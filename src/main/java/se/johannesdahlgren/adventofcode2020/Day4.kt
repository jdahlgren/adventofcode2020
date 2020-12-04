package se.johannesdahlgren.adventofcode2020

import kotlin.streams.toList

class Day4(private val fileName: String) {

    private val blankLinePattern = "^\\s*\$"
    private val mandatoryFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

    fun getValidPassports(): Long {
        val batchFile = readFileToString(fileName)
        val passPorts = batchFile.split(Regex(blankLinePattern, RegexOption.MULTILINE))

        return passPorts.stream()
            .map { getPassportKeys(it) }
            .filter { it.containsAll(mandatoryFields) }
            .count()

    }

    private fun getPassportKeys(passPort: String): List<String> {
        val matchPassportKeys = "(.{3}):".toRegex().findAll(passPort).toList()
        return matchPassportKeys.stream ()
            .map { it.groupValues[1] }
            .toList()
    }
}