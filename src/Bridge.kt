package bridge

abstract class Implementor {
    abstract fun operation()
}

class ConcreteImplementorA: Implementor() {
    override fun operation() {
        println("具体实现 A 的方法执行")
    }
}

class ConcreteImplementorB: Implementor() {
    override fun operation() {
        println("具体实现 B 的方法执行")
    }
}

open class Abstraction {
    protected lateinit var implementor: Implementor

    internal fun setImplementor(implementor: Implementor) {
        this.implementor = implementor
    }

    open fun operation() {
        implementor.operation()
    }
}

class RefinedAbstraction: Abstraction() {
    override fun operation() {
        implementor.operation()
    }
}

fun main() {
    val ab = RefinedAbstraction()

    ab.setImplementor(ConcreteImplementorA())
    ab.operation()

    ab.setImplementor(ConcreteImplementorB())
    ab.operation()
}