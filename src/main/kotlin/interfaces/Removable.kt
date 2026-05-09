package interfaces

interface Removable {
    fun canRemove() : Boolean
    fun removeItem() : Selectable
}