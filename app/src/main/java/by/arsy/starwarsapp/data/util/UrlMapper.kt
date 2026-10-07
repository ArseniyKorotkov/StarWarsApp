package by.arsy.starwarsapp.data.util

fun String.parseUslToId(): Int =
    this.dropLast(n = 1)
        .takeLastWhile(predicate = Char::isDigit)
        .toInt()