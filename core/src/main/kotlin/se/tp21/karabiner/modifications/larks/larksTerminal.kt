package se.tp21.karabiner.modifications.larks

import sh.kau.karabiner.*
import sh.kau.karabiner.ModifierKeyCode.*

fun larksTerminal(): ComplexModifications =
    ComplexModifications(
        title = "larks terminal",
        description = "for the terminal",
        rules = rules()
    )

private fun rules() =
    listOf(
        karabinerRule {
            description = "Control b (left_command+b to right_control+b)"
            mapping {
                fromKey = KeyCode.B
                fromModifiers = FromModifiers(mandatory = listOf(LeftCommand))
                toKey = KeyCode.B
                toModifiers = listOf(RightControl)
            }
        },
        karabinerRule {
            description = "Control u (left_command+u to right_control+u)"
            mapping {
                fromKey = KeyCode.U
                fromModifiers = FromModifiers(mandatory = listOf(LeftCommand))
                toKey = KeyCode.U
                toModifiers = listOf(RightControl)
            }
        },
        karabinerRule {
            description = "Control l (left_command+l to right_control+l)"
            mapping {
                fromKey = KeyCode.L
                fromModifiers = FromModifiers(mandatory = listOf(LeftCommand))
                toKey = KeyCode.L
                toModifiers = listOf(RightControl)
            }
        }
    )
