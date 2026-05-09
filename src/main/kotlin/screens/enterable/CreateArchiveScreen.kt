package screens.enterable

import input.ConsoleInput
import interfaces.Enterable
import utils.StringPatterns
import java.io.File

class CreateArchiveScreen(val rootDirectory: File) : Enterable {

    override fun showItems(): List<String> {
        val items = StringPatterns.createArchiveMenu
        println(StringPatterns.CREATE_ARCHIVE_TITLE)
        for ((index, i) in items.withIndex()) {
            println("$index. $i")
        }
        return items
    }

    override fun editAction(): Boolean {
        print(StringPatterns.CREATE_ARCHIVE)
        val title = ConsoleInput.getStringAnswer()
        while (title.isEmpty()) return editAction()
        return createArchive(title)
    }

    fun createArchive(title: String): Boolean {
        val newArchive = File(rootDirectory, title)
        if (newArchive.mkdir()) {
            println(StringPatterns.SUCCESSFUL_CREATING)
            return true
        } else {
            println(StringPatterns.UNSUCCESSFUL_CREATING)
            return false
        }
    }
}