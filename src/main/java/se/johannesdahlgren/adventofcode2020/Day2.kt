package se.johannesdahlgren.adventofcode2020

class Day2(fileName: String) {
    private val input = readFileToStringList(fileName)
    private var correctPasswords = 0

    fun getCorrectPasswordsSledRental(): Int {
        input.forEach { s ->
            val splits = splitInputByRegex(s)
            val (_, min, max, key, password) = splits.destructured

            val count = password.count { key[0] == it }
            if (count in min.toInt()..max.toInt()) {
                correctPasswords++
            }
        }
        return correctPasswords
    }

    fun getCorrectPasswordsTobogganCorp(): Int {
        input.forEach { s ->
            val splits = splitInputByRegex(s)
            val (_, min, max, key, password) = splits.destructured

            val matchPos1 = password[min.toInt() - 1] == key[0]
            val matchPos2 = password[max.toInt() - 1] == key[0]
            if (matchPos1.xor(matchPos2)) {
                correctPasswords++
            }
        }
        return correctPasswords
    }

    private fun splitInputByRegex(s: String): MatchResult {
        val regex = Regex("((\\d+)-(\\d+) (\\S): (.*))")
        return regex.find(s)!!
    }
}