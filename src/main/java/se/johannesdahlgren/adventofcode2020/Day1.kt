package se.johannesdahlgren.adventofcode2020

class Day1(fileName: String) {

    private val input: List<Long> = readFileToLongList(fileName)

    fun fixExpenseReport(sum: Long): Long {
        val factors = findSum(input, sum)
        return factors.stream().reduce(Long::times).get()
    }

    fun fixExpenseReportThree(sum: Long): Long {
        val factors = findSumThree(input, sum)
        return factors.stream().reduce(Long::times).get()
    }

    private fun findSum(input: List<Long>, sum: Long): List<Long> {
        for (i in input) {
            for (j in input) {
                if (i + j == sum) {
                    return listOf(i, j)
                }
            }
        }
        throw Exception("Input does not contain items that sum to $sum")
    }

    private fun findSumThree(input: List<Long>, sum: Long): List<Long> {
        for (i in input) {
            for (j in input) {
                for (k in input) {
                    if (i + j + k == sum) {
                        return listOf(i, j, k)
                    }
                }
            }
        }
        throw Exception("Input does not contain items that sum to $sum")
    }

}