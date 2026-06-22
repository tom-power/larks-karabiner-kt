package se.tp21.larks.karabiner.modifications

import sh.kau.karabiner.*
import sh.kau.karabiner.KeyCode
import sh.kau.karabiner.ModifierKeyCode.*

fun larksNavigation(): ComplexModifications =
    ComplexModifications(
        title = "larks navigation",
        rules = pageUps() + pageDowns()
    )

private fun pageUps() =
    listOf(
        KeyCode.DeleteOrBackspace,
        KeyCode.UpArrow
    )
        .product(modifiers())
        .pageRulesFor(KeyCode.PageUp)

private fun pageDowns() =
    listOf(
        KeyCode.ReturnOrEnter,
        KeyCode.DownArrow,
    )
        .product(modifiers())
        .pageRulesFor(KeyCode.PageDown)

private fun modifiers(): List<ModifierKeyCode> = listOf(LeftControl, Fn)

private fun List<Pair<KeyCode, ModifierKeyCode>>.pageRulesFor(toKey: KeyCode): List<KarabinerRule> {
    check(toKey in listOf(KeyCode.PageUp, KeyCode.PageDown))

    return this.map { (fromKey, fromModifierKey) ->
        karabinerRuleSingle {
            this.fromKey = fromKey
            this.fromModifiers = FromModifiers(mandatory = listOf(fromModifierKey))
            this.toKey = toKey
            this.description = description()
        }
    }
}


