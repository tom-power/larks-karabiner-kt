package se.tp21.larks.karabiner.modifications

import sh.kau.karabiner.KeyCode

typealias KeyMapping = Pair<KeyCode, KeyCode>

fun String.camelToSnakeCase(): String {
    val pattern = "(?<=.)[A-Z]".toRegex()
    return this.replace(pattern, "_$0").lowercase()
}

fun String.camelToTitleCaseWithSpace(): String {
    val pattern = "(?<=.)[A-Z]".toRegex()
    return this.replace(pattern, " $0").split(" ").run {
        first() + " " + drop(1).joinToString(" ").lowercase()
    }
}

fun <T, R> List<T>.combineWith(other: List<R>): List<Pair<T, R>> =
    flatMap { keycode ->
        other.map { keycode to it }
    }