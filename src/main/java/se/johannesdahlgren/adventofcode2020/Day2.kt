package se.johannesdahlgren.adventofcode2020

import kotlin.streams.toList

class Day2(fileName: String) {
    private val input = readFileToStringList(fileName)
    private var correctPasswords = 0

    fun getCorrectPasswords(): Int {

        val test = input.stream()
            .map { it.split(Regex(":")) }
            .map { it[0] to it[1] }
            .map { it.first.split(Regex(" ")) to it.second}
            .map { it.first[0] to it.first[1] to it.second }
            .map { val split = it.first.first.split(Regex("-"))
                split[0] to split[1] to it.first.second to it.second
            }
            .toList()

        test.forEach { pair ->
            val min = pair.first.first.first.toInt()
            val max = pair.first.first.second.toInt()
            val key = pair.first.second
            val password = pair.second

            val count = password.count { key.contains(it) }
            if(count in min..max) {
                correctPasswords++
            }
        }

        return correctPasswords
    }


}