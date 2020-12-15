package se.johannesdahlgren.adventofcode2020

class Day13 {
    fun getBusIdAndTimeToNextDeparture(notes: List<String>): Pair<Int, Int> {
        val estimatedTime = notes[0].toInt()
        val activeBusLines = notes[1].split(",").filter { it.toIntOrNull() != null }.map { it.toInt() }

        var busIdAndTimeToWait = Pair(0, Int.MAX_VALUE)
        for (activeLine in activeBusLines) {
            val lineDepartureTimestamp = 0..estimatedTime + activeLine step activeLine
            val earliestDepartureOnLine = lineDepartureTimestamp.filter { it > estimatedTime }.minOrNull()!!

            val minutesToWait = earliestDepartureOnLine - estimatedTime
            if (busIdAndTimeToWait.second > minutesToWait) {
                busIdAndTimeToWait = Pair(activeLine, minutesToWait)
            }
        }

        return busIdAndTimeToWait
    }
}