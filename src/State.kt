package state

abstract class State {
    abstract fun handle(context: Context)
}

class ConcreteStateA: State() {
    override fun handle(context: Context) {
        context.setState(ConcreteStateA())
    }
}

class ConcreteStateB: State() {
    override fun handle(context: Context) {
        context.setState(ConcreteStateB())
    }
}

class Context(private var state: State) {
    fun getState(): State {
        return state
    }

    fun setState(state: State) {
        this.state = state
        println("当前状态：${state}")
    }

    fun request() {
        state.handle(this)
    }
}

fun main() {
    val c = Context(ConcreteStateA())
    c.request()
    c.request()
    c.request()
    c.request()
}