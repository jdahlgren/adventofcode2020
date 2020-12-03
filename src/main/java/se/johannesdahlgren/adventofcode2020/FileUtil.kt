package se.johannesdahlgren.adventofcode2020

import java.io.File

fun readFileToLongList(fileName: String): List<Long> =
    File(ClassLoader.getSystemResource(fileName).file)
        .useLines { it.map { s -> s.toLong() }.toList() }

fun readFileToStringList(fileName: String): List<String> =
    File(ClassLoader.getSystemResource(fileName).file)
        .useLines { it.toList() }

fun readFileTo2DArray(fileName: String): List<List<Char>> =
    File(ClassLoader.getSystemResource(fileName).file)
        .readLines()
        .map { it.toList() }