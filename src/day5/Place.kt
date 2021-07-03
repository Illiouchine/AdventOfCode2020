package day5

import kotlin.math.ceil

class Place(
        private val stringIdentifier: String
) {
    private val linesRange = IntRange(0, 127)
    private val columnsRange = IntRange(0, 7)

    private fun row(): Int {
        var range: IntRange = linesRange
        stringIdentifier
                .filter { it == 'F' || it == 'B' }
                .forEach {
                    range = splitRange(it, range)
                }
        if (range.first != range.last) {
            throw Exception("Can't find the row.")
        }
        return range.first
    }

    private fun splitRange(char: Char, range: IntRange): IntRange {
        var minLine = range.first
        var maxLine = range.last
        when (char) {
            'F' -> maxLine = ((maxLine - minLine) / 2) + minLine
            'B' -> minLine = (ceil((maxLine - minLine).toDouble() / 2).toInt() + minLine)
            'R' -> minLine = (ceil((maxLine - minLine).toDouble() / 2).toInt() + minLine)
            'L' -> maxLine = ((maxLine - minLine) / 2) + minLine
            else -> {
                throw Exception("Wrong character splitter")
            } /* Do nothing */
        }
        return IntRange(minLine, maxLine)
    }

    // 0..7 columns
    private fun columns(): Int {
        var range = columnsRange
        stringIdentifier
                .filter { it == 'R' || it == 'L' }
                .forEach {
                    range = splitRange(it, range)
                }
        if (range.first != range.last) {
            throw Exception("Can't find the column.")
        }
        return range.first
    }

    fun seatId(): Int {
        return (row() * 8 + columns())
    }

}