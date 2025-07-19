package se.tp21.karabiner.larks

import sh.kau.karabiner.*
import sh.kau.karabiner.ModifierKeyCode.*

fun larksNoQuit(): ComplexModifications =
    ComplexModifications(
        title = "larks no quit",
        rules = listOf(
            karabinerRule(
                description = "left click (q+left_command to left click)",
                manipulators = listOf(
                    Manipulator(
                        from = From(KeyCode.Q, modifiers = FromModifiers(mandatory = listOf(LeftCommand))),
                        to = listOf(
                            To(pointingButton = "button1")
                        )
                    )
                ).toTypedArray()
            ),
            karabinerRule(
                description = "quit (q+left_command+left_shift q+left_command)",
                manipulators = listOf(
                    Manipulator(
                        from = From(KeyCode.Q, modifiers = FromModifiers(mandatory = listOf(LeftCommand, LeftShift))),
                        to = listOf(
                            To(keyCode = KeyCode.Q, modifiers = listOf(LeftCommand))
                        )
                    )
                ).toTypedArray()
            ),
            karabinerRule(
                description = "quit (f4+left_option q+left_command)",
                manipulators = listOf(
                    Manipulator(
                        from = From(KeyCode.F4, modifiers = FromModifiers(mandatory = listOf(LeftOption))),
                        to = listOf(
                            To(keyCode = KeyCode.Q, modifiers = listOf(LeftCommand))
                        )
                    )
                ).toTypedArray()
            ),
            karabinerRule(
                description = "middle click (v+fn to middle click)",
                manipulators = listOf(
                    Manipulator(
                        from = From(KeyCode.V, modifiers = FromModifiers(mandatory = listOf(Fn))),
                        to = listOf(
                            To(pointingButton = "button3")
                        )
                    )
                ).toTypedArray()
            )
        )
    )