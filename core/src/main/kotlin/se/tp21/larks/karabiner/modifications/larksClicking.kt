package se.tp21.larks.karabiner.modifications

import sh.kau.karabiner.*
import sh.kau.karabiner.ModifierKeyCode.*

fun larksClicking(): ComplexModifications =
    ComplexModifications(
        title = "larks clicking",
        rules = listOf(
            karabinerRule {
                description = "left click (q+right_command to left click)"
                mapping {
                    this.from = From(KeyCode.Q, modifiers = FromModifiers(mandatory = listOf(RightCommand)))
                    this.to = listOf(
                        To(pointingButton = "button1")
                    )
                }
            },
            karabinerRule {
                description = "middle click (v+fn to middle click)"
                mapping {
                    this.from = From(KeyCode.V, modifiers = FromModifiers(mandatory = listOf(Fn)))
                    this.to = listOf(
                        To(pointingButton = "button3")
                    )
                }
            }
        )
    )