abstract class AbstractClass {
    abstract fun primitiveOperation1()
    abstract fun primitiveOperation2()

    fun templateMethod() {
        primitiveOperation1()
        primitiveOperation1()
        println("")
    }
}

class ConcreteClassA: AbstractClass() {
    override fun primitiveOperation1() {
        println("具体类 A 方法 1 实现")
    }

    override fun primitiveOperation2() {
        println("具体类 A 方法 2 实现")
    }
}

class ConcreteClassB: AbstractClass() {
    override fun primitiveOperation1() {
        println("具体类 B 方法 1 实现")
    }

    override fun primitiveOperation2() {
        println("具体类 B 方法 2 实现")
    }
}

fun main() {
    var c: AbstractClass = ConcreteClassA()
    c.templateMethod()
    c = ConcreteClassB()
    c.templateMethod()
}