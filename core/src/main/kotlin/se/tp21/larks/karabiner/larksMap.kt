package se.tp21.larks.karabiner

import se.tp21.larks.karabiner.modifications.*
import sh.kau.karabiner.ComplexModifications

val larksMap: Map<String, ComplexModifications> =
    mapOf(
        "clicking" to larksClicking(),
        "command" to larksCommand(),
        "commandControlTerminal" to larksCommandControlTerminal(),
        "gaming" to larksGaming(),
        "macKeys" to larksMacKeys(),
        "navigation" to larksNavigation(),
        "wrap" to larksWrap(),
    )
