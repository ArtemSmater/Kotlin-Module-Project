package interfaces

interface Selectable : Showable, Removable {
    fun selectItem(path: String) : Selectable
    fun createItem() : Enterable
    fun cancel() : Selectable
}