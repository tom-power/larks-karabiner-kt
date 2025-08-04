package se.tp21.karabiner.larks

import sh.kau.karabiner.*
import sh.kau.karabiner.ModifierKeyCode.*

fun larksWrap(): ComplexModifications =
    ComplexModifications(
        title = "larks wrap",
        rules = listOf(
            wrapRule {
                ruleDescription = "wrap with \" (left_shift+right_shift+2 to clipboard wrapped with \")"
                fromKeyCode = KeyCode.Num2
                toOpen = To(keyCode = KeyCode.Quote, modifiers = listOf(LeftShift))
                toClose = To(keyCode = KeyCode.Quote, modifiers = listOf(LeftShift))
            },
            wrapRule {
                ruleDescription = "wrap with () (left_shift+right_shift+9 to clipboard wrapped with ())"
                fromKeyCode = KeyCode.Num9
                toOpen = To(keyCode = KeyCode.Num9, modifiers = listOf(LeftShift))
                toClose = To(keyCode = KeyCode.Num0, modifiers = listOf(LeftShift))
            },
            wrapRule {
                ruleDescription = "wrap with ` (left_shift+right_shift+` to clipboard wrapped with `)"
                fromKeyCode = KeyCode.GraveAccentAndTilde
                toOpen = To(keyCode = KeyCode.GraveAccentAndTilde)
                toClose = To(keyCode = KeyCode.GraveAccentAndTilde)
            },
        )
    )

data class WrapRule(
    var ruleDescription: String = "",
    var fromKeyCode: KeyCode? = null,
    var toOpen: To = To(),
    var toClose: To = To(),
)

private fun wrapRule(
    block: WrapRule.() -> Unit,
): KarabinerRule {
    val wrapRule = WrapRule().apply(block)
    return karabinerRule {
        description = wrapRule.ruleDescription
        mapping {
            from = From(wrapRule.fromKeyCode, modifiers = FromModifiers(mandatory = listOf(LeftShift, RightShift)))
            to = listOf(
                To(keyCode = KeyCode.X, modifiers = listOf(LeftCommand)),
                To(shellCommand = "pbpaste | pbcopy -pboard ruler"),
                wrapRule.toOpen,
                To(shellCommand = "pbpaste -pboard ruler"),
                To(keyCode = KeyCode.V, modifiers = listOf(LeftCommand)),
                wrapRule.toClose
            )
        }
    }
}