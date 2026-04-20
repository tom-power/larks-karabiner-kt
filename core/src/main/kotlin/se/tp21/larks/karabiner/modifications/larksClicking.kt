package se.tp21.larks.karabiner.modifications

import sh.kau.karabiner.*
import sh.kau.karabiner.ModifierKeyCode.*

fun larksClicking(): ComplexModifications =
    ComplexModifications(
        title = "larks clicking",
        rules = listOf(
            karabinerRule {
                description = "left click (q+left_command to left click)"
                mapping {
                    from = From(KeyCode.Q, modifiers = FromModifiers(mandatory = listOf(LeftCommand)))
                    to = listOf(
                        To(pointingButton = "button1")
                    )
                }
            },
            karabinerRule {
                description = "middle click (v+fn to middle click)"
                mapping {
                    from = From(KeyCode.V, modifiers = FromModifiers(mandatory = listOf(Fn)))
                    to = listOf(
                        To(pointingButton = "button3")
                    )
                }
            }
        )
    )