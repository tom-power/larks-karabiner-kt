package se.tp21.larkskarabiner

import se.tp21.larkskarabiner.larks.larksTerminal
import se.tp21.larkskarabiner.larks.larksMacToPc
import se.tp21.larkskarabiner.larks.larksNavigation
import se.tp21.larkskarabiner.larks.larksNoQuit
import se.tp21.larkskarabiner.larks.larksWrap
import sh.kau.karabiner.ComplexModifications

val larksMap: Map<String, ComplexModifications> =
    mapOf(
        "macToPc" to larksMacToPc(),
        "navigation" to larksNavigation(),
        "noQuit" to larksNoQuit(),
        "terminal" to larksTerminal(),
        "wrap" to larksWrap(),
    )
