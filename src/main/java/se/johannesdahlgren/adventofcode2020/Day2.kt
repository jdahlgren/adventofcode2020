package se.johannesdahlgren.adventofcode2020

class Day2(fileName: String) {
    private val input = readFileToStringList(fileName)
    private var correctPasswords = 0

    fun getCorrectPasswords(system: String): Int {
        input.forEach { s ->
            val policyPassword = s.split(":")
            val minMaxChar = policyPassword[0].split(" ")
            val password = policyPassword[1].trim()
            val minMax = minMaxChar[0].split("-")
            val key = minMaxChar[1][0]
            val min = minMax[0].toInt()
            val max = minMax[1].toInt()

            if(system == "sledRental") {
                val count = password.count { key == it }
                if (count in min..max) {
                    correctPasswords++
                }
            }

            if(system == "tobogganCorp") {
                if ((password[min - 1] == key).xor(password[max - 1] == key)) {
                    correctPasswords++
                }
            }

        }

        return correctPasswords
    }
}