package visitor

abstract class Visitor {
    abstract fun visitConcreteElementA(concreteElementA: ConcreteElementA)
    abstract fun visitConcreteElementB(concreteElementB: ConcreteElementB)
}

class ConcreteVisitorA: Visitor() {
    override fun visitConcreteElementA(concreteElementA: ConcreteElementA) {
        println("$concreteElementA 被 $this 访问")
    }

    override fun visitConcreteElementB(concreteElementB: ConcreteElementB) {
        println("$concreteElementB 被 $this 访问")
    }
}

class ConcreteVisitorB: Visitor() {
    override fun visitConcreteElementA(concreteElementA: ConcreteElementA) {
        println("$concreteElementA 被 $this 访问")
    }

    override fun visitConcreteElementB(concreteElementB: ConcreteElementB) {
        println("$concreteElementB 被 $this 访问")
    }
}

abstract class Element{
    abstract fun accept(visitor: Visitor)
}

class ConcreteElementA: Element() {
    override fun accept(visitor: Visitor) {
        visitor.visitConcreteElementA(this)
    }

    fun operationA() {}
}

class ConcreteElementB: Element() {
    override fun accept(visitor: Visitor) {
        visitor.visitConcreteElementB(this)
    }

    fun operationA() {}
}

class ObjectStructure {
    private val elements =  mutableListOf<Element>()

    fun attach(element: Element) {
        elements.add(element)
    }

    fun detach(element: Element) {
        elements.remove(element)
    }

    fun accept(visitor: Visitor) {
        elements.forEach { it.accept(visitor) }
    }
}

fun main() {
    val o = ObjectStructure()
    o.attach(ConcreteElementA())
    o.attach(ConcreteElementB())

    val v1 = ConcreteVisitorA()
    val v2 = ConcreteVisitorB()

    o.accept(v1)
    o.accept(v2)
}