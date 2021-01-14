package memento

class Originator {
    lateinit var state: String

    fun createMemento(): Memento {
        return Memento(state)
    }

    fun setMemento(memento: Memento) {
        state = memento.getState()
    }

    fun show() {
        println("State=$state")
    }
}

class Memento(private val state: String) {
    fun getState(): String {
        return state
    }
}

class Caretaker {
    lateinit var memento: Memento
}

fun main() {
    val o = Originator()
    o.state = "On"
    o.show()

    val c = Caretaker()
    c.memento = o.createMemento()

    o.state= "Off"
    o.show()

    o.setMemento(c.memento)
    o.show()
}