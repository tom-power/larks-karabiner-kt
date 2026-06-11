package se.tp21.larks.karabiner.modifications

import sh.kau.karabiner.*
import sh.kau.karabiner.ModifierKeyCode.*

fun larksTerminalSimple(): List<SimpleModification> =
    listOf(
        SimpleModification(
            from =
                SimpleModificationKey(
                    keyCode = RightCommand,
                ),
            to =
                listOf(
                    SimpleModificationValue(
                        keyCode = LeftControl,
                    )
                )
        )
    )

fun larksTerminal(): ComplexModifications =
    ComplexModifications(
        title = "larks terminal",
        description = "for the terminal",
        rules = rules()
    )

private fun rules(): List<KarabinerRule> =
    (keyCodesDifferent() + keyCodesSame())
        .map { (from, to) ->
            commandToControlRule(from, to)
        }

private fun commandToControlRule(from: KeyCode, to: KeyCode): KarabinerRule =
    karabinerRule {
        description =
            "Control ${to.name.lowercase()} (left_command+${from.name.lowercase()} to right_control+${to.name.lowercase()})"
        mapping {
            fromKey = from
            fromModifiers = FromModifiers(mandatory = listOf(LeftCommand))
            toKey = to
            toModifiers = listOf(RightControl)
        }
    }

typealias KeyMapping = Pair<KeyCode, KeyCode>

private fun keyCodesDifferent(): List<KeyMapping> =
    listOf(
        KeyCode.B to KeyCode.W
    )

private fun keyCodesSame(): List<KeyMapping> =
    listOf(
        KeyCode.U,
        KeyCode.L,
        KeyCode.K,
    )
        .map { it to it }


