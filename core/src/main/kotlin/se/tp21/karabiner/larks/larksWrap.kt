package se.tp21.karabiner.larks

import sh.kau.karabiner.*
import sh.kau.karabiner.ModifierKeyCode.*
import kotlin.collections.toTypedArray

fun larksWrap(): ComplexModifications =
    ComplexModifications(
        title = "larks wrap",
        rules = listOf(
            wrapRule(
                description = "wrap with \" (left_shift+right_shift+2 to clipboard wrapped with \")",
                fromKeyCode = KeyCode.Num2,
                toOpen = To(keyCode = KeyCode.Quote, modifiers = listOf(LeftShift)),
                toClose = To(keyCode = KeyCode.Quote, modifiers = listOf(LeftShift)),

            ),
            wrapRule(
                description = "wrap with () (left_shift+right_shift+9 to clipboard wrapped with ())",
                fromKeyCode = KeyCode.Num9,
                toOpen = To(keyCode = KeyCode.Num9, modifiers = listOf(LeftShift)),
                toClose = To(keyCode = KeyCode.Num0, modifiers = listOf(LeftShift)),
            ),
            wrapRule(
                description = "wrap with ` (left_shift+right_shift+` to clipboard wrapped with `)",
                fromKeyCode = KeyCode.GraveAccentAndTilde,
                toOpen = To(keyCode = KeyCode.GraveAccentAndTilde, modifiers = listOf(LeftShift)),
                toClose = To(keyCode = KeyCode.GraveAccentAndTilde, modifiers = listOf(LeftShift)),
            ),
        )
    )

private fun wrapRule(
    description: String,
    fromKeyCode: KeyCode,
    toOpen: To,
    toClose: To,
) =
    karabinerRule(
        description = description,
        manipulators = listOf(
            Manipulator(
                from = From(fromKeyCode, modifiers = FromModifiers(mandatory = listOf(LeftShift, RightShift))),
                to = listOf(
                    To(keyCode = KeyCode.X, modifiers = listOf(LeftCommand)),
                    To(shellCommand = "pbpaste | pbcopy -pboard ruler"),
                    toOpen,
                    To(shellCommand = "pbpaste -pboard ruler"),
                    To(keyCode = KeyCode.V, modifiers = listOf(LeftCommand)),
                    toClose
                )
            )
        ).toTypedArray()
    )