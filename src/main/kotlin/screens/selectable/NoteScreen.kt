package screens.selectable

import interfaces.Enterable
import interfaces.Removable
import interfaces.Selectable
import screens.enterable.ShowNoteScreen
import utils.StringPatterns
import java.io.File

class NoteScreen(val note: File, val parent: File) : Selectable, Removable {

    override fun selectItem(path: String): Selectable {
        return this
    }

    override fun createItem(): Enterable {
        return ShowNoteScreen(note)
    }

    override fun cancel(): Selectable {
        return ArchiveScreen(parent)
    }

    override fun showItems(): List<String> {
        println(StringPatterns.NOTE_MENU)
        val files = StringPatterns.checkNote
        for ((index, i) in files.withIndex()) {
            println("$index. $i")
        }
        return files
    }

    override fun canRemove(): Boolean {
        return true
    }

    override fun removeItem() : Selectable {
        if (note.delete()) {
            println("${note.name} was deleted!")
            return cancel()
        } else {
            println("Unable to delete ${note.name}!")
            return this
        }
    }
}