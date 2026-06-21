package se.tp21.larks.karabiner.modifications

import sh.kau.karabiner.*
import sh.kau.karabiner.ModifierKeyCode.*

fun larksCommand(): ComplexModifications =
    ComplexModifications(
        title = "larks command",
        description = "command extras",
        rules = listOf(
            karabinerRule {
                description = "Escape (left_command+space to escape)"
                mapping {
                    fromKey = KeyCode.Spacebar
                    fromModifiers = FromModifiers(mandatory = listOf(LeftCommand), optional = listOf(Any))
                    toKey = KeyCode.Escape
                }
            },
            karabinerRule {
                description = "Spotlight (left_command+return to left_command+spacebar)"
                mapping {
                    fromKey = KeyCode.ReturnOrEnter
                    fromModifiers = FromModifiers(mandatory = listOf(LeftCommand))
                    toKey = KeyCode.Spacebar
                    toModifiers = listOf(LeftCommand)
                }
            },
        )
    )
