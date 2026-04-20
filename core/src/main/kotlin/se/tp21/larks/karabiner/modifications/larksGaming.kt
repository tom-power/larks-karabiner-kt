package se.tp21.larks.karabiner.modifications

import sh.kau.karabiner.*
import sh.kau.karabiner.ModifierKeyCode.*

fun larksGaming(): ComplexModifications =
    ComplexModifications(
        title = "larks gaming",
        rules = listOf(
            karabinerRule {
                description = "left control (left_command+moonlight)"
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
        )
    )
