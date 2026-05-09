import input.ConsoleInput
import interfaces.Enterable
import interfaces.Selectable
import screens.selectable.StartScreen

var currentScreen: Selectable = StartScreen()

fun main() {
    while (true) {
        selectableActions(currentScreen)
    }
}

fun selectableActions(screen: Selectable) {
    val items = screen.showItems()
    val exit = items.size - 1
    if (screen.canRemove()) {
        val remove = items.size - 2
        when (val answer = ConsoleInput.getNumberAnswer(items.size)) {
            0 -> enterableActions(screen.createItem())
            -1 -> return
            remove -> currentScreen = screen.removeItem()
            exit -> currentScreen = screen.cancel()
            else -> currentScreen = screen.selectItem(items[answer])
        }
    } else {
        when (val answer = ConsoleInput.getNumberAnswer(items.size)) {
            0 -> enterableActions(screen.createItem())
            -1 -> return
            exit -> currentScreen = screen.cancel()
            else -> currentScreen = screen.selectItem(items[answer])
        }
    }
}

fun enterableActions(editScreen: Enterable) {
    val items = editScreen.showItems()
    val answer = ConsoleInput.getNumberAnswer(items.size)
    if (answer == -1) return enterableActions(editScreen)
    if (answer == 0) {
        if (!editScreen.editAction()) {
            return enterableActions(editScreen)
        }
    }
}