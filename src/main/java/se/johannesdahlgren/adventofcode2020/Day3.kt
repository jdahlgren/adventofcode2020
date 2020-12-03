package se.johannesdahlgren.adventofcode2020

private const val TREE = '#'
private const val STEP_DOWN = 3

class Day3(fileName: String) {
    private var trees = 0

    private val map = readFileTo2DArray(fileName)

    fun countTrees(): Int {
        var col = 0
        for (row in map) {
            if (row[col] == TREE) {
                trees++
            }
            col += STEP_DOWN
            if (col > row.size - 1) {
                col = 0 + col % row.size
            }
        }
        return trees
    }
}

