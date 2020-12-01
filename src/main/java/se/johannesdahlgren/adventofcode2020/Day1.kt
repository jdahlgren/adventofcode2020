package se.johannesdahlgren.adventofcode2020

class Day1(fileName: String) {

    private val input: List<Long> = readFileToLongList(fileName)

    fun fixExpenseReport(sum: Long): Long {
        for (i in input) {
            for (j in input) {
                if (i + j == sum) {
                    return i * j
                }
            }
        }
        throw Exception("Input does not contain items that sum to $sum")
    }

    fun fixExpenseReportThree(sum: Long): Long {
        for (i in input) {
            for (j in input) {
                for (k in input) {
                    if (i + j + k == sum) {
                        return i * j * k
                    }
                }
            }
        }
        throw Exception("Input does not contain items that sum to $sum")
    }
}