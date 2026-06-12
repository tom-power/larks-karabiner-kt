package se.tp21.larks.karabiner.modifications

import sh.kau.karabiner.KeyCode

typealias KeyMapping = Pair<KeyCode, KeyCode>

fun <T, R> List<T>.product(other: List<R>): List<Pair<T, R>> =
    flatMap { keycode ->
        other.map { keycode to it }
    }
