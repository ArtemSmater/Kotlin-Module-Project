package screens.enterable

import input.ConsoleInput
import interfaces.Enterable
import utils.StringPatterns
import java.io.File

class CreateNoteScreen(val archivePath: File) : Enterable {


    override fun showItems(): List<String> {
        val items = StringPatterns.createNoteMenu
        println(StringPatterns.CREATE_NOTE_TITLE)
        for ((index, i) in items.withIndex()) {
            println("$index. $i")
        }
        return items
    }

    override fun editAction(): Boolean {
        val file = createNote() ?: return false
        fillNote(file)
        return true
    }

    fun fillNote(note: File?) {
        print(StringPatterns.CREATE_NOTE_2)
        val text = ConsoleInput.getStringAnswer()
        while (text.isEmpty()) return fillNote(note)
        note?.writeText(text)
    }

    fun createNote(): File? {
        print(StringPatterns.CREATE_NOTE_1)
        val title = ConsoleInput.getStringAnswer()
        while (title.isEmpty()) return createNote()
        val newNote = File(archivePath, title)
        if (newNote.createNewFile()) {
            return newNote
        } else {
            println(StringPatterns.UNSUCCESSFUL_CREATING)
            return null
        }
    }
}