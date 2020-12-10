package se.johannesdahlgren.adventofcode2020

import java.io.File
const val BLANK_LINE_PATTERN = "^\\s*\$"

fun readFileToLongList(fileName: String): List<Long> =
    File(ClassLoader.getSystemResource(fileName).file)
        .useLines { it.map { s -> s.toLong() }.toList() }

fun readFileToIntList(fileName: String): List<Int> =
    File(ClassLoader.getSystemResource(fileName).file)
        .useLines { it.map { s -> s.toInt() }.toList() }

fun readFileToStringList(fileName: String): List<String> =
    File(ClassLoader.getSystemResource(fileName).file)
        .useLines { it.toList() }

fun readFileTo2DArray(fileName: String): List<List<Char>> =
    File(ClassLoader.getSystemResource(fileName).file)
        .readLines()
        .map { it.toList() }

fun readFileToString(fileName: String): String =
    File(ClassLoader.getSystemResource(fileName).file)
        .readText()

fun readFileToStringListSplitEmptyLine(fileName: String) :List<String> =
    readFileToString(fileName).split(Regex(BLANK_LINE_PATTERN, RegexOption.MULTILINE))