package se.tp21.larks.karabiner.modifications

import sh.kau.karabiner.*
import sh.kau.karabiner.KeyCode.*

fun larksMacKeys() =
    ComplexModifications(
        title = "larks mac keys",
        rules = rules()
    )

private fun rules(): List<KarabinerRule> = macKeysFnCommand()

private fun macKeysFnCommand(): List<KarabinerRule> = listOf(
    karabinerRule {
        description = "brightness decrement (left_control + 1)"
        mapping {
            fromKey = Num1
            fromModifiers = FromModifiers(
                mandatory =
                    listOf(ModifierKeyCode.LeftControl)
            )
            toKey = DisplayBrightnessDecrement
        }
    },
    karabinerRule {
        description = "brightness increment (left_control + 2)"
        mapping {
            fromKey = Num2
            fromModifiers = FromModifiers(
                mandatory =
                    listOf(ModifierKeyCode.LeftControl)
            )
            toKey = DisplayBrightnessIncrement
        }
    },
    karabinerRule {
        description = "mission control (left_control + 3)"
        mapping {
            fromKey = Num3
            fromModifiers = FromModifiers(
                mandatory =
                    listOf(ModifierKeyCode.LeftControl)
            )
            toKey = MissionControl
        }
    },
    karabinerRule {
        description = "mute (left_control + 0)"
        mapping {
            fromKey = Num0
            fromModifiers = FromModifiers(
                mandatory =
                    listOf(ModifierKeyCode.LeftControl)
            )
            toKey = Mute
        }
    },
    karabinerRule {
        description = "volume decrement (left_control + hyphen)"
        mapping {
            fromKey = Hyphen
            fromModifiers = FromModifiers(
                mandatory =
                    listOf(ModifierKeyCode.LeftControl)
            )
            toKey = VolumeDecrement
        }
    },
    karabinerRule {
        description = "volume increment (left_control + equals)"
        mapping {
            fromKey = EqualSign
            fromModifiers = FromModifiers(
                mandatory =
                    listOf(ModifierKeyCode.LeftControl)
            )
            toKey = VolumeIncrement
        }
    }
)