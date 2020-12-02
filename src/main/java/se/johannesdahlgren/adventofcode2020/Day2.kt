package se.johannesdahlgren.adventofcode2020

class Day2(private val fileName: String) {
    private data class Holder<A, B, C>(val a: A, val b: A, val c: B, val d: C)

    fun getCorrectPasswordsSledRental(): Long {
        return readFileToStringList(fileName).stream()
            .map { regexToHolder(it) }
            .filter { (min, max, key, password) ->
                password.count { it == key } in min..max
            }
            .count()
    }

    fun getCorrectPasswordsTobogganCorp(): Long {
        return readFileToStringList(fileName).stream()
            .map { regexToHolder(it) }
            .filter { (min, max, key, password) ->
                (password[min - 1] == key).xor(password[max - 1] == key)
            }
            .count()
    }

    private fun regexToHolder(line: String): Holder<Int, Char, String> {
        val (_, min, max, key, password) = "((\\d+)-(\\d+) (\\S): (.*))".toRegex().find(line)!!.destructured
        return Holder(min.toInt(), max.toInt(), key[0], password)
    }
}