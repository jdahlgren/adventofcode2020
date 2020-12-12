package se.johannesdahlgren.adventofcode2020

class Day11 {
    fun getOccupiedSeatsWhenStable(input: List<List<Char>>): Int {
        var seatMap = input.toList()
        var seatsChanged = -1

        while (seatsChanged != 0) {
            seatsChanged = 0
            val nextSeatMap = seatMap.map { it.toMutableList() }.toList()
            for (rowIndex in seatMap.indices) {
                for (colIndex in seatMap[rowIndex].indices) {
                    val currentSeat = seatMap[rowIndex][colIndex]
//                    print(currentSeat)
                    when {
                        currentSeat == 'L' && occupiedAdjacentSeats(seatMap, rowIndex, colIndex) == 0 -> {
                            nextSeatMap[rowIndex][colIndex] = '#'
                            seatsChanged++
                        }
                        currentSeat == '#' && occupiedAdjacentSeats(seatMap, rowIndex, colIndex) >= 4 -> {
                            nextSeatMap[rowIndex][colIndex] = 'L'
                            seatsChanged++
                        }
                    }
                }
//                println()
            }
            seatMap = nextSeatMap
//            println()
        }
        return seatMap.flatten().count { it == '#' }
    }

    private fun occupiedAdjacentSeats(seatMap: List<List<Char>>, currentRow: Int, currentCol: Int): Int {
        var occupiedAdjacentSeats = 0
        for (i in -1..1) {
            for (j in -1..1) {
                val adjacentRow = currentRow + i
                val adjacentCol = currentCol + j
                val currentSeat = adjacentRow == currentRow && adjacentCol == currentCol
                if (!currentSeat &&
                    adjacentRow in seatMap.indices &&
                    adjacentCol in seatMap[currentRow].indices &&
                    seatMap[adjacentRow][adjacentCol] == '#'
                ) {
                    occupiedAdjacentSeats++
                }
            }
        }
        return occupiedAdjacentSeats
    }

}