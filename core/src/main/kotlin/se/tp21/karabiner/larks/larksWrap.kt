package se.tp21.karabiner.larks

import sh.kau.karabiner.*
import sh.kau.karabiner.ModifierKeyCode.*

fun larksWrap(): ComplexModifications =
    ComplexModifications(
        title = "larks wrap",
        rules = listOf(
            karabinerRule(
                description = "wrap with \" (left_shift+left_command+quote to clipboard wrapped with \")",
                manipulators = listOf(
                    Manipulator(
                        from = From(KeyCode.Quote, modifiers = FromModifiers(mandatory = listOf(LeftShift, LeftCommand))),
                        to = listOf(
                            To(keyCode = KeyCode.X, modifiers = listOf(LeftCommand)),
                            To(shellCommand = "pbpaste | pbcopy -pboard ruler"),
                            To(keyCode = KeyCode.Quote, modifiers = listOf(LeftShift)),
                            To(shellCommand = "pbpaste -pboard ruler"),
                            To(keyCode = KeyCode.V, modifiers = listOf(LeftCommand)),
                            To(keyCode = KeyCode.Quote, modifiers = listOf(LeftShift))
                        )
                    )
                ).toTypedArray()
            ),
            karabinerRule(
                description = "wrap with \" 2 (left_shift+right_shift+2 to clipboard wrapped with \")",
                manipulators = listOf(
                    Manipulator(
                        from = From(KeyCode.Num2, modifiers = FromModifiers(mandatory = listOf(LeftShift, RightShift))),
                        to = listOf(
                            To(keyCode = KeyCode.X, modifiers = listOf(LeftCommand)),
                            To(shellCommand = "pbpaste | pbcopy -pboard ruler"),
                            To(keyCode = KeyCode.Quote, modifiers = listOf(LeftShift)),
                            To(shellCommand = "pbpaste -pboard ruler"),
                            To(keyCode = KeyCode.V, modifiers = listOf(LeftCommand)),
                            To(keyCode = KeyCode.Quote, modifiers = listOf(LeftShift))
                        )
                    )
                ).toTypedArray()
            ),
            karabinerRule(
                description = "wrap with ' (left_command+quote to clipboard wrapped with ')",
                manipulators = listOf(
                    Manipulator(
                        from = From(KeyCode.Quote, modifiers = FromModifiers(mandatory = listOf(LeftCommand))),
                        to = listOf(
                            To(keyCode = KeyCode.X, modifiers = listOf(LeftCommand)),
                            To(shellCommand = "pbpaste | pbcopy -pboard ruler"),
                            To(keyCode = KeyCode.Quote),
                            To(shellCommand = "pbpaste -pboard ruler"),
                            To(keyCode = KeyCode.V, modifiers = listOf(LeftCommand)),
                            To(keyCode = KeyCode.Quote)
                        )
                    )
                ).toTypedArray()
            )
        )
    )