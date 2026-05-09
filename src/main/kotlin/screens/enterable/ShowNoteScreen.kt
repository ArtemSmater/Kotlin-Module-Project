package screens.enterable

import interfaces.Enterable
import utils.StringPatterns
import java.io.File

class ShowNoteScreen(val note: File) : Enterable {
    override fun editAction(): Boolean {
        return true
    }

    override fun showItems(): List<String> {
        val list = listOf(
            "${StringPatterns.SHOW_NOTE_1}${note.name}\n${StringPatterns.SHOW_NOTE_2}${note.readText()}\n${StringPatterns.SHOW_NOTE_3}",
        )
        println("${StringPatterns.NOTE_DETAILS}\n${list[0]}")
        return list
    }
}