package se.johannesdahlgren.adventofcode2020

private const val TREE = '#'

class Day3(fileName: String) {

    private val map = readFileTo2DArray(fileName)

    fun countTrees(stepRight: Int, stepDown: Int): Long {
        var trees: Long = 0
        var col = 0
        for (y in map.indices step stepDown) {
            val row = map[y]
            if (row[col] == TREE) {
                trees++
            }
            col += stepRight
            if (col > row.size - 1) {
                col = 0 + col % row.size
            }
        }
        return trees
    }

    fun countTreesInAllSlopes(): Long {
        val first = countTrees(1, 1)
        val second = countTrees(3, 1)
        val third = countTrees(5, 1)
        val fourth = countTrees(7, 1)
        val fifth = countTrees(1, 2)
        return first * second * third * fourth * fifth
    }
}

