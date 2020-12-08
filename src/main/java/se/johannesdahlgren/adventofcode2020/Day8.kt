package se.johannesdahlgren.adventofcode2020

class Day8(private val instructions: List<String>) {
    private var accumulator = 0
    private val usedIndexes = mutableSetOf<Int>()

    fun getValueInAccumulator(currentInstruction: Int): Int {
        val firstTime = usedIndexes.add(currentInstruction)
        if (!firstTime) {
            return accumulator
        }
        val split = instructions[currentInstruction].split(" ")
        val operation = split[0]
        val argument = split[1].toInt()

        if (operation == "nop") {
            getValueInAccumulator(currentInstruction + 1)
        } else if (operation == "acc") {
            accumulator += argument
            getValueInAccumulator(currentInstruction + 1)
        } else if (operation == "jmp") {
            getValueInAccumulator(currentInstruction + argument)
        }
        return accumulator
    }
}