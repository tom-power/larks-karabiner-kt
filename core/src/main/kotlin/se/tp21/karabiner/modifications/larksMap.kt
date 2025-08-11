package se.tp21.karabiner.modifications

import se.tp21.karabiner.modifications.larks.larksTerminal
import se.tp21.karabiner.modifications.larks.larksMacToPc
import se.tp21.karabiner.modifications.larks.larksNavigation
import se.tp21.karabiner.modifications.larks.larksNoQuit
import se.tp21.karabiner.modifications.larks.larksWrap
import sh.kau.karabiner.ComplexModifications

val larksMap: Map<String, ComplexModifications> =
    mapOf(
        "macToPc" to larksMacToPc(),
        "navigation" to larksNavigation(),
        "noQuit" to larksNoQuit(),
        "terminal" to larksTerminal(),
        "wrap" to larksWrap(),
    )
