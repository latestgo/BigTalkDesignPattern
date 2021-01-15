package command

abstract class Command(protected val receiver: Receiver) {
    abstract fun execute()
}

class ConcreteCommand(receiver: Receiver): Command(receiver) {
    override fun execute() {
        receiver.action()
    }
}

class Receiver {
    fun action() {
        println("执行请求")
    }
}

class Invoker {
    private lateinit var command: Command

    fun setCommand(command: Command) {
        this.command = command
    }

    fun executeCommand() {
        command.execute()
    }
}

fun main() {
    val r = Receiver()
    val c = ConcreteCommand(r)
    val i = Invoker()
    i.setCommand(c)
    i.executeCommand()
}