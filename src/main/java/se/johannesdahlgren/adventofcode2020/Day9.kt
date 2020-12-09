package se.johannesdahlgren.adventofcode2020

class Day9(private val input: List<Int>) {
    fun findFirstInvalidNumber(preamble: Int): Int {
        for (index in preamble until input.size) {
            if (!getSums(index, preamble).contains(input[index])) {
                return input[index]
            }
        }
        return -1
    }

    private fun getSums(index: Int, preamble: Int): MutableList<Int> {
        val subList = input.subList(index - preamble, index)
        val sums = mutableListOf<Int>()
        for (i in subList) {
            for (j in subList) {
                sums.add(i + j)
            }
        }
        return sums
    }

    fun findEncryptionWeakness(preamble: Int): Int {
        val invalidNumber = findFirstInvalidNumber(preamble)
        for (i in 0..input.size) {
            var sum = 0
            val indices = mutableListOf<Int>()
            for (j in i .. input.size) {
                sum += input[j]
                indices.add(j)
                if(sum > invalidNumber) {
                    break
                } else if (sum == invalidNumber) {
                    val contiguousIndices = input.filterIndexed { index, _ -> indices.contains(index) }
                    return contiguousIndices.minOrNull()!! + contiguousIndices.maxOrNull()!!
                }
            }
        }
        return -1
    }
}