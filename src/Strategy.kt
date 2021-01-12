// 算法抽象类
abstract class Strategy {
    // 算法方法
    abstract fun algorithmInteface()
}

class ConcreteStrategyA: Strategy {
    override fun algorithmInteface() {
        println("算法A实现")
    }
}

class ConcreteStrategyB: Strategy {
    override fun algorithmInteface() {
        println("算法B实现")
    }
}

class ConcreteStrategyC: Strategy {
    override fun algorithmInteface() {
        println("算法C实现")
    }
}

class Context(private val strategy: Strategy) {
    fun ContextInterface() {
        strategy.algorithmInteface()
    }
}

// 客户端实现
fun main() {
    var context: Context

    context = Context(ConcreteStrategyA)
    context.ContextInterface()

    context = Context(ConcreteStrategyB)
    context.ContextInterface()

    context = Context(ConcreteStrategyC)
    context.ContextInterface()
}