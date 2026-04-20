package se.tp21.larks.karabiner

import se.tp21.larks.karabiner.modifications.*
import sh.kau.karabiner.ComplexModifications

val larksMap: Map<String, ComplexModifications> =
    mapOf(
        "macToPc" to larksMacToPc(),
        "navigation" to larksNavigation(),
        "clicking" to larksClicking(),
        "terminal" to larksTerminal(),
        "wrap" to larksWrap(),
        "gaming" to larksGaming()
    )
