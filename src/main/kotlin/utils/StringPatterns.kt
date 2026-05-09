package utils

class StringPatterns {

    companion object {

        // select menu titles
        const val ARCHIVES_MENU = "Archives list: "
        const val NOTES_MENU = "Notes list: "
        const val NOTE_MENU = "Note menu: "
        const val NOTE_DETAILS = "Note info: "

        // enter menu titles
        const val CREATE_ARCHIVE_TITLE = "Create archive menu: "
        const val CREATE_NOTE_TITLE = "Create note menu: "

        // select menu items
        val mainMenu = listOf("Create archive", "Exit")
        val noteMenu = listOf("Create note", "Remove archive", "Back")
        val checkNote = listOf("See note", "Remove note", "Back")

        // enter menu items
        val createArchiveMenu = listOf("Enter archive title", "Back")
        val createNoteMenu = listOf("Start creating", "Back")

        // create items
        const val CREATE_ARCHIVE = "Enter archive title: "
        const val CREATE_NOTE_1 = "Enter note title: "
        const val CREATE_NOTE_2 = "Enter note text: "

        // show note menu
        const val SHOW_NOTE_1 = "Note title: "
        const val SHOW_NOTE_2 = "Note text: "
        const val SHOW_NOTE_3 = "0. Back"

        // print errors
        const val TYPE_ERROR = "Wrong answer type!"
        const val RANGE_ERROR = "Answer is out of bounds!"

        const val EMPTY_ERROR = "Title can`t be empty!"
        const val SUCCESSFUL_CREATING = "Archive created!"
        const val UNSUCCESSFUL_CREATING = "Document already exists..."

        // paths
        const val ROOT_DIR = "rootDirectory/"
    }
}