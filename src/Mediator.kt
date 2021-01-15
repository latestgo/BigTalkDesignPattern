package mediator

abstract class Mediator {
    abstract fun send(message: String, colleague: Colleague)
}

abstract class Colleague(protected val mediator: Mediator) {
}

class ConcreteMediator: Mediator() {
    private lateinit var colleagueA: ConcreteColleagueA
    private lateinit var colleagueB: ConcreteColleagueB

    fun setColleagueA(colleagueA: ConcreteColleagueA) {
        this.colleagueA = colleagueA
    }

    fun setColleagueB(colleagueB: ConcreteColleagueB) {
        this.colleagueB = colleagueB
    }

    override fun send(message: String, colleague: Colleague) {
        if (colleague == colleagueA) {
            colleagueB.notify_(message)
        } else {
            colleagueA.notify_(message)
        }
    }
}

class ConcreteColleagueA(mediator: Mediator): Colleague(mediator) {
    fun send(message: String) {
        mediator.send(message, this)
    }

    fun notify_(message: String) {
        println("同事 1 得到消息 $message")
    }
}

class ConcreteColleagueB(mediator: Mediator): Colleague(mediator) {
    fun send(message: String) {
        mediator.send(message, this)
    }

    fun notify_(message: String) {
        println("同事 2 得到消息 $message")
    }
}

fun main() {
    val m = ConcreteMediator()

    val c1 = ConcreteColleagueA(m)
    val c2 = ConcreteColleagueB(m)

    m.setColleagueA(c1)
    m.setColleagueB(c2)

    c1.send("吃饭")
    c2.send("你请客")
}