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
                        currentSeat == EMPTY_SEAT && occupiedAdjacentSeats(seatMap, rowIndex, colIndex) == 0 -> {
                            nextSeatMap[rowIndex][colIndex] = OCCUPIED_SEAT
                            seatsChanged++
                        }
                        currentSeat == OCCUPIED_SEAT && occupiedAdjacentSeats(seatMap, rowIndex, colIndex) >= 4 -> {
                            nextSeatMap[rowIndex][colIndex] = EMPTY_SEAT
                            seatsChanged++
                        }
                    }
                }
//                println()
            }
            seatMap = nextSeatMap
//            println()
        }
        return seatMap.flatten().count { it == OCCUPIED_SEAT }
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
                    seatMap[adjacentRow][adjacentCol] == OCCUPIED_SEAT
                ) {
                    occupiedAdjacentSeats++
                }
            }
        }
        return occupiedAdjacentSeats
    }

    fun getOccupiedVisibleSeatsWhenStable(input: List<List<Char>>): Int {
        var seatMap = input.toList()
        var seatsChanged = -1

        while (seatsChanged != 0) {
            seatsChanged = 0
            val nextSeatMap = seatMap.map { it.toMutableList() }.toList()
            for (rowIndex in seatMap.indices) {
                for (colIndex in seatMap[rowIndex].indices) {
                    val currentSeat = seatMap[rowIndex][colIndex]
//                    print(currentSeat)
                    val occupiedVisibleSeats = occupiedVisibleSeats(seatMap, rowIndex, colIndex)
                    when {
                        currentSeat == EMPTY_SEAT && occupiedVisibleSeats == 0 -> {
                            nextSeatMap[rowIndex][colIndex] = OCCUPIED_SEAT
                            seatsChanged++
                        }
                        currentSeat == OCCUPIED_SEAT && occupiedVisibleSeats >= 5 -> {
                            nextSeatMap[rowIndex][colIndex] = EMPTY_SEAT
                            seatsChanged++
                        }
                    }
                }
//                println()
            }
            seatMap = nextSeatMap
//            println()
        }
        return seatMap.flatten().count { it == OCCUPIED_SEAT }
    }

    private fun occupiedVisibleSeats(seatMap: List<List<Char>>, currentRow: Int, currentCol: Int): Int {
        var occupiedVisibleSeats = 0
        occupiedVisibleSeats += getOccupiedVisibleSeatsInDirection(-1, -1, currentRow, currentCol, seatMap)
        occupiedVisibleSeats += getOccupiedVisibleSeatsInDirection(-1, 0, currentRow, currentCol, seatMap)
        occupiedVisibleSeats += getOccupiedVisibleSeatsInDirection(-1, 1, currentRow, currentCol, seatMap)
        occupiedVisibleSeats += getOccupiedVisibleSeatsInDirection(0, -1, currentRow, currentCol, seatMap)
        occupiedVisibleSeats += getOccupiedVisibleSeatsInDirection(0, 1, currentRow, currentCol, seatMap)
        occupiedVisibleSeats += getOccupiedVisibleSeatsInDirection(1, -1, currentRow, currentCol, seatMap)
        occupiedVisibleSeats += getOccupiedVisibleSeatsInDirection(1, 0, currentRow, currentCol, seatMap)
        occupiedVisibleSeats += getOccupiedVisibleSeatsInDirection(1, 1, currentRow, currentCol, seatMap)
        return occupiedVisibleSeats
    }

    private fun getOccupiedVisibleSeatsInDirection(
        rowDirection: Int,
        colDirection: Int,
        currentRow: Int,
        currentCol: Int,
        seatMap: List<List<Char>>
    ): Int {
        var nextRow = currentRow + rowDirection
        var nextCol = currentCol + colDirection
        while (nextRow in seatMap.indices && nextCol in seatMap[currentRow].indices ) {
            if(seatMap[nextRow][nextCol] == EMPTY_SEAT) {
                return 0
            } else if(seatMap[nextRow][nextCol] == OCCUPIED_SEAT) {
                return 1
            }
            nextRow += rowDirection
            nextCol += colDirection
        }
        return 0
    }


}