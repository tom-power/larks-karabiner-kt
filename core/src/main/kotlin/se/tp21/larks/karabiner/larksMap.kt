package se.tp21.larks.karabiner

import se.tp21.larks.karabiner.modifications.larksTerminal
import se.tp21.larks.karabiner.modifications.larksMacToPc
import se.tp21.larks.karabiner.modifications.larksNavigation
import se.tp21.larks.karabiner.modifications.larksNoQuit
import se.tp21.larks.karabiner.modifications.larksWrap
import sh.kau.karabiner.ComplexModifications

val larksMap: Map<String, ComplexModifications> =
    mapOf(
        "macToPc" to larksMacToPc(),
        "navigation" to larksNavigation(),
        "noQuit" to larksNoQuit(),
        "terminal" to larksTerminal(),
        "wrap" to larksWrap(),
    )
