package se.tp21.karabiner

import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import se.tp21.resourcesapproval.ResourcesApproval
import sh.kau.karabiner.ComplexModifications
import sh.kau.karabiner.json

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LarksTest {
    @ParameterizedTest
    @MethodSource("larks")
    fun `snippets rules are correct`(key: String, modifications: ComplexModifications) {
        ResourcesApproval.assertApproved(
            actual = json().encodeToString(modifications),
            approved = "larks_$key.json",
        )
    }

    @Suppress("unused")
    private fun larks() = larksMap.map { Arguments.of(it.key, it.value) }
}

