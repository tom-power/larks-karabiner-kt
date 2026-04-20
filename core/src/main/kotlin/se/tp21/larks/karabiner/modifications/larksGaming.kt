package se.tp21.larks.karabiner.modifications

import sh.kau.karabiner.*
import sh.kau.karabiner.ModifierKeyCode.*

fun larksGaming(): ComplexModifications =
    ComplexModifications(
        title = "larks gaming",
        rules = listOf(
            karabinerRule {
                description = "left control (left_command+moonlight to left control)"
                mapping {
                    fromKey = LeftCommand
                    toKey = LeftControl
                    conditions = mutableListOf(
                        Condition.FrontmostApplicationIfCondition(
                            bundleIds = listOf(
                                "^com\\.moonlight\\-stream\\.Moonlight$"
                            ),
                            filePaths = listOf()
                        )
                    )
                }
            },
            karabinerRule {
                description = "left click (q+left_control+moonlight to left click)"
                mapping {
                    from = From(KeyCode.Q, modifiers = FromModifiers(mandatory = listOf(LeftControl)))
                    to = listOf(
                        To(pointingButton = "button1")
                    )
                    conditions = mutableListOf(
                        Condition.FrontmostApplicationIfCondition(
                            bundleIds = listOf(
                                "^com\\.moonlight\\-stream\\.Moonlight$"
                            ),
                            filePaths = listOf()
                        )
                    )
                }
            },
        )
    )
