package se.tp21.karabiner

import se.tp21.karabiner.larks.larksCommandControl
import se.tp21.karabiner.larks.larksMacToPc
import se.tp21.karabiner.larks.larksNavigation
import se.tp21.karabiner.larks.larksNoQuit
import se.tp21.karabiner.larks.larksWrap
import sh.kau.karabiner.ComplexModifications

fun larks(): Map<String, ComplexModifications> =
    mapOf(
        "commandControl" to larksCommandControl(),
        "macToPc" to larksMacToPc(),
        "navigation" to larksNavigation(),
        "noQuit" to larksNoQuit(),
        "wrap" to larksWrap(),
    )
