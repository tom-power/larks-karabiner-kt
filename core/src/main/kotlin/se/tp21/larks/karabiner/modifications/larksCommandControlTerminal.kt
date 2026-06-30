package se.tp21.larks.karabiner.modifications

import sh.kau.karabiner.*
import sh.kau.karabiner.ModifierKeyCode.*
import kotlin.collections.listOf

fun larksCommandControlTerminal(): ComplexModifications =
    ComplexModifications(
        title = "larks command control",
        description = "command to control, for the terminal",
        rules = rules()
    )

private fun rules(): List<KarabinerRule> =
    leftCommandToControl() + // capslock bound to this through SimpleModification
        rightCommandToControl()

private fun leftCommandToControl(): List<KarabinerRule> =
    leftCommandKeyMappings().map {
        it.toCommandToControlRule(
            commandKey = LeftCommand,
            forIds = hasTerminalIds
        )
    }

private fun rightCommandToControl(): List<KarabinerRule> =
    rightCommandKeyMappings().map {
        it.toCommandToControlRule(
            commandKey = RightCommand,
            forIds = null
        )
    }

private fun leftCommandKeyMappings(): List<KeyMapping> =
    leftCommandTerminalKeys +
        capslockMicroKeys

private fun rightCommandKeyMappings(): List<KeyMapping> =
    rightCommandControlKeys

private val leftCommandTerminalKeys: List<KeyMapping> =
    listOf(
        KeyCode.B to KeyCode.W // backward-kill-word
    ) +
        listOf(
            KeyCode.U, // backward-kill-line
            KeyCode.K, // kill-line
            KeyCode.L, // clear
        ).map { it to it }

private val capslockMicroKeys: List<KeyMapping> =
    listOf(
        KeyCode.Slash to KeyCode.Backslash, // comment line, no beeps
    ) +
        listOf(
            KeyCode.A, // select all
            KeyCode.S, // save
            KeyCode.D, // duplicate line
        ).map { it to it }

private val rightCommandControlKeys: List<KeyMapping> = allLettersKeyCodes().map { it to it }

private fun allLettersKeyCodes(): List<KeyCode> =
    ('A'..'Z').toList()
        .map { it.toString() }
        .mapNotNull { it.toKeycode() }

private fun KeyMapping.toCommandToControlRule(
    commandKey: ModifierKeyCode,
    forIds: List<String>?,
): KarabinerRule {
    check(commandKey in listOf(LeftCommand, RightCommand))

    return this.let { (fromKey, toKey) ->
        karabinerRuleSingle {
            this.fromKey = fromKey
            fromModifiers = FromModifiers(mandatory = listOf(commandKey))
            to = listOf(
//                To(toKey, listOf(commandKey)),
                To(toKey, listOf(LeftControl)),
            )
            forIds?.let {
                forApp {
                    bundleIds = it
                }
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