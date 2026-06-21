package se.tp21.larks.karabiner.modifications

import sh.kau.karabiner.KeyCode

typealias KeyMapping = Pair<KeyCode, KeyCode>

fun <T, R> List<T>.product(values: List<R>): List<Pair<T, R>> =
    flatMap { key ->
        values.map { value ->
            key to value
        }
    }
