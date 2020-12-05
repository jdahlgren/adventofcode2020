package se.johannesdahlgren.adventofcode2020

class Day5() {

    fun findSeatId(boardingPass: String): Int {
        val rowParts = boardingPass.toCharArray().take(7)

        var correctRow = (0..127).toList()
        for (rowPart in rowParts) {
            correctRow = if(rowPart == 'F'){
                correctRow.take(correctRow.count()/2)
            } else {
                correctRow.takeLast(correctRow.count()/2)
            }
        }

        val colParts = boardingPass.toCharArray().takeLast(3)
        var correctColumn = (0..7).toList()
        for (colPart in colParts) {
            correctColumn = if(colPart == 'L'){
                correctColumn.take(correctColumn.count()/2)
            } else {
                correctColumn.takeLast(correctColumn.count()/2)
            }
        }

        return correctRow[0] * 8 +  correctColumn[0]
    }

    fun highestSeatId(boardingPasses: List<String>) : Int {
        return boardingPasses.maxOf { findSeatId(it) }
    }
}