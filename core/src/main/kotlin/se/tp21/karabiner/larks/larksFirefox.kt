package se.tp21.karabiner.larks

import sh.kau.karabiner.*
import sh.kau.karabiner.ModifierKeyCode.*
import sun.security.util.SignatureUtil.fromKey

fun larksFirefox(): ComplexModifications =
    ComplexModifications(
        title = "larks firefox",
        rules = listOf(
            karabinerRule {
                description = "left command left click firefox (button1 + left_command)"
                mapping {
                    fromPointingButton = "button1"
                    fromModifiers = FromModifiers(mandatory = listOf(LeftShift))
                    pointingButton = "button1"
                    toModifiers = listOf(LeftCommand)
                    forApp {
                        bundleIds =
                            listOf(
                                "^org\\.mozilla\\.firefox$"
                            )
                    }
                }

            }
        )
    )
