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
                RIGHT, LEFT -> {
                    currentDirection = rotate(currentDirection, action, value)
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
        for (step in 1..value / 90) {
            newDirection = rotate90Degrees(newDirection, rotateDirection)
        }
        return newDirection
    }

    private fun rotate90Degrees(currentDirection: Char, rotateDirection: Char): Char {
        if (rotateDirection == LEFT) {
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

    fun getPositionFromStartWithWaypoint(input: List<String>, wayPoint: Pair<Int, Int>): Pair<Int, Int> {
        var currentPos = Pair(0, 0)
        var currentWaypoint = wayPoint

        for (navigationInstruction in input) {
            val action = navigationInstruction[0]
            val value = navigationInstruction.substring(1).toInt()
            when (action) {
                FORWARD -> {
                    currentPos = moveToWaypoint(currentPos, currentWaypoint, value)
                }
                LEFT, RIGHT -> {
                    currentWaypoint = rotateWaypoint(currentWaypoint, action, value)
                }
                else -> {
                    currentWaypoint = move(currentWaypoint, action, value)
                }
            }
        }
        return currentPos
    }

    private fun rotateWaypoint(currentWaypoint: Pair<Int, Int>, direction: Char, value: Int): Pair<Int, Int> {
        var newWaypoint = currentWaypoint
        for (step in 1..value / 90) {
            newWaypoint = rotateWayPoint90Degrees(newWaypoint, direction)
        }
        return newWaypoint
    }

    private fun rotateWayPoint90Degrees(newWaypoint: Pair<Int, Int>, direction: Char): Pair<Int, Int> {
        if (direction == LEFT) {
            if (newWaypoint.first >= 0 && newWaypoint.second >= 0) {
                return Pair(newWaypoint.second * -1, newWaypoint.first)
            } else if (newWaypoint.first >= 0 && newWaypoint.second <= 0) {
                return Pair(newWaypoint.second * -1, newWaypoint.first)
            } else if (newWaypoint.first <= 0 && newWaypoint.second <= 0) {
                return Pair(newWaypoint.second * -1, newWaypoint.first)
            } else if (newWaypoint.first <= 0 && newWaypoint.second >= 0) {
                return Pair(newWaypoint.second * -1, newWaypoint.first)
            }
        } else {
            if (newWaypoint.first >= 0 && newWaypoint.second >= 0) {
                return Pair(newWaypoint.second, newWaypoint.first * -1)
            } else if (newWaypoint.first >= 0 && newWaypoint.second <= 0) {
                return Pair(newWaypoint.second, newWaypoint.first * -1)
            } else if (newWaypoint.first <= 0 && newWaypoint.second <= 0) {
                return Pair(newWaypoint.second, newWaypoint.first * -1)
            } else if (newWaypoint.first <= 0 && newWaypoint.second >= 0) {
                return Pair(newWaypoint.second, newWaypoint.first * -1)
            }
        }
        throw Throwable("Unknown rotation")
    }

    private fun moveToWaypoint(
        currentPos: Pair<Int, Int>,
        currentWaypoint: Pair<Int, Int>,
        value: Int
    ): Pair<Int, Int> {
        val newX = currentPos.first + value * currentWaypoint.first
        val newY = currentPos.second + value * currentWaypoint.second
        return Pair(newX, newY)
    }
}