package se.johannesdahlgren.adventofcode2020

private const val TREE = '#'

class Day3(fileName: String) {

    private val map = readFileTo2DArray(fileName)

    fun countTrees(stepRight: Int, stepDown: Int): Int {
        var trees = 0
        var col = 0
        for (x in map.indices step stepDown) {
            val row = map[x]
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
}

