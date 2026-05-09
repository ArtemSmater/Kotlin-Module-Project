package screens.selectable

import interfaces.Enterable
import interfaces.Selectable
import screens.enterable.CreateArchiveScreen
import utils.StringPatterns
import java.io.File
import kotlin.system.exitProcess

class StartScreen : Selectable {

    override fun showItems(): List<String> {
        val files = mutableListOf<String>()
        files.addAll(StringPatterns.mainMenu)
        files.addAll(
            1,
            getRootDirectory().listFiles()?.filter { it.isDirectory }?.map { file -> file.name }
                ?.toList()
                ?: listOf())

        println(StringPatterns.ARCHIVES_MENU)
        for ((index, i) in files.withIndex()) {
            println("$index. $i")
        }
        return files
    }

    override fun createItem(): Enterable {
        return CreateArchiveScreen(getRootDirectory())
    }

    override fun selectItem(path: String): Selectable {
        return ArchiveScreen(File(getRootDirectory(), path))
    }

    override fun cancel(): Selectable {
        exitProcess(1)
    }

    fun getRootDirectory(): File {
        val rootDirectory = File(StringPatterns.ROOT_DIR)
        if (!rootDirectory.exists()) {
            rootDirectory.mkdir()
        }
        return rootDirectory
    }

    override fun canRemove(): Boolean {
        return false
    }

    override fun removeItem() : Selectable {
        return this
    }
}