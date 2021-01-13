class Product {
    private val parts = mutableListOf<String>()

    fun add(part: String) {
        parts.add(part)
    }

    fun show() {
        println("\n 产品创建 -----------")
        parts.forEach(::println)
    }
}

abstract class Builder {
    abstract fun buildPartA()
    abstract fun buildPartB()
    abstract fun getResult(): Product
}

class ConcreteBuilder1: Builder() {
    private val product = Product()
    override fun buildPartA() {
        product.add("部件A")
    }

    override fun buildPartB() {
        product.add("部件B")
    }

    override fun getResult(): Product {
        return product
    }

}

class ConcreteBuilder2: Builder() {
    private val product = Product()
    override fun buildPartA() {
        product.add("部件X")
    }

    override fun buildPartB() {
        product.add("部件Y")
    }

    override fun getResult(): Product {
        return product
    }
}

class Director {
    fun construct(builder: Builder){
        builder.buildPartA()
        builder.buildPartB()
    }
}

fun main() {
    val director = Director()
    val b1 = ConcreteBuilder1()
    val b2 = ConcreteBuilder2()

    director.construct(b1)
    val p1 = b1.getResult()
    p1.show()

    director.construct(b2)
    val p2 = b2.getResult()
    p2.show()
}