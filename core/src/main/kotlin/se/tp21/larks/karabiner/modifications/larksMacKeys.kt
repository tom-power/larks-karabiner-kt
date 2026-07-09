package se.tp21.larks.karabiner.modifications

import sh.kau.karabiner.*
import sh.kau.karabiner.KeyCode.*
import sh.kau.karabiner.ModifierKeyCode.LeftControl

fun larksMacKeys() =
    ComplexModifications(
        title = "larks mac keys",
        rules = macKeys()
    )

private fun fromMacKeysNum() = listOf(Num1, Num2, Num0, Hyphen, EqualSign)
private fun fromMacKeysFn() = listOf(F1, F2, F10, F11, F12)
private fun toMacKeys() =
    listOf(
        DisplayBrightnessDecrement,
        DisplayBrightnessIncrement,
        Mute,
        VolumeDecrement,
        VolumeIncrement
    )

private fun macKeys(): List<KarabinerRule> {
    val macKeysNum = fromMacKeysNum().zip(toMacKeys())
    val macKeysFn = fromMacKeysFn().zip(toMacKeys())
    return (macKeysNum + macKeysFn).map { (fromKeyCode, toKeyCode) ->
        karabinerRuleSingle {
            this.fromKey = fromKeyCode
            fromModifiers = FromModifiers(mandatory = listOf(LeftControl))
            this.toKey = toKeyCode
            this.description = description()
        }
    }
}