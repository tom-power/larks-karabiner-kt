package se.tp21.karabiner

import se.tp21.karabiner.larks.larksTerminal
import se.tp21.karabiner.larks.larksMacToPc
import se.tp21.karabiner.larks.larksNavigation
import se.tp21.karabiner.larks.larksNoQuit
import se.tp21.karabiner.larks.larksWrap
import sh.kau.karabiner.ComplexModifications

val larksMap: Map<String, ComplexModifications> =
    mapOf(
        "macToPc" to larksMacToPc(),
        "navigation" to larksNavigation(),
        "noQuit" to larksNoQuit(),
        "terminal" to larksTerminal(),
        "wrap" to larksWrap(),
    )
