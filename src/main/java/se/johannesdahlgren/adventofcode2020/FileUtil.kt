package se.johannesdahlgren.adventofcode2020

import java.io.File

fun readFileToLongList(fileName: String): List<Long> =
    File(ClassLoader.getSystemResource(fileName).file)
        .useLines { it.map { s -> s.toLong() }.toList() }