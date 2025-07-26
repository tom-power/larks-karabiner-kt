package se.tp21.karabiner

import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import sh.kau.karabiner.ComplexModifications
import sh.kau.karabiner.json
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LarksTest {

    private val larks: Map<String, ComplexModifications> = larks()

    @ParameterizedTest
    @MethodSource("larksKeys")
    fun `snippets rules are correct`(key: String) {

        assertEquals(
            expected = javaClass.getResource("/larks_$key.json")!!.readText().trimAll(),
            actual = json().encodeToString(larks[key]!!).trimAll(),
        )
    }

    @Suppress("unused")
    private fun larksKeys() =
        listOf(
            "macToPc",
            "navigation",
            "noQuit",
            "terminal",
            "wrap",
        )

}

private fun String.trimAll() = trimStart().trimEnd().trimIndent()
