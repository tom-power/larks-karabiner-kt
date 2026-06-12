package se.tp21.larks.karabiner.modifications

import sh.kau.karabiner.*
import sh.kau.karabiner.ModifierKeyCode.*

fun larksTerminal(): ComplexModifications =
    ComplexModifications(
        title = "larks terminal",
        description = "for the terminal",
        rules = rules()
    )

private fun rules(): List<KarabinerRule> =
    leftCommandToControl() + rightCommandToControl()

private fun leftCommandToControl(): List<KarabinerRule> =
    leftCommandKeyMappings().map {
        it.toCommandToControlRuleOn(LeftCommand)
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
        it.toCommandToControlRuleOn(RightCommand)
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

private fun KeyMapping.toCommandToControlRuleOn(commandKey: ModifierKeyCode): KarabinerRule =
    this.let { (fromKey, toKey) ->
        karabinerRuleSimple {
            this.fromKey = fromKey
            fromModifier = commandKey
            this.toKey = toKey
            toModifier = LeftControl
        }
    }


