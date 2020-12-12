package se.johannesdahlgren.adventofcode2020

class Day12 {

    fun getPositionFromStart(input: List<String>): Pair<Int, Int> {
        var currentPos = Pair(0, 0)
        var currentDirection = EAST

        for (navigationInstruction in input) {
            val action = navigationInstruction[0]
            val value = navigationInstruction.substring(1).toInt()
            when (action) {
                FORWARD -> {
                    currentPos = move(currentPos, currentDirection, value)
                }
                RIGHT -> {
                    currentDirection = rotate(currentDirection, RIGHT, value)
                }
                LEFT -> {
                    currentDirection = rotate(currentDirection, LEFT, value)
                }
                else -> {
                    currentPos = move(currentPos, action, value)
                }
            }
        }
        return currentPos
    }

    private fun rotate(currentDirection: Char, rotateDirection: Char, value: Int): Char {
        var newDirection = currentDirection
        for(step in 1..value/90) {
            newDirection = rotate90Degrees(newDirection, rotateDirection)
        }
        return newDirection
    }

    private fun rotate90Degrees(currentDirection: Char, rotateDirection: Char): Char {
        if(rotateDirection == LEFT) {
            when (currentDirection) {
                EAST -> {
                    return NORTH
                }
                WEST -> {
                    return SOUTH
                }
                NORTH -> {
                    return WEST
                }
                SOUTH -> {
                    return EAST
                }
            }
        } else {
            when (currentDirection) {
                EAST -> {
                    return SOUTH
                }
                WEST -> {
                    return NORTH
                }
                NORTH -> {
                    return EAST
                }
                SOUTH -> {
                    return WEST
                }
            }
        }
        throw Throwable("Unknown rotation")
    }

    private fun move(currentPos: Pair<Int, Int>, currentDirection: Char, value: Int): Pair<Int, Int> {
        var newX = currentPos.first
        var newY = currentPos.second
        when (currentDirection) {
            EAST -> {
                newX += value
            }
            WEST -> {
                newX -= value
            }
            NORTH -> {
                newY += value
            }
            SOUTH -> {
                newY -= value
            }
        }
        return Pair(newX, newY)
    }
}