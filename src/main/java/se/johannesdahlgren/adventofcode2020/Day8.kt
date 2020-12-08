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

        when (operation) {
            "nop" -> {
                getValueInAccumulator(currentInstruction + 1)
            }
            "acc" -> {
                accumulator += argument
                getValueInAccumulator(currentInstruction + 1)
            }
            "jmp" -> {
                getValueInAccumulator(currentInstruction + argument)
            }
        }
        return accumulator
    }

    fun fixAndGetValueInAccumulator(): Int {
        var instructionsCopy = instructions.toMutableList()
        val indexToInvestigate = instructions
            .mapIndexed { index, it -> Pair(index, it) }
            .filter { it.second.contains("nop") || it.second.contains("jmp") }
            .toMutableList()
        indexToInvestigate.add(Pair(0, "nop"))

        for (index in indexToInvestigate) {
            usedIndexes.clear()
            accumulator = 0
            val success = runInstructions(instructionsCopy, 0)
            if (success) {
                return accumulator
            } else {
                instructionsCopy = instructions.toMutableList()
                val operationAtIndex = instructionsCopy[index.first]
                val split = operationAtIndex.split(" ")
                if (split[0] == "nop") {
                    instructionsCopy[index.first] = "jmp ${split[1]}"
                } else {
                    instructionsCopy[index.first] = "nop ${split[1]}"
                }
            }
        }
        return accumulator
    }

    private fun runInstructions(instructionsCopy: MutableList<String>, currentInstruction: Int): Boolean {
        var success = false
        if (currentInstruction == instructions.size) {
            return true
        }
        val firstTime = usedIndexes.add(currentInstruction)
        if (!firstTime) {
            return false
        }

        val split = instructionsCopy[currentInstruction].split(" ")
        val operation = split[0]
        val argument = split[1].toInt()

        when (operation) {
            "nop" -> {
                success = runInstructions(instructionsCopy, currentInstruction + 1)
            }
            "acc" -> {
                accumulator += argument
                success = runInstructions(instructionsCopy, currentInstruction + 1)
            }
            "jmp" -> {
                success = runInstructions(instructionsCopy, currentInstruction + argument)
            }
        }

        return success
    }
}