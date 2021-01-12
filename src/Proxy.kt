abstract class Subject {
    abstract fun request()
}

class RealSubject: Subject() {
    override fun request() {
        println("真实的请求")
    }
}

class Proxy: Subject() {

    private lateinit var realSubject: RealSubject
    override fun request() {
        realSubject = RealSubject()
        realSubject.request()
    }
}

fun main() {
    val proxy = Proxy()
    proxy.request()
}