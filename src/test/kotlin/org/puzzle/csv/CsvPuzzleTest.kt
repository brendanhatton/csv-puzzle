package org.puzzle.csv

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CsvPuzzleTest {

    val parser = CsvPuzzle()

    @Test
    internal fun testSimpleCase() {
        val result = parser.parseCSV("first,second,third\n1,2,3")
        assertEquals(
            listOf(
                listOf("first", "second", "third"),
                listOf("1", "2", "3")
            ),
            result
        )
    }

    @Test
    internal fun testQuotedItem() {
        val result = parser.parseCSV("foo bar,\"Hello, world!\",bar")
        assertEquals(
            listOf(
                listOf("foo bar", "Hello, world!", "bar"),
            ),
            result
        )
    }


    @Test
    internal fun testTwoQuotedItems() {
        val result = parser.parseCSV("foo bar,\"Hello, world!\",\"and, again, barry\",bar")
        assertEquals(
            listOf(
                listOf("foo bar", "Hello, world!", "and, again, barry", "bar"),
            ),
            result
        )
    }

    @Test
    internal fun testQuotedItemAtEnd() {
        val result = parser.parseCSV("foo bar,\"Hello, world!\",\"and, again, barry\"")
        assertEquals(
            listOf(
                listOf("foo bar", "Hello, world!", "and, again, barry"),
            ),
            result
        )
    }

    @Test
    internal fun testQuotedItemsAtStartAndEnd() {
        val result = parser.parseCSV("\"foo, bar\",1 2 3,\"and, again, barry\"")
        assertEquals(
            listOf(
                listOf("foo, bar", "1 2 3", "and, again, barry"),
            ),
            result
        )
    }
    @Test
    internal fun testAllQuotedItems() {
        val result = parser.parseCSV("\"foo, bar\",\"Hello, world!\",\"and, again, barry\"")
        assertEquals(
            listOf(
                listOf("foo, bar", "Hello, world!", "and, again, barry"),
            ),
            result
        )
    }

}