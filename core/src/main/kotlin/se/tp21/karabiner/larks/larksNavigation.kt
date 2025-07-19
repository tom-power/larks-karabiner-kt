package se.tp21.karabiner.larks

import sh.kau.karabiner.*
import sh.kau.karabiner.ModifierKeyCode.*

fun larksNavigation(): ComplexModifications =
    ComplexModifications(
        title = "larks navigation",
        rules = listOf(
            karabinerRule {
                description = "Page up (left_control+backspace)"
                mapping {
                    fromKey = KeyCode.DeleteOrBackspace
                    fromModifiers = FromModifiers(mandatory = listOf(LeftControl))
                    toKey = KeyCode.PageUp
                }
            },
            karabinerRule {
                description = "Page down (left_control+enter)"
                mapping {
                    fromKey = KeyCode.ReturnOrEnter
                    fromModifiers = FromModifiers(mandatory = listOf(LeftControl))
                    toKey = KeyCode.PageDown
                }
            },
            karabinerRule {
                description = "Page up fn (fn+backspace)"
                mapping {
                    fromKey = KeyCode.DeleteOrBackspace
                    fromModifiers = FromModifiers(mandatory = listOf(Fn))
                    toKey = KeyCode.PageUp
                }
            },
            karabinerRule {
                description = "Page down fn (fn+backspace)"
                mapping {
                    fromKey = KeyCode.ReturnOrEnter
                    fromModifiers = FromModifiers(mandatory = listOf(Fn))
                    toKey = KeyCode.PageDown
                }
            },
            karabinerRule {
                description = "Page up control (left_control+up)"
                mapping {
                    fromKey = KeyCode.UpArrow
                    fromModifiers = FromModifiers(mandatory = listOf(LeftControl))
                    toKey = KeyCode.PageUp
                }
            },
            karabinerRule {
                description = "Page down control (left_control+down)"
                mapping {
                    fromKey = KeyCode.DownArrow
                    fromModifiers = FromModifiers(mandatory = listOf(LeftControl))
                    toKey = KeyCode.PageDown
                }
            }
        )
    )