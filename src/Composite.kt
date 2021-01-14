package composite

abstract class Component(protected val name: String) {
    abstract fun add(c: Component)
    abstract fun remove(c: Component)
    abstract fun display(depth: Int)
}

class Leaf(name: String): Component(name) {
    override fun add(c: Component) {
        println("Cannot add to a leaf")
    }

    override fun remove(c: Component) {
        println("Cannot remove from leaf")
    }

    override fun display(depth: Int) {
        println("${"-".repeat(depth)}$name")
    }
}

class Composite(name: String): Component(name) {
    private val children = mutableListOf<Component>()

    override fun add(c: Component) {
        children.add(c)
    }

    override fun remove(c: Component) {
        children.remove(c)
    }

    override fun display(depth: Int) {
        println("${"-".repeat(depth)}$name")
        children.forEach { it.display(depth + 2) }
    }
}

fun main() {
    val root = Composite("root")
    root.add(Leaf("Leaf A"))
    root.add(Leaf("Leaf B"))

    val comp = Composite("Composite X")
    comp.add(Leaf("Leaf XA"))
    comp.add(Leaf("Leaf XB"))

    root.add(comp)

    val comp2 = Composite("Composite XY")
    comp.add(Leaf("Leaf XYA"))
    comp.add(Leaf("Leaf XYB"))

    root.add(comp2)

    root.add(Leaf("Leaf C"))

    val leafD = Leaf("Leaf D")
    root.add(leafD)
    root.remove(leafD)
    root.display(1)
}