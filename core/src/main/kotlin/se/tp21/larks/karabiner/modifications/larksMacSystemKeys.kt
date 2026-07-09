package se.tp21.larks.karabiner.modifications

import sh.kau.karabiner.*
import sh.kau.karabiner.KeyCode.*
import sh.kau.karabiner.ModifierKeyCode.LeftControl

fun larksMacSystemKeys() =
    ComplexModifications(
        title = "larks mac system keys",
        rules = macKeys()
    )

private fun fromKeysNum() = listOf(Num1, Num2, Num0, Hyphen, EqualSign)
private fun fromKeysFn() = listOf(F1, F2, F10, F11, F12)
private fun toMacSystemKeys() =
    listOf(
        DisplayBrightnessDecrement,
        DisplayBrightnessIncrement,
        Mute,
        VolumeDecrement,
        VolumeIncrement
    )

private fun macKeys(): List<KarabinerRule> {
    val macSystemKeysNum = fromKeysNum().zip(toMacSystemKeys())
    val macSystemKeysFn = fromKeysFn().zip(toMacSystemKeys())
    return (macSystemKeysNum + macSystemKeysFn).map { (fromKeyCode, toKeyCode) ->
        karabinerRuleSingle {
            this.fromKey = fromKeyCode
            fromModifiers = FromModifiers(mandatory = listOf(LeftControl))
            this.toKey = toKeyCode
            this.description = description()
        }
    }
}