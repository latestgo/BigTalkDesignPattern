package chainofres

abstract class Handler {
    protected var successor: Handler? = null

    internal fun setSuccessor(successor: Handler?) {
        this.successor = successor
    }

    abstract fun handleRequest(request: Int)
}

class ConcreteHandlerA: Handler() {
    override fun handleRequest(request: Int) {
        if (request >= 0 && request < 10) {
            println("$this 处理请求 $request")
        } else {
            successor?.handleRequest(request)
        }
    }
}

class ConcreteHandlerB: Handler() {
    override fun handleRequest(request: Int) {
        if (request >= 10 && request < 20) {
            println("$this 处理请求 $request")
        } else {
            successor?.handleRequest(request)
        }
    }
}

class ConcreteHandlerC: Handler() {
    override fun handleRequest(request: Int) {
        if (request >= 20 && request < 30) {
            println("$this 处理请求 $request")
        } else {
            successor?.handleRequest(request)
        }
    }
}

fun main() {
    val h1 = ConcreteHandlerA()
    val h2 = ConcreteHandlerB()
    val h3 = ConcreteHandlerC()

    h1.setSuccessor(h2)
    h2.setSuccessor(h3)

    val requests = arrayOf(2, 5, 14, 16, 25, 28)
    requests.forEach {
        h1.handleRequest(it)
    }
}