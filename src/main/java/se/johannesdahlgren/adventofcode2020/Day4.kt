package se.johannesdahlgren.adventofcode2020

class Day4(private val fileName: String) {

    private val mandatoryFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

    fun getPassportsWithRequiredFields(): Int {
        val passPorts = getPassportsFromFile()
        return passPorts.count { passport -> mandatoryFields.all { passport.contains(it) }}
    }

    fun getValidPassports(): Long {
        val passPorts = getPassportsFromFile()

        return passPorts.stream()
            .filter { hasCorrectValues(it) }
            .count()
    }

    private fun hasCorrectValues(passPort: String): Boolean {
        val validByr = "byr:(19[2-9]\\d|200[0-2])".toRegex().containsMatchIn(passPort)
        val validIyr = "iyr:(201\\d|2020)".toRegex().containsMatchIn(passPort)
        val validEyr = "eyr:(202\\d|2030)".toRegex().containsMatchIn(passPort)
        val validHgt = "hgt:((1([5-8]\\d|9[0-3])cm)|((59|(6\\d)|(7[0-6]))in))".toRegex().containsMatchIn(passPort)
        val validHcl = "hcl:#[0-9|a-f]{6}".toRegex().containsMatchIn(passPort)
        val validEcl = "ecl:(amb|blu|brn|gry|grn|hzl|oth)".toRegex().containsMatchIn(passPort)
        val validPid = "pid:\\d{9}\\b".toRegex().containsMatchIn(passPort)
        return validByr && validIyr && validEyr && validHcl && validEcl && validPid && validHgt
    }

    private fun getPassportsFromFile(): List<String> {
        return  readFileToStringListSplitEmptyLine(fileName)
    }
}