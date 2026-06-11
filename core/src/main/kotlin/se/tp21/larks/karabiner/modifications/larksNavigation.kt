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
    ).pageRulesFor(KeyCode.PageUp)

private fun pageDowns() =
    listOf(
        KeyCode.ReturnOrEnter,
        KeyCode.DownArrow,
    ).pageRulesFor(KeyCode.PageDown)

private fun List<KeyCode>.pageRulesFor(to: KeyCode ) =
    this.combineWith(modifiers())
        .map { (from, fromModifier) ->
            pageRule(from, fromModifier, to)
        }

private fun modifiers(): List<ModifierKeyCode> = listOf(LeftControl, Fn)

private fun pageRule(
    from: KeyCode,
    fromModifier: ModifierKeyCode,
    to: KeyCode,
): KarabinerRule {
    check(to in listOf(KeyCode.PageUp, KeyCode.PageDown))

    val fromModifierName = fromModifier.name.camelToSnakeCase()
    val fromName = from.name.camelToSnakeCase()

    return karabinerRule {
        description =
            "${to.name.camelToTitleCaseWithSpace()} ($fromModifierName+$fromName)"
        mapping {
            fromKey = from
            fromModifiers = FromModifiers(mandatory = listOf(fromModifier))
            toKey = to
        }
    }
}