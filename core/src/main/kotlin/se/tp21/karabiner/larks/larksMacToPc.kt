package se.tp21.karabiner.larks

import sh.kau.karabiner.*
import sh.kau.karabiner.ModifierKeyCode.*

fun larksMacToPc(): ComplexModifications =
    ComplexModifications(
        title = "larks mac to pc",
        rules = rules()
    )

private fun rules() =
    listOf(
        karabinerRule {
            description = "@ (left_shift + ')"
            mapping {
                fromKey = KeyCode.Quote
                fromModifiers = FromModifiers(mandatory = listOf(LeftShift))
                toKey = KeyCode.Num2
                toModifiers = listOf(LeftShift)
            }
        },
        karabinerRule {
            description = "\" (right_shift + 2)"
            mapping {
                fromKey = KeyCode.Num2
                fromModifiers = FromModifiers(mandatory = listOf(RightShift))
                toKey = KeyCode.Quote
                toModifiers = listOf(LeftShift)
            }
        },
    )