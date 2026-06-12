package se.tp21.larks.karabiner.modifications

import sh.kau.karabiner.*
import sh.kau.karabiner.ModifierKeyCode.*

fun larksMacToPc(): ComplexModifications =
    ComplexModifications(
        title = "larks mac to pc",
        rules = rules()
    )

private fun rules(): List<KarabinerRule> =
    listOf(
        karabinerRuleSimple {
            description = "@ (quote + left_shift)"
            fromKey = KeyCode.Quote
            fromModifier = LeftShift
            toKey = KeyCode.Num2
            toModifier = LeftShift
        },
        karabinerRuleSimple {
            description = "\" (2 + right_shift)"
            fromKey = KeyCode.Num2
            fromModifier = RightShift
            toKey = KeyCode.Quote
            toModifier = LeftShift
        }
    )