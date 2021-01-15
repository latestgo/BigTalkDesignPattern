package flyweight

abstract class Flyweight {
    abstract fun operation(extrinsicstate: Int)
}

class ConcreteFlyweight: Flyweight() {
    override fun operation(extrinsicstate: Int) {
        println("具体 Flyweight: $extrinsicstate")
    }
}

class UnsharedConcreteFlyweight: Flyweight() {
    override fun operation(extrinsicstate: Int) {
        println("不共享的具体 Flyweight: $extrinsicstate")
    }
}

class FlyweightFactory {
    private val flyweights = mutableMapOf<String, Flyweight>()

    init {
        flyweights["X"] = ConcreteFlyweight()
        flyweights["Y"] = ConcreteFlyweight()
        flyweights["Z"] = ConcreteFlyweight()
    }

    fun getFlyweight(key: String): Flyweight? {
        return flyweights[key]
    }
}

fun main() {
    var extrinsicstate = 22

    val f = FlyweightFactory()

    val fx = f.getFlyweight("X")
    fx?.operation(--extrinsicstate)

    val fy = f.getFlyweight("Y")
    fy?.operation(--extrinsicstate)

    val fz = f.getFlyweight("Z")
    fz?.operation(--extrinsicstate)

    val uf = UnsharedConcreteFlyweight()

    uf.operation(--extrinsicstate)
}