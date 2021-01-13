package observer

abstract class Subject {
    private val observers = mutableListOf<Observer>()

    fun attach(observer: Observer) {
        observers.add(observer)
    }

    fun detach(observer: Observer) {
        observers.remove(observer)
    }

    fun notify_() {
        observers.forEach { it.update() }
    }
}

abstract class Observer() {
    abstract fun update()
}

class ConcreteSubject(): Subject() {
    lateinit var subjectState: String
}

class ConcreteObserver(var subject: ConcreteSubject, private val name: String): Observer() {

    override fun update() {
        val observerState = subject.subjectState
        println("观察者 $name 的新状态是 $observerState")
    }
}

fun main() {
    val s = ConcreteSubject()

    s.attach(ConcreteObserver(s, "X"))
    s.attach(ConcreteObserver(s, "Y"))
    s.attach(ConcreteObserver(s, "Z"))

    s.subjectState = "ABC"
    s.notify_()
}