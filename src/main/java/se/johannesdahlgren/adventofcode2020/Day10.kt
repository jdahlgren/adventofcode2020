package se.johannesdahlgren.adventofcode2020

class Day10 {
    fun getJoltDiff(input: List<Int>): Int {
        var oneJolts = 0
        var threeJolts = 0
        var currentJolt = 0
        input.sorted().forEach { adapter ->
            when (adapter) {
                currentJolt + 1 -> {
                    oneJolts++
                }
                currentJolt + 3 -> {
                    threeJolts++
                }
            }
            currentJolt = adapter
        }

        return oneJolts * ++threeJolts
    }
}