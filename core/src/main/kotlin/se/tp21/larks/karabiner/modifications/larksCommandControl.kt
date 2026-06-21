package se.tp21.larks.karabiner.modifications

import sh.kau.karabiner.*
import sh.kau.karabiner.ModifierKeyCode.*

fun larksCommandControl(): ComplexModifications =
    ComplexModifications(
        title = "larks command control",
        description = "command to control, for the terminal",
        rules = rules()
    )

private fun rules(): List<KarabinerRule> =
    leftCommandToControl() + rightCommandToControl()

private fun leftCommandToControl(): List<KarabinerRule> =
    leftCommandKeyMappings().map {
        it.toCommandToControlRule(LeftCommand)
    }

private fun leftCommandKeyMappings(): List<KeyMapping> =
    listOf(
        KeyCode.B to KeyCode.W,
    ) + listOf(
        KeyCode.U,
        KeyCode.L,
        KeyCode.K,
    ).map { it to it }

private fun rightCommandToControl(): List<KarabinerRule> =
    rightCommandKeyMappings().map {
        it.toCommandToControlRule(RightCommand)
    }

private fun rightCommandKeyMappings(): List<KeyMapping> =
    listOf(
        KeyCode.Q,
        KeyCode.E,
        KeyCode.R,
        KeyCode.A,
        KeyCode.S,
        KeyCode.D,
        KeyCode.Z,
        KeyCode.X,
        KeyCode.C,
        KeyCode.V,
    ).map { it to it }

private fun KeyMapping.toCommandToControlRule(commandKey: ModifierKeyCode): KarabinerRule {
    check(commandKey in listOf(LeftCommand, RightCommand))

    return this.let { (fromKey, toKey) ->
        karabinerRuleSimple {
            this.fromKey = fromKey
            fromModifier = commandKey
            this.toKey = toKey
            toModifier = LeftControl
        }
    }
}


