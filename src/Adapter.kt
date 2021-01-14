package adapter

open class Target {
    open fun request() {
        println("普通请求！")
    }
}

class Adaptee {
    fun specificRequest() {
        println("普通请求！")
    }
}

class Adapter : Target() {
    private val adaptee = Adaptee()

    override fun request() {
        adaptee.specificRequest()
    }
}

fun main() {
    val target = Adapter()
    target.request()
}