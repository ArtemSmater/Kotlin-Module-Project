package screens.selectable

import interfaces.Enterable
import interfaces.Removable
import interfaces.Selectable
import screens.enterable.CreateNoteScreen
import utils.StringPatterns
import java.io.File

class ArchiveScreen(val file: File) : Selectable, Removable {

    override fun showItems(): List<String> {
        val files = mutableListOf<String>()
        files.addAll(StringPatterns.noteMenu)
        files.addAll(
            1,
            file.listFiles()?.filter { it.isFile }?.map { file -> file.name }
                ?.toList()
                ?: listOf())

        println(StringPatterns.NOTES_MENU)
        for ((index, i) in files.withIndex()) {
            println("$index. $i")
        }
        return files
    }

    override fun selectItem(path: String): Selectable {
        return NoteScreen(File(file, path), file)
    }

    override fun createItem(): Enterable {
        return CreateNoteScreen(file)
    }

    override fun cancel(): Selectable {
        return StartScreen()
    }

    override fun canRemove(): Boolean {
        return true
    }

    override fun removeItem(): Selectable {
        if (file.delete()) {
            println("${file.name} was deleted!")
            return cancel()
        } else {
            println("Archive ${file.name} has to be empty!")
            return this
        }
    }
}