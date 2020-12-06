package se.johannesdahlgren.adventofcode2020

class Day6 {
    fun sumAnyoneYes(fileName: String): Int {
        val answersFromGroups = readFileToStringListSplitEmptyLine(fileName)
        return answersFromGroups.stream()
            .map { it.replace("\r\n", "") }
            .map { it.toCharArray() }
            .map { it.distinct() }
            .map { it.count() }
            .reduce { a, b -> a + b }
            .orElse(-1)
    }

    fun sumEveryoneYes(fileName: String): Int {
        val answersFromGroups = readFileToStringListSplitEmptyLine(fileName)
        var count = 0
        for (answersFromGroup in answersFromGroups) {
            val answersFromPersonsInGroup = answersFromGroup.trim()
                .split(Regex("\r\n", RegexOption.MULTILINE))
            var mutableSetOf = answersFromPersonsInGroup[0].toCharArray().toSet()
            for (answersFromPerson in answersFromPersonsInGroup) {
                mutableSetOf = answersFromPerson.toCharArray().intersect(mutableSetOf)
            }
            count += mutableSetOf.count()
        }

        return count
    }
}