abstract class Prototype(val id: String): Cloneable {
    abstract fun clone1(): Prototype
}

class ConcretePrototype1(id: String): Prototype(id) {
    override fun clone1(): Prototype {
        val c = this.clone()
        return c as ConcretePrototype1
    }
}

fun main() {
    val p1 = ConcretePrototype1("I")
    val c1 = p1.clone1() as ConcretePrototype1
    println("Cloned: ${c1.id}")
}