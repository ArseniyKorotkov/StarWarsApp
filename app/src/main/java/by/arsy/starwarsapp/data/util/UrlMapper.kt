package by.arsy.starwarsapp.data.util

fun String.parseUslToId(): Int =
    this.dropLastWhile(predicate = { !it.isDigit() })
        .takeLastWhile(predicate = Char::isDigit)
        .toInt()