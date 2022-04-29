package org.puzzle.csv

class CsvPuzzle {
    fun parseCSV(input: String): List<List<String>> {
        val lines = input.split("\n")
        val result = lines.map { line ->
            val segmentsSplitByQuotes = line.split("\"")
            val parsedLine = segmentsSplitByQuotes.flatMapIndexed { index, segment ->
                if (index % 2 == 1) {
                    //return quoted blob as ia
                    listOf(segment)
                } else {
                    //oustide of quoted blob so split commas
                    segment.split(",")
                }
            }
            parsedLine.filter { it.isNotBlank() } //handle blank entries from trailing commas
        }
        return result
    }
}