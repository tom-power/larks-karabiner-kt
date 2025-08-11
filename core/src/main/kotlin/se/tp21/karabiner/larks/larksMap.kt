package se.tp21.karabiner.larks

import se.tp21.karabiner.larks.larks.larksTerminal
import se.tp21.karabiner.larks.larks.larksMacToPc
import se.tp21.karabiner.larks.larks.larksNavigation
import se.tp21.karabiner.larks.larks.larksNoQuit
import se.tp21.karabiner.larks.larks.larksWrap
import sh.kau.karabiner.ComplexModifications

val larksMap: Map<String, ComplexModifications> =
    mapOf(
        "macToPc" to larksMacToPc(),
        "navigation" to larksNavigation(),
        "noQuit" to larksNoQuit(),
        "terminal" to larksTerminal(),
        "wrap" to larksWrap(),
    )
