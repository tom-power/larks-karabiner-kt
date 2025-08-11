package se.tp21.larkskarabiner

import sh.kau.karabiner.json
import java.io.File

fun main() {
    larksMap.forEach { (key, modifications) ->
        try {
            val outputFile = File("build/larks_$key.json")
            val karabinerJson = json().encodeToString(modifications)
            outputFile.writeText(karabinerJson)
            println("Successfully wrote larks_$key.json to ${outputFile.absolutePath}")
        } catch (e: Exception) {
            System.err.println("Error writing karabiner.json: ${e.message}")
            e.printStackTrace()
        }
    }

}
