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
            description = "\" (left_shift + 2)"
            mapping {
                fromKey = KeyCode.Num2
                fromModifiers = FromModifiers(mandatory = listOf(LeftShift))
                toKey = KeyCode.Quote
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
        karabinerRule {
            description = "# (right_shift + 3)"
            mapping {
                fromKey = KeyCode.Num3
                fromModifiers = FromModifiers(mandatory = listOf(RightShift))
                toKey = KeyCode.Num3
                toModifiers = listOf(LeftOption)
            }
        },
        karabinerRule(
            description = "~/ (right_shift + §)",
            manipulators = listOf(
                Manipulator(
                    from = From(KeyCode.NonUsBackslash, modifiers = FromModifiers(mandatory = listOf(RightShift))),
                    to = listOf(
                        To(
                            keyCode = KeyCode.GraveAccentAndTilde,
                            modifiers = listOf(LeftShift)
                        ),
                        To(
                            keyCode = KeyCode.Slash
                        )
                    )
                )
            ).toTypedArray()
        )
    )