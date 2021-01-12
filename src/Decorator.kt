abstract class Component {
    abstract fun operation()
}

class ConcreteComponent: Component() {
    override fun operation() {
        println("具体对象的操作")
    }
}

abstract class Decorator: Component() {
    private lateinit var component: Component

    fun setComponent(component: Component) {
        this.component = component
    }

    override fun operation() {
        component.operation()
    }
}

class ConcreteDecoratorA: Decorator() {
    private lateinit var addedState: String

    override fun operation() {
        super.operation()
        addedState = "New State"
        println("具体装饰对象 A 的操作")
    }
}

class ConcreteDecoratorB: Decorator() {

    override fun operation() {
        super.operation()
        addedBehavior()
        println("具体装饰对象 B 的操作")
    }

    private fun addedBehavior() {}
}

fun main() {
    val c = ConcreteComponent()
    val d1 = ConcreteDecoratorA()
    val d2 = ConcreteDecoratorB()

    d1.setComponent(c)
    d2.setComponent(d1)
    d2.operation()
}