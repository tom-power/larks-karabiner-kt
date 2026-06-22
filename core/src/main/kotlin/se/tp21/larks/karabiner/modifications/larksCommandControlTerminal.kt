package se.tp21.larks.karabiner.modifications

import sh.kau.karabiner.*
import sh.kau.karabiner.ModifierKeyCode.*

fun larksCommandControlTerminal(): ComplexModifications =
    ComplexModifications(
        title = "larks command control",
        description = "command to control, for the terminal",
        rules = rules()
    )

private fun rules(): List<KarabinerRule> =
    leftCommandToControl() +
        rightCommandToControl()

private fun leftCommandToControl(): List<KarabinerRule> =
    leftCommandKeyMappings().map {
        it.toCommandToControlRule(LeftCommand)
    }


private fun leftCommandKeyMappings(): List<KeyMapping> = leftTerminalKeys

private fun rightCommandToControl(): List<KarabinerRule> =
    rightCommandKeyMappings().map {
        it.toCommandToControlRule(RightCommand)
    }

private fun rightCommandKeyMappings(): List<KeyMapping> =
    leftTerminalKeys +
        rightTerminalKeys +
        microKeys

private val leftTerminalKeys: List<KeyMapping> =
    listOf(
        KeyCode.B to KeyCode.W,
    ) + (
        listOf(
            KeyCode.U,
            KeyCode.L,
            KeyCode.K,
        ).map { it to it })


private val rightTerminalKeys: List<KeyMapping> =
    listOf(
        KeyCode.O,
        KeyCode.P,
    ).map { it to it }

private val microKeys: List<KeyMapping> =
    listOf(
        KeyCode.Slash to KeyCode.Backslash, // stop the beeps
    ) +
        listOf(
        KeyCode.Q,
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
        karabinerRuleSingle {
            this.fromKey = fromKey
            fromModifiers = FromModifiers(mandatory = listOf(commandKey))
            to = listOf(
//                To(toKey, listOf(commandKey)),
                To(toKey, listOf(LeftControl)),
            )
            forApp {
                bundleIds = hasTerminalIds
            }
            this.description = description()
        }
    }
}

private val hasTerminalIds =
    listOf(
        "^com\\.jetbrains.*",
        "^com\\.microsoft\\.VSCode.*",
        "^com\\.googlecode\\.iterm2$",
        "^com\\.cmuxterm\\.app$",
        "^dev\\.zed\\.Zed$"
    )

