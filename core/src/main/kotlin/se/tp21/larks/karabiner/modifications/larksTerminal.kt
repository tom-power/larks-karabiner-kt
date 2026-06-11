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

typealias KeyMapping = Pair<KeyCode, KeyCode>

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

private fun KeyMapping.toCommandToControlRuleOn(commandKey: ModifierKeyCode): KarabinerRule {
    val (from, to) = this
    return karabinerRule {
        val commandKeyName = commandKey.name.camelToSnakeCase().lowercase()
        val toName = to.name.lowercase()
        val fromName = from.name.lowercase()
        description =
            "Control $toName ($commandKeyName+$fromName to right_control+$toName)"
        mapping {
            fromKey = from
            fromModifiers = FromModifiers(mandatory = listOf(commandKey))
            toKey = to
            toModifiers = listOf(LeftControl)
        }
    }
}

private fun String.camelToSnakeCase(): String {
    val pattern = "(?<=.)[A-Z]".toRegex()
    return this.replace(pattern, "_$0").lowercase()
}

