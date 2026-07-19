package se.tp21.larks.karabiner.modifications

import sh.kau.karabiner.KeyCode

fun <T, R> List<T>.product(values: List<R>): List<Pair<T, R>> =
    flatMap { key ->
        values.map { value ->
            key to value
        }
    }

internal fun String.toKeycode(): KeyCode? = keyCodes.singleOrNull { this == it.name }
private val keyCodes: List<KeyCode> = KeyCode::class.sealedSubclasses.mapNotNull { it.objectInstance }

internal data class KeyCodeMap(
    val from: KeyCode,
    val to: KeyCode,
)

internal fun KeyCode.toKeyCodeMap(): KeyCodeMap =
    KeyCodeMap(
        to = this,
        from = this
    )