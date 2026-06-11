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
    leftCommandKeyMappings().map { keyMapping ->
        toCommandToControlRuleOn(
            keyMapping = keyMapping,
            commandKey = LeftCommand
        )
    }

typealias KeyMapping = Pair<KeyCode, KeyCode>

private fun leftCommandKeyMappings(): List<KeyMapping> =
    listOf(
        KeyCode.B to KeyCode.W,
        KeyCode.U to KeyCode.U,
        KeyCode.L to KeyCode.L,
        KeyCode.K to KeyCode.K,
    )

private fun toCommandToControlRuleOn(
    keyMapping: KeyMapping,
    commandKey: ModifierKeyCode
): KarabinerRule {
    val (from, to) = keyMapping
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

