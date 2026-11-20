package se.tp21.larks.karabiner.modifications

import sh.kau.karabiner.*
import sh.kau.karabiner.ModifierKeyCode.*
import kotlin.collections.listOf

fun larksCommandControlTerminal(): ComplexModifications =
    ComplexModifications(
        title = "larks command control terminal",
        rules = rules()
    )

private fun rules(): List<KarabinerRule> = leftCommandToControl() // capslock bound to this through SimpleModification

private fun leftCommandToControl(): List<KarabinerRule> =
    leftCommandKeyCodeMaps().map { keyCodeMap ->
        commandToControlRuleFor(
            keyCodeMap = keyCodeMap,
            commandKey = LeftCommand,
            forIds = terminalIds
        )
    }

private fun leftCommandKeyCodeMaps(): List<KeyCodeMap> =
    leftCommandTerminalKeys +
            capslockMicroKeys

private val leftCommandTerminalKeys: List<KeyCodeMap> =
    listOf(
        KeyCodeMap(from = KeyCode.B, to = KeyCode.W) // backward-kill-word
    ) +
            listOf(
                KeyCode.U, // backward-kill-line
                KeyCode.K, // kill-line
                KeyCode.L, // clear
            ).map { it.toKeyCodeMap() }

private val capslockMicroKeys: List<KeyCodeMap> =
    listOf(
        KeyCodeMap(from = KeyCode.Slash, to = KeyCode.Backslash), // comment line, no beeps
    ) +
            listOf(
                KeyCode.A, // select all
                KeyCode.S, // save
                KeyCode.D, // duplicate line
                KeyCode.Z, // undo
            ).map { it.toKeyCodeMap() }

@Suppress("SameParameterValue")
private fun commandToControlRuleFor(
    keyCodeMap: KeyCodeMap,
    commandKey: ModifierKeyCode,
    forIds: List<String>,
): KarabinerRule {
    check(commandKey in listOf(LeftCommand, RightCommand))

    return keyCodeMap.let { (fromKey, toKey) ->
        karabinerRuleSingle {
            this.fromKey = fromKey
            fromModifiers = FromModifiers(mandatory = listOf(commandKey))
            to = listOf(
//                To(toKey, listOf(commandKey)),
                To(toKey, listOf(LeftControl)),
            )
            forApp {
                bundleIds = forIds
            }
            description = description()
        }
    }
}

private val terminalIds =
    listOf(
        "^com\\.jetbrains.*",
        "^com\\.microsoft\\.VSCode.*",
        "^com\\.googlecode\\.iterm2$",
        "^com\\.cmuxterm\\.app$",
        "^dev\\.zed\\.Zed$"
    )