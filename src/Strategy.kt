// 算法抽象类
abstract class Strategy {
    // 算法方法
    abstract fun algorithmInterface()
}

class ConcreteStrategyA: Strategy() {
    override fun algorithmInterface() {
        println("算法A实现")
    }
}

class ConcreteStrategyB: Strategy() {
    override fun algorithmInterface() {
        println("算法B实现")
    }
}

class ConcreteStrategyC: Strategy() {
    override fun algorithmInterface() {
        println("算法C实现")
    }
}

class Context(private val strategy: Strategy) {
    fun contextInterface() {
        strategy.algorithmInterface()
    }
}

// 客户端实现
fun main() {

    var context: Context = Context(ConcreteStrategyA())
    context.contextInterface()

    context = Context(ConcreteStrategyB())
    context.contextInterface()

    context = Context(ConcreteStrategyC())
    context.contextInterface()
}